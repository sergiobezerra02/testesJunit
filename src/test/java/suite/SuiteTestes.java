package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.servicos.CalculadoraTest;
import br.ce.wcaquino.servicos.LocacaoServiceTest;
import br.ce.wcaquino.servicos.ParametrizacoesTest;

@RunWith(Suite.class)
@SuiteClasses({
	CalculadoraTest.class,
	LocacaoServiceTest.class,
	ParametrizacoesTest.class		       		
})
public class SuiteTestes {
    //Remover se puder
}
