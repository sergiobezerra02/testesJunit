package br.ce.wcaquino.dao;

public class CalculadoraFakeDAO implements CalculadoraDAO{

	@Override
	public void save(Integer resultado) {
		
		System.out.println("Resposta salva = " + resultado);
		
	}

}
