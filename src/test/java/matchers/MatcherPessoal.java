package matchers;

public class MatcherPessoal {
	
	public static NumeroMatcher validaResultado(Integer valor) {
		return new NumeroMatcher(valor);
	}

}
