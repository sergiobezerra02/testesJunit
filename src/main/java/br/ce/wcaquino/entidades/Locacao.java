package br.ce.wcaquino.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Locacao {

	private Usuario usuario;
	private List<Filme> listaFilmes;
	private Date dataLocacao;
	private Date dataRetorno;
	private Double valor;
	
	public Locacao() {
		super();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getDataLocacao() {
		return dataLocacao;
	}
	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	public Date getDataRetorno() {
		return dataRetorno;
	}
	public void setDataRetorno(Date dataRetorno) {
		this.dataRetorno = dataRetorno;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public List<Filme> getFilme() {
		if(this.listaFilmes == null) {
			listaFilmes = new ArrayList<>();
		}
		return listaFilmes;
	}
	public void setFilme(List<Filme> lista) {
		this.listaFilmes = lista;
	}
}