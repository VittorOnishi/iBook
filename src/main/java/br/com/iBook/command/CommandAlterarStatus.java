package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Pedido;
import br.com.iBook.fachada.Fachada;

public class CommandAlterarStatus implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Fachada fac = new Fachada();
		
		Fachada fac2 = new Fachada();
		
		Resultado rstd = new Resultado();
		
		if(entidade.getClass().getName().equals(Pedido.class.getName())) {
			
			Pedido pedido = (Pedido)entidade;
			
			if(pedido.getItem().getId()!= null) {
				
				rstd.setMsg(fac.alterar(pedido.getItem()));
			
				rstd.setEntidade(fac2.consultaUnica(pedido));
				
				return rstd;
			
			}else {

				rstd.setMsg(fac.alterar(pedido));
				
				Pedido pedido2 = new Pedido();
				
				rstd.setEntidades(fac2.consultar(pedido2));
				
				return rstd;
			}
			
		}else {
			
			rstd.setMsg(fac.alterar(entidade));
			
			rstd.setEntidade(fac2.consultaUnica(entidade));
			
			return rstd;
		}
	}

}
