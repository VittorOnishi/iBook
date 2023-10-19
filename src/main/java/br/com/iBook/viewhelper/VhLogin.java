package br.com.iBook.viewhelper;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Login;
import br.com.iBook.dominio.Usuario;

public class VhLogin implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		
		Login login = new Login(request.getParameter("email"), request.getParameter("senha"));
		
		Usuario usuario = new Usuario();
		
		usuario.setLogin(login);
		
		return usuario;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		if(request.getParameter("acao").equals("Continuar") ||
		   request.getParameter("acao").equals("CadastrarEndereco") ||
		   request.getParameter("acao").equals("CadastrarCartao") ||
		   request.getParameter("acao").equals("Perfil")) {
			
			System.out.println("inciando sessão");
			Usuario usuario = (Usuario)entDom;
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
		}
	}

}
