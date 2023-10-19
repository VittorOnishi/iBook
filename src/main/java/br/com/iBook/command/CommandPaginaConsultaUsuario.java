package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;

public class CommandPaginaConsultaUsuario implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Resultado rstd = new Resultado();
		
		rstd.setNextPage("forward:paginaConsultaClientes.jsp");
		
		return rstd;
	}

}
