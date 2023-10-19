package br.com.iBook.viewhelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;
import br.com.iBook.dominio.Usuario;

public class VhExcluir implements IViewHelper {

	
	private static Map<String, EntidadeDominio> objects;
	
	
	public VhExcluir(){
		
		objects = new HashMap<>();
		
		objects.put("ExcluirUsuario", new Usuario());
		objects.put("ExcluirEndereco", new Endereco());
		objects.put("ExcluirCartao", new CartaoDeCredito());
		
	}
	
	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		
		String paramAcao = request.getParameter("acao");
		
		EntidadeDominio entidadeDominio = objects.get(paramAcao);
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("Excluindo " + entidadeDominio.getClass().getName() +" "+ id);
		
		entidadeDominio.setId(id);
		
		return entidadeDominio;
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
