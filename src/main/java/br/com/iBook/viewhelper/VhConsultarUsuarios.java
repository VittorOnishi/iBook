package br.com.iBook.viewhelper;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.Usuario;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Telefone;

public class VhConsultarUsuarios implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		
		Usuario usuario = new Usuario(request.getParameter("paramBuscaCliente"));
		
		return usuario;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {

		request.setAttribute("EntidadeDominio", entDom);
		

	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

	}

}
