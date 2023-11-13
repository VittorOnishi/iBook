package br.com.iBook.viewhelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.BandeiraCartao;
import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.Cidade;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Estado;
import br.com.iBook.dominio.Login;
import br.com.iBook.dominio.Pais;
import br.com.iBook.dominio.Telefone;
import br.com.iBook.dominio.Usuario;

public class VhCadastrarUsuarios implements IViewHelper{

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		
		
	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
	}

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) throws ServletException {
			
		if(request.getParameter("senha").equals(request.getParameter("senhaConfirmacao"))) {
			Login login = new Login(request.getParameter("e-mail"), request.getParameter("senha"));
			
			   String paramData = request.getParameter("dataNasc"); // Substitua isso pela sua string de data

			   Date dataNasc = null;
			   
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		        try {
		            dataNasc = dateFormat.parse(paramData);
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
		
			Pais paisResidencial = new Pais(request.getParameter("paisResidencial"));
	
			Estado estadoResidencial = new Estado(request.getParameter("estadoResidencial"), paisResidencial);
			
			Cidade cidadeResidencial = new Cidade(estadoResidencial, request.getParameter("cidadeResidencial"));
			
			Endereco enderecoResidencial = new Endereco(request.getParameter("tipoResidenciaResidencial"), 
					request.getParameter("logradouroResidencial"), 
					request.getParameter("numeroResidencial"), 
					request.getParameter("cepResidencial"), 
					request.getParameter("bairroResidencial"),
					request.getParameter("tipoLogradouroResidencial"),
					"Endereço Residencial",
					request.getParameter("observacaoResidencial"),
					cidadeResidencial);
			
			Pais paisEntrega = new Pais(request.getParameter("paisEntrega"));
			
			Estado estadoEntrega = new Estado(request.getParameter("estadoEntrega"), paisEntrega);
			
			Cidade cidadeEntrega = new Cidade(estadoEntrega, request.getParameter("cidadeEntrega"));
			
			Endereco enderecoEntrega = new Endereco(request.getParameter("tipoResidenciaEntrega"), 
					request.getParameter("logradouroEntrega"), 
					request.getParameter("numeroEntrega"), 
					request.getParameter("cepEntrega"), 
					request.getParameter("bairroEntrega"),
					request.getParameter("tipoLogradouroEntrega"),
					"Endereço de Entrega",
					request.getParameter("observacaoEntrega"),
					cidadeEntrega);
			
			Telefone telefone = new Telefone(request.getParameter("telefone"), request.getParameter("tipoTelefone"));
			
			Usuario usuario = new Usuario(request.getParameter("nomeCliente")
					, request.getParameter("genero")
					, request.getParameter("cpf")
					, dataNasc
					, login);
			
			usuario.setListadeEnderecos(enderecoResidencial);
			usuario.setListadeEnderecos(enderecoEntrega);
			
			usuario.setListadeTelefones(telefone);
			
			if(request.getParameter("bandeiraCartao") != null && !request.getParameter("bandeiraCartao").isEmpty()) {
				
				BandeiraCartao bandeiraCartao = new BandeiraCartao();
				
				bandeiraCartao.setId(Integer.valueOf(request.getParameter("bandeiraCartao")));
				
				CartaoDeCredito cartao = new CartaoDeCredito(request.getParameter("nrCartao"),
						request.getParameter("nomeCartao"),
						request.getParameter("codigoSegCartao"),
						bandeiraCartao);
				
				usuario.setListadeCartoes(cartao);
				}
			
			return usuario;
		}
			
		return null;
	}
	
}
