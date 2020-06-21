package br.ce.wcaquino.servicos;

import br.ce.wcaquino.dao.CalculadoraConsultarResultadoDAO;
import br.ce.wcaquino.dao.CalculadoraDAO;
import br.ce.wcaquino.dao.CalculadoraValorSoma;
import br.ce.wcaquino.servicos.exceptions.CalculadoraException;
import br.ce.wcaquino.servicos.exceptions.NaoPodeDividirPorZeroException;

public class CalculadoraService {
	
	private CalculadoraDAO calculadoraDAO;
	private CalculadoraValorSoma calculadoraValorSoma;
	private CalculadoraConsultarResultadoDAO calculadoraConsultarResultadoDAO;

	public int somar(int x, int y) throws CalculadoraException {
		Integer resultado = x + y;
		for(int i = 0; i < 4; i++) {
		calculadoraDAO.save(resultado);
		calculadoraConsultarResultadoDAO.consultarResultado(resultado);
		}
		return resultado;
		
	}

	public int subtrair(int x, int y) {		
		Integer resultado = x - y;
		calculadoraDAO.save(resultado);
		calculadoraConsultarResultadoDAO.consultarResultado(resultado);
		return x - y;
	}

	public int multiplicar(int x, int y) {	
		Integer resultado = x * y;
		calculadoraDAO.save(resultado);
		return x * y;
	}

	public int dividir(int x, int y) throws NaoPodeDividirPorZeroException {
		if(y == 0) {
			throw new NaoPodeDividirPorZeroException("Não é possível dividir por zero.");
		}
		Integer resultado = x / y;
		calculadoraDAO.save(resultado);
		return x / y;
	}
	
	public boolean validarValorSomaTetarMock() throws CalculadoraException {
		Integer valor = 1;
		if(calculadoraValorSoma.valorSoma(valor)) {
			throw new CalculadoraException("Atenção! Resultado = " + valor);
		}
		return false;
	}
	
	public void setCalculadoraConsultarResultadoDAO(CalculadoraConsultarResultadoDAO calculadoraConsultarResultadoDAO) {
		this.calculadoraConsultarResultadoDAO = calculadoraConsultarResultadoDAO;
	}
	
	public void setCalculaoraDAO(CalculadoraDAO calculadoraDAO) {
		this.calculadoraDAO = calculadoraDAO;
	}
	
	public void setCalculadoraValorSoma(CalculadoraValorSoma calculadoraValorSoma) {
		this.calculadoraValorSoma = calculadoraValorSoma;
	}

}
