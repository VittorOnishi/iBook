package br.com.iBook.viewhelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.Cidade;
import br.com.iBook.dominio.Usuario;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Estado;
import br.com.iBook.dominio.Login;
import br.com.iBook.dominio.Pais;
import br.com.iBook.dominio.Telefone;

public class VhAlterarUsuario implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		
		String paramDataNascimento = request.getParameter("dataNasc");
		Date dataNasc = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dataNasc = sdf.parse(paramDataNascimento);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		if(request.getParameter("senha").equals(request.getParameter("senhaConfirmacao"))) {
			Login login = new Login(request.getParameter("e-mail"), request.getParameter("senha"));
			
			Telefone telefone = new Telefone(request.getParameter("telefone"), request.getParameter("tipoTelefone"));
			
			if(request.getParameter("tel_id") != null 
					   && !request.getParameter("tel_id").equals("")) {
							
						telefone.setId(Integer.valueOf(request.getParameter("tel_id")));
						
					}
		
			Usuario usuario = new Usuario(request.getParameter("nomeCliente")
				, request.getParameter("genero")
				, request.getParameter("cpf")
				, dataNasc
				, login);
			
			if(request.getParameter("id") != null 
			&& !request.getParameter("id").equals("")) {
							
						usuario.setId(Integer.valueOf(request.getParameter("id")));
						
					}
			
		usuario.setListadeTelefones(telefone);
		
		return usuario;
		}
		
		return null;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

	}

}
