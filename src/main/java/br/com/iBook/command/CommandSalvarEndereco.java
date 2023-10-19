package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Usuario;
import br.com.iBook.fachada.Fachada;

public class CommandSalvarEndereco implements ICommand {

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		Fachada fac2 = new Fachada();
		
		rstd.setMsg(fac.salvar(entidade));
		
		Endereco endereco = (Endereco) entidade;
		
		Usuario usuario = new Usuario();
		
		usuario.setId(endereco.getEnderecoUsuarioId());
		
		rstd.setEntidade(fac2.consultaUnica(usuario));
		
		return rstd;
		
	}

}
