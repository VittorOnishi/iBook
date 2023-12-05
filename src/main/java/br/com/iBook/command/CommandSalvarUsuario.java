package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Usuario;
import br.com.iBook.fachada.Fachada;

public class CommandSalvarUsuario implements ICommand {

	private static Integer idCliente;
	
	
	
	public static Integer getIdCliente() {
		return idCliente;
	}

	public static void setIdCliente(Integer idCliente) {
		CommandSalvarUsuario.idCliente = idCliente;
	}

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Usuario usuario = (Usuario)entidade;
		
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		rstd.setMsg(fac.salvar(usuario));
		
		Fachada fac2 = new Fachada();
		
		Usuario usuarioConsultado = new Usuario();
		
		usuarioConsultado.setId(idCliente);
		
		rstd.setEntidade(fac2.consultaUnica(usuarioConsultado));
		
		return rstd;	
	}

}
