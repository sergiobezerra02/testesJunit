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
		
		//Cen�rio
		int x = 6;
		int y = 8;
		
		//A��o
		int resultado = calc.somar(x, y);
		
		//Verifica��o
		assertThat(resultado, is(14));
		
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

}
