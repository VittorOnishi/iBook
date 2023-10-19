package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Pedido;
import br.com.iBook.fachada.Fachada;

public class CommandSalvarCompra implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Fachada fac = new Fachada();
		
		Fachada fac2 = new Fachada();
		
		Resultado rstd = new Resultado();
		
		fac.salvar(entidade);
		
		rstd.setEntidades(fac2.consultar(entidade));
		
		return rstd;
	}

}
