package br.com.iBook.viewhelper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Pedido;
import br.com.iBook.dominio.Usuario;

public class VhPedido implements IViewHelper {

	private static Map<String, EntidadeDominio> objects;
	
	public VhPedido() {
	
	objects = new HashMap<>();
	
	objects.put("Continuar", new Usuario());
	objects.put("ExcluirEndereco", new Endereco());
	objects.put("ExcluirCartao", new CartaoDeCredito());
	}
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		
		Pedido pedido = new Pedido();
		
		if(request.getParameter("acao").equals("Continuar")) {
			Usuario usuario = new Usuario(Integer.valueOf(request.getParameter("idUsuario")));
			
			return usuario;
		}
		
		
		if(request.getParameter("acao").equals("Confirmar endereco")) {
			
			Endereco endereco = new Endereco(Integer.valueOf(request.getParameter("idEndereco")));
					
			pedido.setEndereco(endereco);
			
			return null;
		}
		
		if(request.getParameter("acao").equals("Confirmar pagamento")) {
			
			CartaoDeCredito cartao = new CartaoDeCredito(Integer.valueOf(request.getParameter("idCartao")));
			
			CarrinhoDeCompras cdc = new CarrinhoDeCompras();
			
			Usuario usuario = new Usuario(Integer.valueOf(request.getParameter("idUsuario")));
			
			pedido.setUsuario(usuario);
			
			Endereco endereco = new Endereco(Integer.valueOf(request.getParameter("pedidoEnderecoId")), 
					                         new BigDecimal(request.getParameter("valorFrete")));
			
			pedido.setEndereco(endereco);
			
			pedido.setDtCadastro(LocalDate.now());
			
			pedido.setListaItens(cdc.getItens());
				
			pedido.setValorProdutos(new BigDecimal(request.getParameter("valorProdutos")));
			
			pedido.setCartao(cartao);
			
			return pedido;
		}
		
		if(request.getParameter("acao").equals("PaginaConsultaVendas")) {
			
			return pedido;
		}
		
		if(request.getParameter("acao").equals("ConsultarVendas") || 
		   request.getParameter("acao").equals("ConsultarPedido")) {
			
			if(request.getParameter("paramBuscaPedido") != null &&
			   !request.getParameter("paramBuscaPedido").isEmpty()) {
				
				pedido = new Pedido(Integer.valueOf(request.getParameter("paramBuscaPedido")));
			
				return pedido;
			}
			
			return pedido;
		}
		
		return null;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		request.setAttribute("EntidadeLista", entDom);

	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		request.setAttribute("EntidadeObjeto", entDom);
		
		CarrinhoDeCompras cdc = new CarrinhoDeCompras();
		
		request.setAttribute("Itens", cdc.getItens());
		
		request.setAttribute("QtdeItens", cdc.getQtdeItensCarrinho());
		
		
		if(request.getParameter("acao").equals("Confirmar endereco")||
		   request.getParameter("acao").equals("CadastrarCartao")) {
			
			Pedido pedido = new Pedido();
			request.setAttribute("pedidoEnderecoId", pedido.getEndereco().getId());
		}
		
	}

}
