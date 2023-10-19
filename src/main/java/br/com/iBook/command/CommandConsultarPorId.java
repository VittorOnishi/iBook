package br.com.iBook.command;

import java.util.List;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.BandeiraCartao;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandConsultarPorId implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Fachada fac = new Fachada();
		
		Resultado rstd = new Resultado();
		
		BandeiraCartao bnd = new BandeiraCartao();
		
		List<EntidadeDominio> listaClientes = fac.consultar(bnd);
		
		Fachada fac2 = new Fachada();
	
		EntidadeDominio entDom = fac2.consultaUnica(entidade);
		
		rstd.setEntidade(entDom);
		
		rstd.setEntidades(listaClientes);
		
		return rstd;
	}

}
