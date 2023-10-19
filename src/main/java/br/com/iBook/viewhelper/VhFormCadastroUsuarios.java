package br.com.iBook.viewhelper;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.dominio.BandeiraCartao;
import br.com.iBook.dominio.EntidadeDominio;

public class VhFormCadastroUsuarios implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request, HttpServletResponse response) {
		BandeiraCartao bandeira = new BandeiraCartao();
		
		return bandeira;
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

	}

}
