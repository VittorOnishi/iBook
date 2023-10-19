package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;
import br.com.iBook.strategy.IStrategy;

public class CommandRemoverDoCarrinho implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		fac.removerItensDoCarrinho(entidade);
		
		return rstd;
	}

}
