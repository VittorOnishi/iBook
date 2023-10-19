package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandPefil implements ICommand{

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		fac.consultaUnica(entidade);
		
		return rstd;
	}

}
