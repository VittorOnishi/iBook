package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandExcluir implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		rstd.setMsg(fac.excluir(entidade));
		
		rstd.setNextPage("forward:paginaConsultaClientes.jsp");
		
		return rstd;
	}

}
