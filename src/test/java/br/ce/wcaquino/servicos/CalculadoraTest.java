package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.servicos.exceptions.NaoPodeDividirPorZeroException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CalculadoraTest {
	
	private Calculadora calc;
	
	@Before
	public void before() {
		calc = new Calculadora();
	}
	
	@Test
	public void t1_testarSoma() {
		
		//Cenário
		int x = 6;
		int y = 8;
		
		//Ação
		int resultado = calc.somar(x, y);
		
		//Verificação
		assertThat(resultado, is(14));
		
	}
	
	@Test
	public void t2_testarSubtracao() {
		
		//Cenário
		int x = 10;
		int y = 5;
		
		//Ação
		int resultado = calc.subtrair(x, y);
		
		//Verificação
		assertThat(resultado, is(5));
		
	}
	
	@Test
	public void t3_testarMultiplicacao() {
		
		//Cenário
		int x = 2;
		int y = 5;
		
		//Ação
		int resultado = calc.multiplicar(x, y);
		
		//Verificacão
		assertThat(resultado, is(10));
	}
	
	
	@Test
	public void t4_testarDivisaoNormal() throws NaoPodeDividirPorZeroException {
		
		//Cenário
		int x = 10;
		int y = 5;
		
		//Ação
		int resultado = calc.dividir(x, y);		
		
		//Verificação
		assertThat(resultado, is(2));
		
				
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void t5_testarExcecaoDivisao() throws Exception {
		
		//Cenário
		int x = 10;
		int y = 0;
		
		//Ação
		calc.dividir(x, y);
		
				
	}
	
	
	@Test
	public void t6_testarExcecaoDivisaoMensagem() throws NaoPodeDividirPorZeroException {
		
		//Cenário
		int x = 10;
		int y = 0;
		
		//Ação
		try {
		    calc.dividir(x, y);		
			//Verificação
			Assert.fail("Deve dar exceção");
		} catch (Exception e) {
			//Verificação
			assertThat(e.getMessage(), is("Não é possível dividir por zero."));
		}
				
	}

}
