package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandMontaGrafico implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {

		Fachada fac = new Fachada();
		
		Resultado rstd = new Resultado();
		
		rstd.setEntidade(fac.consultaGrafico(entidade));
		
		return rstd;
	}

}
