package br.com.iBook.command;

import java.util.List;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.Usuario;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandConsultar implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Fachada fac = new Fachada();
		
		Resultado rstd = new Resultado();
		
		List<EntidadeDominio> listaClientes = fac.consultar(entidade);
		
		rstd.setEntidades(listaClientes);
		
		return rstd;
	}

}
