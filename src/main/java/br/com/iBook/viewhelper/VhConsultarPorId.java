 package br.com.iBook.viewhelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Livro;
import br.com.iBook.dominio.Usuario;

public class VhConsultarPorId implements IViewHelper {

	private static Map<String, EntidadeDominio> objects;
	
	public VhConsultarPorId(){
		
		objects = new HashMap<>();
		
		objects.put("ExibeDadosUsuario", new Usuario());
		objects.put("ExibeEndereco", new Endereco());
		objects.put("ExibeCartao", new CartaoDeCredito());
		objects.put("ExibeUsuario", new Usuario());
		objects.put("Continuar", new Usuario());
		objects.put("Perfil", new Usuario());
		objects.put("ExibeDadosProduto", new Livro());
	}
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {

		String paramAcao = request.getParameter("acao");
		
		EntidadeDominio entidadeDominio = objects.get(paramAcao);
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("Consultando dados do id " + id);
		
		entidadeDominio.setId(id);
		
		return entidadeDominio;
	}

	@Override
	public void setView(List<EntidadeDominio> entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		request.setAttribute("EntidadeLista", entDom);

	}

	@Override
	public void setView(EntidadeDominio entDom, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("acao").equals("Continuar")) {
			System.out.println("inciando sessão");
			Usuario usuario = (Usuario)entDom;
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
		}
		
		request.setAttribute("EntidadeObjeto", entDom);
	}

}