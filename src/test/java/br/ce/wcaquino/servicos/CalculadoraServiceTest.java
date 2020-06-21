package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;

import br.ce.wcaquino.dao.CalculadoraDAO;
import br.ce.wcaquino.dao.CalculadoraValorSoma;
import br.ce.wcaquino.servicos.exceptions.CalculadoraException;
import br.ce.wcaquino.servicos.exceptions.NaoPodeDividirPorZeroException;
import builder.CalculadoraBuilder;
import matchers.MatcherPessoal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculadoraServiceTest {
	
	private CalculadoraService calc;
	private CalculadoraValorSoma calculadoraValorSoma;
	
	@Before
	public void before() {
		
		calc = CalculadoraBuilder.getCalculadora().agora();
		
		CalculadoraDAO calculaDAO = Mockito.mock(CalculadoraDAO.class);
		calc.setCalculaoraDAO(calculaDAO);
		
		calculadoraValorSoma = Mockito.mock(CalculadoraValorSoma.class);
		calc.setCalculadoraValorSoma(calculadoraValorSoma);
	}
	
	@Test
	public void t1_testarSoma() throws CalculadoraException {
		
		//Cen�rio
		int x = 6;
		int y = 8;
		
		//A��o
		int resultado = calc.somar(x, y);
		
		//Verifica��o	
		assertThat(resultado, is(14));
		assertThat(resultado, MatcherPessoal.validaResultado(14));
		
	}
	
	@Test
	public void t2_testarSubtracao() {
		
		//Cen�rio
		int x = 10;
		int y = 5;
		
		//A��o
		int resultado = calc.subtrair(x, y);
		
		//Verifica��o
		assertThat(resultado, is(5));
		assertThat(resultado, MatcherPessoal.validaResultado(5));
		
	}
	
	@Test
	public void t3_testarMultiplicacao() {
		
		//Cen�rio
		int x = 2;
		int y = 5;
		
		//A��o
		int resultado = calc.multiplicar(x, y);
		
		//Verificac�o
		assertThat(resultado, is(10));
		assertThat(resultado, MatcherPessoal.validaResultado(10));
	}
	
	
	@Test
	public void t4_testarDivisaoNormal() throws NaoPodeDividirPorZeroException {
		
		//Cen�rio
		int x = 10;
		int y = 5;
		
		//A��o
		int resultado = calc.dividir(x, y);		
		
		//Verifica��o
		assertThat(resultado, is(2));
		assertThat(resultado, MatcherPessoal.validaResultado(2));
		
				
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void t5_testarExcecaoDivisao() throws Exception {
		
		//Cen�rio
		int x = 10;
		int y = 0;
		
		//A��o
		calc.dividir(x, y);
				
	}
	
	
	@Test
	public void t6_testarExcecaoDivisaoMensagem() throws NaoPodeDividirPorZeroException {
		
		//Cen�rio
		int x = 10;
		int y = 0;
		
		//A��o
		try {
		    calc.dividir(x, y);		
			//Verifica��o
			Assert.fail("Deve dar exce��o");
		} catch (Exception e) {
			//Verifica��o
			assertThat(e.getMessage(), is("N�o � poss�vel dividir por zero."));
		}
				
	}
	
	@Test
	public void t7_testarMock() throws CalculadoraException {
		
		//Cen�rio
		int x = 4;
		int y = 8;
		
		//A��o
		calc.somar(x, y);
		
		Mockito.when(calc.validarValorSomaTetarMock()).thenReturn(true);
		
		//Verifica��o
		assertThrows(CalculadoraException.class, () -> calc.validarValorSomaTetarMock());	
		
	}

}
