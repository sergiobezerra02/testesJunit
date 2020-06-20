package builder;

import br.ce.wcaquino.servicos.Calculadora;

public class CalculadoraBuilder {
	
	private static Calculadora calculadora;
	private static CalculadoraBuilder calculadoraBuilder;
	
	private CalculadoraBuilder() {}
	
	public static CalculadoraBuilder getCalculadora() {
		
		if(calculadoraBuilder == null) {
			calculadoraBuilder = new CalculadoraBuilder();
		}			
		if(calculadora == null) {
			calculadoraBuilder.calculadora = new Calculadora();
		}
		
		return calculadoraBuilder;
	}
	
	public Calculadora agora() {
		return this.calculadora;
	}

}
