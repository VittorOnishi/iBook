package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;

public interface ICommand {

	public Resultado execute(EntidadeDominio entidade);
}
