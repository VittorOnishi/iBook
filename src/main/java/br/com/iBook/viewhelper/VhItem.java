package br.com.iBook.viewhelper;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;
import br.com.iBook.dominio.Livro;
import br.com.iBook.dominio.Pedido;

public class VhItem implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {		
		
		if(request.getParameter("acao").equals("Comprar") || 
		   request.getParameter("acao").equals("Adicionar ao carrinho")){
			
		if(
		   request.getParameter("id") != null &&
		   request.getParameter("qtdeItens") != null &&
		   !request.getParameter("id").isEmpty() &&
		   !request.getParameter("qtdeItens").isEmpty()
		   ) {
			
				Livro livro = new Livro(Integer.valueOf(request.getParameter("id")),
										request.getParameter("tituloItem"),
										new BigDecimal(request.getParameter("precoItem")),
										Integer.valueOf(request.getParameter("qtdeEmEstoque")),
										request.getParameter("codImage"),
										new BigDecimal(request.getParameter("alturaProduto")),
										new BigDecimal(request.getParameter("larguraProduto")),
										new BigDecimal(request.getParameter("profundidadeProduto")));
				
				Item item = new Item(Integer.valueOf(request.getParameter("qtdeItens")), livro, new BigDecimal(request.getParameter("precoItem")));
				
				return item;
				
			}
		}
		
		if(request.getParameter("acao").equals("RemoverDoCarrinho") || 
		   request.getParameter("acao").equals("VisualizarItemDoCarrinho")){
			
			Item item = new Item(Integer.valueOf(request.getParameter("id")));
			
			return item;
		}
		
		if(request.getParameter("acao").equals("AlterarCarrinho")){	
			
			Livro livro = new Livro(new BigDecimal(request.getParameter("precoItem")));
			
			Item item = new Item(Integer.valueOf(request.getParameter("id")), 
						Integer.valueOf(request.getParameter("qtdeItens")), 
						livro);
			
			return item;
		}
		
		if(request.getParameter("acao").equals("VerItensPedido")){	
			
			Pedido pedido = new Pedido(Integer.valueOf(request.getParameter("id")));
			
			return pedido;
			
		}
	
		return null;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		
		CarrinhoDeCompras cdc = new CarrinhoDeCompras();
		
		request.setAttribute("Itens", cdc.getItens());
		
		request.setAttribute("EntidadeLista", entDom);
		

	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

		request.setAttribute("EntidadeObjeto", entDom);
		
		VhConsultarPorId vhConsultaPorID = new VhConsultarPorId();
		
		vhConsultaPorID.setView(entDom, request, response);
	}

}
