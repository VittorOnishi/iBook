package br.com.iBook.viewhelper;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;
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
			
			if(request.getParameter("idEndereco") != null && !request.getParameter("idEndereco").isEmpty()) {
				Endereco endereco = new Endereco(Integer.valueOf(request.getParameter("idEndereco")));
				pedido.setEndereco(endereco);
			}else {
				PrintWriter out = null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		out.print("É preciso selecionar um endereço de entrega");
			}
			
			return null;
		}
		
		if(request.getParameter("acao").equals("Confirmar pagamento")) {
			
			CarrinhoDeCompras cdc = new CarrinhoDeCompras();
			
			Usuario usuario = new Usuario(Integer.valueOf(request.getParameter("idUsuario")));
			
			pedido.setUsuario(usuario);
			
			Endereco endereco = new Endereco(Integer.valueOf(request.getParameter("pedidoEnderecoId")), 
					                         new BigDecimal(request.getParameter("valorFrete")));
			
			pedido.setEndereco(endereco);
			
			pedido.setDtCadastro(LocalDate.now());
			
			pedido.setListaItens(cdc.getItens());
			
//			BigDecimal desconto = new BigDecimal(request.getParameter("valorFrete"));
//			
//			for(Item item : pedido.getListaItens()) {
//				
//				item.getPrecoItem().subtract(desconto);
//				
//			}
			
			pedido.setValorProdutos(new BigDecimal(request.getParameter("valorProdutos")));
			
			if (request.getParameter("idCartao") != null && !request.getParameter("idCartao").isEmpty()) {
				CartaoDeCredito cartao = new CartaoDeCredito(Integer.valueOf(request.getParameter("idCartao")));
				pedido.setCartao(cartao);
				return pedido;
			} else {
				PrintWriter out = null;
				try {
					out = response.getWriter();
				} catch (IOException e) {
					e.printStackTrace();
				}
				out.print("É preciso selecionar um método de pagamento");
			}
			
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
	
		if(request.getParameter("acao").equals("VerItensPedido")){	

			pedido = new Pedido(Integer.valueOf(request.getParameter("idPedido")));

			return pedido;
			
		}
		
		if(request.getParameter("acao").equals("SolicitarTrocaPedido")){	
			
			Item item = new Item(request.getParameter("statusPedido"));

			pedido = new Pedido(Integer.valueOf(request.getParameter("idPedido")), item);

			return pedido;
			
		}
		
		if(request.getParameter("acao").equals("AlterarStatusPedido")){	
			
			Usuario usuario = new Usuario(Integer.valueOf(request.getParameter("idCliente")));
			
			Item item = new Item(request.getParameter("statusPedido"));

			pedido = new Pedido(Integer.valueOf(request.getParameter("idPedido")),
								new BigDecimal(request.getParameter("valorPedido")),
								item,
								usuario);
			
			return pedido;
					
		}
		
		if(request.getParameter("acao").equals("AlterarStatus")) {
			
			Item item = new Item(Integer.valueOf(request.getParameter("idItem")), 
		            			 request.getParameter("statusItem"));

			pedido = new Pedido(Integer.valueOf(request.getParameter("idPedido")), item);
			
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
		   request.getParameter("acao").equals("CadastrarCartao")||
		   request.getParameter("acao").equals("AdicionarCupom")) {
			
			Pedido pedido = new Pedido();
			request.setAttribute("pedidoEnderecoId", pedido.getEndereco().getId());
		}
		
	}

}
