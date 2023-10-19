package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandCalcularFrete implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		rstd.setEntidade(fac.calcularFrete(entidade));
		
		return rstd;
	}

}
