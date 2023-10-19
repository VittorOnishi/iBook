package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandAlterarCarrinho implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		fac.alterarItemDoCarrinho(entidade);
		
		return rstd;
	}

}
