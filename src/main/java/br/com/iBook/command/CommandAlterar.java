package br.com.iBook.command;

import java.util.List;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandAlterar implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		Fachada fac = new Fachada();
		
		Resultado rstd = new Resultado();
		
		rstd.setMsg(fac.alterar(entidade));
		
		return rstd;
	}

}
