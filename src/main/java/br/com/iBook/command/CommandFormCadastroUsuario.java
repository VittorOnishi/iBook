package br.com.iBook.command;

import java.util.ArrayList;
import java.util.List;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.BandeiraCartao;
import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.fachada.Fachada;

public class CommandFormCadastroUsuario implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		BandeiraCartao bandeira = new BandeiraCartao();
		
		rstd.setEntidades(fac.consultar(bandeira));
		
		rstd.setNextPage("forward:formCadastroCliente.jsp");
		
		return rstd;
	}

}
