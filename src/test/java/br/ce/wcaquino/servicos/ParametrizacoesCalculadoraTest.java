package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import br.ce.wcaquino.dao.CalculadoraConsultarResultadoDAO;
import br.ce.wcaquino.dao.CalculadoraDAO;
import br.ce.wcaquino.dao.CalculadoraValorSoma;
import br.ce.wcaquino.servicos.exceptions.CalculadoraException;
import builder.CalculadoraBuilder;

@RunWith(Parameterized.class)
public class ParametrizacoesCalculadoraTest {
	
	private CalculadoraService calc;
	private CalculadoraValorSoma calculadoraValorSoma;
	private CalculadoraDAO calculaDAO;
	private CalculadoraConsultarResultadoDAO calculadoraConsultarResultadoDAO;
	
	@Before
	public void setup() {
		
		calc = CalculadoraBuilder.getCalculadora().agora();
		
		calculadoraValorSoma = Mockito.mock(CalculadoraValorSoma.class);
		calc.setCalculadoraValorSoma(calculadoraValorSoma);
		
		calculaDAO = Mockito.mock(CalculadoraDAO.class);
		calc.setCalculaoraDAO(calculaDAO);
		
		calculadoraConsultarResultadoDAO = Mockito.mock(CalculadoraConsultarResultadoDAO.class);
		calc.setCalculadoraConsultarResultadoDAO(calculadoraConsultarResultadoDAO);
		
	}
	
	@Parameter
	public Integer primeiroNumero;
	
	@Parameter(value=1)
	public Integer segundoNumero;
	
	@Parameter(value=2)
	public Integer resultadoFinal;
	
	@Parameter(value=3)
	public String ordemTeste;
	
	@Parameters(name="{3}")
	public static Collection<Object[]> getParametros(){
		
		return Arrays.asList(new Object[][] {
								{ 5 , 5 , 10 , "Teste01" },
								{ 1 , 5 , 6  , "Teste02" },
								{ 6 , 20 , 26, "Teste03" },
								{ 1 , 0 , 1  , "Teste04" }												
							});
		
	}
	
	
	@Test
	public void testarVerificacaoMockito() throws CalculadoraException {
		
		//Cenário
		//@Before + @Parameters
		
		//Ação		
		int resultado = calc.somar(primeiroNumero, segundoNumero);
		calc.validarValorSomaTetarMock();
				
		//Verificação
	    assertThat(resultado, is(resultadoFinal));
		Mockito.when(calc.validarValorSomaTetarMock()).thenReturn(true);
		assertThrows(CalculadoraException.class, () -> calc.validarValorSomaTetarMock());	
		Mockito.verify(calculadoraConsultarResultadoDAO, Mockito.atLeastOnce()).consultarResultado(resultado);
		Mockito.verify(calculadoraConsultarResultadoDAO, Mockito.atLeast(4)).consultarResultado(resultado);	
		Mockito.verify(calculaDAO, Mockito.atLeastOnce()).save(resultado);
		Mockito.verifyNoMoreInteractions(calculadoraConsultarResultadoDAO);
		
		
	}
	

}
