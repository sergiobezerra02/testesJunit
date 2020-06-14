package br.ce.wcaquino.servicos;

import br.ce.wcaquino.servicos.exceptions.NaoPodeDividirPorZeroException;

public class Calculadora {

	public int somar(int x, int y) {		
		return x + y;
	}

	public int subtrair(int x, int y) {		
		return x - y;
	}

	public int multiplicar(int x, int y) {	
		return x * y;
	}

	public int dividir(int x, int y) throws NaoPodeDividirPorZeroException {
		if(y == 0) {
			throw new NaoPodeDividirPorZeroException("Não é possível dividir por zero.");
		}
		return x / y;
	}

}
