package br.com.iBook.viewhelper;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iBook.dominio.Cidade;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Estado;
import br.com.iBook.dominio.Pais;
import br.com.iBook.dominio.Usuario;

public class VhEndereco implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
	if(request.getParameter("acao").equals("AlterarEndereco") || request.getParameter("acao").equals("CadastrarEndereco")) {
		
		Pais pais = new Pais(request.getParameter("pais"));
		
		Estado estado = new Estado(request.getParameter("estado"), pais);
		
		Cidade cidade = new Cidade(estado, request.getParameter("cidade"));
		
		Endereco endereco = new Endereco(
				request.getParameter("tipoResidencia"), 
				request.getParameter("logradouro"), 
				request.getParameter("numero"), 
				request.getParameter("cep"), 
				request.getParameter("bairro"),
				request.getParameter("tipoLogradouro"),
				request.getParameter("tipoEndereco"),
				request.getParameter("observacao"),
				cidade);
		
		if(request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
			
			endereco.setId(Integer.valueOf(request.getParameter("id")));
			
		}
		
		if(request.getParameter("usu_id") != null && !request.getParameter("usu_id").isEmpty()) {
			
			endereco.setEnderecoUsuarioId(Integer.valueOf(request.getParameter("usu_id")));
			
			return endereco;
			
		}
		
		return endereco;
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
