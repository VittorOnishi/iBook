package br.com.iBook.viewhelper;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.Cupom;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Usuario;

public class VhCupom implements IViewHelper {
	
	private Integer qtdeCupons;

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub

		if(request.getParameter("acao").equals("ConsultarCupons")) {
			
			Cupom cupom = new Cupom();
			
			Usuario usuario = new Usuario(Integer.valueOf(request.getParameter("id")));
			
			cupom.setUsuario(usuario);
			
			return cupom;
		
		}
		
		if(request.getParameter("acao").equals("AdicionarCupom")) {
			
			Cupom cupom = new Cupom();
			
			int contador = Integer.valueOf(request.getParameter("qtdeLista"));
			
			for(int i = 1; i <= contador; i++) {
				
				if(request.getParameter("idCupom" + i) != null &&
				   request.getParameter("desconto" + i) != null) {
					
					cupom = new Cupom(Integer.valueOf(request.getParameter("idCupom" + i)),
									  new BigDecimal(request.getParameter("desconto" + i)));
					
					Cupom cpm = new Cupom();
					
					cpm.adiciona(cupom);
				
					return cupom;
				}
			}
			
		}
		
		
		return null;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub;
		request.setAttribute("EntidadeLista", entDom);
		
		VhPedido vhp = new VhPedido();
		
		Cupom cupom = new Cupom();
		
		request.setAttribute("CuponsSelecionados", cupom.getCupons());
		
		vhp.setView(entDom, request, response);
		
	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		request.setAttribute("EntidadeObjeto", entDom);
		
		VhPedido vhp = new VhPedido();
		
		vhp.setView(entDom, request, response);
	}

}
