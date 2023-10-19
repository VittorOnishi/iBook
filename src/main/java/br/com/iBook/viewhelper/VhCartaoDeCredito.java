
package br.com.iBook.viewhelper;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.BandeiraCartao;
import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.EntidadeDominio;

public class VhCartaoDeCredito implements IViewHelper{

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		if(request.getParameter("bandeiraCartao") != null && 
		  !request.getParameter("bandeiraCartao").isEmpty()){
			
			BandeiraCartao bandeiraCartao = new BandeiraCartao();
			
			bandeiraCartao.setId(Integer.valueOf(request.getParameter("bandeiraCartao")));
			
			CartaoDeCredito cartao = new CartaoDeCredito(request.getParameter("nrCartao"),
					request.getParameter("nomeCartao"),
					request.getParameter("codigoSegCartao"),
					bandeiraCartao);
			
			if(request.getParameter("id")!= null &&
			  !request.getParameter("id").isEmpty()) {
				
				cartao.setId(Integer.valueOf(request.getParameter("id")));
			}
			
			if(request.getParameter("usu_id")!= null &&
					  !request.getParameter("usu_id").isEmpty()) {
						
						cartao.setCartaoUsuarioId(Integer.valueOf(request.getParameter("usu_id")));
					}
			
			return cartao;
			}
		return null;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		request.setAttribute("EntidadeLista", entDom);	
		
		if(request.getParameter("acao").equals("CadastrarCartao")) {
			CarrinhoDeCompras cdc = new CarrinhoDeCompras();
			request.setAttribute("Itens", cdc.getItens());
			
		}
	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		VhPedido vhp = new VhPedido();
		vhp.setView(entDom, request, response);

	}

}
