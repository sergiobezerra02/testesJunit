package br.ce.wcaquino.servicos.exceptions;

public class NaoPodeDividirPorZeroException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NaoPodeDividirPorZeroException(String msg) {
		super(msg);
	}

}
