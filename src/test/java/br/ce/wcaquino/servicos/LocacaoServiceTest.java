package br.ce.wcaquino.servicos;


import static br.ce.wcaquino.utils.DataUtils.isMesmaData;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
//import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;

import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.servicos.exceptions.LocadoraException;
import br.ce.wcaquino.utils.DataUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocacaoServiceTest {
	
	private LocacaoService ls1;
	
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
//	@Rule
//	public ExpectedException exception = ExpectedException.none(); //JUnit 4
	
	
	@Before
	public void before() {
		ls1 = new LocacaoService();
	}
	
//	@After
//	public void after() {
//		System.out.println("After");
//	}
//	
//	@BeforeClass
//	public static void beforeClass() {
//		System.out.println("BeforeClass");
//	}
//	
//	@AfterClass
//	public static void afterClass() {
//		System.out.println("AfterClass");
//	}
	
	
	@Test
	public void test() throws Exception {
		
		//Cenário
		Usuario u1 = new Usuario("Paulo");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 1, 5.0));
				
		//Ação		
		Locacao locacao = ls1.alugarFilme(u1, filmes);
		
		//Verificação			
		error.checkThat(locacao.getValor(), is(equalTo(5.0)));		
		error.checkThat(isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		error.checkThat(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));		
			
	}
	
	@Test(expected = FilmeSemEstoqueException.class)
	public void forma_Elegante_Tratar_Excecao() throws Exception {
		
		//Cenário
		Usuario u1 = new Usuario("Paulo");
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 4.0));
				
		//Ação		
		ls1.alugarFilme(u1, filmes);		
		
	}
	
	@Test
	public void forma_Robusta_Tratar_Excecao() throws FilmeSemEstoqueException{
	
		//Cenário
		List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 1, 5.0));
						
		//Ação		
		try {
			ls1.alugarFilme(null, filmes);
			Assert.fail("Deveria dar exceção");  //Controle caso não dê exceção
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuario vazio.")); //Barra verde confirmando exceção
		}	
	}
	
	@Test
	public void forma_Mais_Recente_Tratar_Excecao() throws FilmeSemEstoqueException, LocadoraException {
		
		//Cenário
		Usuario u1 = new Usuario("Paulo");
		ls1 = new LocacaoService();
		
		//JUnit 4
//		exception.expect(Exception.class);
//		exception.expectMessage("Filme sem estoque");
		
		//Ação
//		ls1.alugarFilme(u1, f1);
		
		//Ação	Verificação JUnit 5
		assertThrows(LocadoraException.class, () -> ls1.alugarFilme(u1, null));			
			
	}


}
