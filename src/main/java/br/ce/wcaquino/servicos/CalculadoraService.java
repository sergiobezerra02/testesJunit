package br.ce.wcaquino.servicos;

import br.ce.wcaquino.dao.CalculadoraDAO;
import br.ce.wcaquino.dao.CalculadoraValorSoma;
import br.ce.wcaquino.servicos.exceptions.CalculadoraException;
import br.ce.wcaquino.servicos.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraService {
	
	private CalculadoraDAO calculadoraDAO;
	private CalculadoraValorSoma calculadoraValorSoma;

	public int somar(int x, int y) throws CalculadoraException {
		Integer resultado = x + y;
		calculadoraDAO.save(resultado);
		return resultado;
	}

	public int subtrair(int x, int y) {		
		calculadoraDAO.save(x - y);
		return x - y;
	}

	public int multiplicar(int x, int y) {	
		calculadoraDAO.save(x * y);
		return x * y;
	}

	public int dividir(int x, int y) throws NaoPodeDividirPorZeroException {
		if(y == 0) {
			throw new NaoPodeDividirPorZeroException("N�o � poss�vel dividir por zero.");
		}
		calculadoraDAO.save(x / y);
		return x / y;
	}
	
	public boolean validarValorSomaTetarMock() throws CalculadoraException {
		Integer valor = 1;
		if(calculadoraValorSoma.valorSoma(valor)) {
			throw new CalculadoraException("Aten��o! Resultado = " + valor);
		}
		return false;
	}
	
	public void setCalculaoraDAO(CalculadoraDAO calculadoraDAO) {
		this.calculadoraDAO = calculadoraDAO;
	}
	
	public void setCalculadoraValorSoma(CalculadoraValorSoma calculadoraValorSoma) {
		this.calculadoraValorSoma = calculadoraValorSoma;
	}

}
