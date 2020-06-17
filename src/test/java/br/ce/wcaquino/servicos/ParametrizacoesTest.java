package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParametrizacoesTest {
	
	
	private Calculadora calc;
	
	@Parameter
	public Integer primeiroNumero;
	
	@Parameter(value=1)
	public Integer segundoNumero;
	
	@Parameter(value=2)
	public Integer resultadoFinal;
	
	@Parameter(value=3)
	public String cenario;
	
	@Before
	public void start() {
		calc = new Calculadora();
	}
	
	
	
	@Parameters(name= "{3}")
	public static Collection<Object[]> getParametros(){
		
		return Arrays.asList(new Object[][] {
								{ 0 , 1 , 1 , "Teste 01" },
								{ 1 , 1 , 2 , "Teste 02" },
								{ 1 , 2 , 3 , "Teste 03" },
								{ 2 , 3 , 5 , "Teste 04" },
								{ 3 , 5 , 8 , "Teste 05" }
							});
		
	}
	
	@Test
	public void t1_testarSoma() {
		
		//Cenário
		//@Before
		
		//Ação
		int resultado = calc.somar(primeiroNumero, segundoNumero);
		
		//Verificação
		assertThat(resultado, is(resultadoFinal));
		
	}

}
