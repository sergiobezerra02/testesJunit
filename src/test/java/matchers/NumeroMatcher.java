package matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class NumeroMatcher extends TypeSafeMatcher<Integer> {
	
	private Integer valorResultado;
	
	public NumeroMatcher(Integer valor) {
		this.valorResultado = valor;
	}

	@Override
	public void describeTo(Description description) {
		description.appendText(valorResultado.toString());
	}

	@Override
	protected boolean matchesSafely(Integer item) {	
		
		if(valorResultado == item) {
		  return true;
		}else {
		  return false;
		}
		
	}

}
