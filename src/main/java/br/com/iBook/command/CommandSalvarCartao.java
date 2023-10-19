package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Usuario;
import br.com.iBook.fachada.Fachada;

public class CommandSalvarCartao implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		Fachada fac2 = new Fachada();
		
		rstd.setMsg(fac.salvar(entidade));
		
		CartaoDeCredito cartao = (CartaoDeCredito) entidade;
		
		Usuario usuario = new Usuario();
		
		usuario.setId(cartao.getCartaoUsuarioId());
		
		rstd.setEntidade(fac2.consultaUnica(usuario));
		
		return rstd;

	}

}
