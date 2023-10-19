package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Usuario;
import br.com.iBook.fachada.Fachada;

public class CommandSalvar implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		rstd.setMsg(fac.salvar(entidade));
		
		return rstd;
	}

}
