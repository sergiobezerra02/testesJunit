package br.ce.wcaquino.servicos;

import static br.ce.wcaquino.utils.DataUtils.adicionarDias;

import java.util.Date;
import java.util.List;

import br.ce.wcaquino.dao.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.servicos.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.servicos.exceptions.LocadoraException;

public class LocacaoService {
	
	private LocacaoDAO dao;
	
	public Locacao alugarFilme(Usuario usuario, List<Filme> listaFilme) throws LocadoraException, FilmeSemEstoqueException  {
		
		if(usuario == null) {
			throw new LocadoraException("Usuario vazio.");
		}
		
		if(listaFilme == null || listaFilme.isEmpty()) {
			throw new LocadoraException("Filme vazio.");
		}
		
		for(Filme filme: listaFilme) {
			if(filme.getEstoque() == 0) {
				throw new FilmeSemEstoqueException("Filme n„o encontra-se no estoque.");
			}
		}
	
		
		Locacao locacao = new Locacao();
		locacao.setFilme(listaFilme);
		locacao.setUsuario(usuario);
		locacao.setDataLocacao(new Date());
		Double valorTotal = 0d;
		for(Filme filme: listaFilme) {
			valorTotal += filme.getPrecoLocacao();
		}
		locacao.setValor(valorTotal);
		

		//Entrega no dia seguinte
		Date dataEntrega = new Date();
		dataEntrega = adicionarDias(dataEntrega, 1);
		locacao.setDataRetorno(dataEntrega);
		
		//Salvando a locacao...	
		//TODO adicionar m√©todo para salvar
		dao.save(locacao);
		
		return locacao;
	}

	public void setLocacaoDAO(LocacaoDAO dao) {
		this.dao = dao;
	}
	
}