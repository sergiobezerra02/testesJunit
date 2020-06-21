package builder;

import br.ce.wcaquino.servicos.CalculadoraService;

public class CalculadoraBuilder {
	
	private static CalculadoraService calculadora;
	private static CalculadoraBuilder calculadoraBuilder;
	
	private CalculadoraBuilder() {}
	
	public static CalculadoraBuilder getCalculadora() {
		
		if(calculadoraBuilder == null) {
			calculadoraBuilder = new CalculadoraBuilder();
		}			
		if(calculadora == null) {
			calculadoraBuilder.calculadora = new CalculadoraService();
		}
		
		return calculadoraBuilder;
	}
	
	public CalculadoraService agora() {
		return this.calculadora;
	}

}
