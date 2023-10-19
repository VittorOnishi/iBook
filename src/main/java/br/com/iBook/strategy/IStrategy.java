package br.com.iBook.strategy;

import br.com.iBook.dominio.EntidadeDominio;

public interface IStrategy {
	public String processar(EntidadeDominio entidade);
}
