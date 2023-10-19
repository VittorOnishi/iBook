package br.com.iBook.command;

import br.com.iBook.controle.Resultado;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;
import br.com.iBook.fachada.Fachada;

public class CommandAdicionarAoCarrinho implements ICommand{

	@Override
	public Resultado execute(EntidadeDominio entidade) {
		
		Resultado rstd = new Resultado();
		
		Fachada fac = new Fachada();
		
		Fachada fac2 = new Fachada();
		
		fac.adicionarItemAoCarrinho(entidade);
		
		Item item = (Item) entidade;
			
		rstd.setEntidade(fac2.consultaUnica(item.getLivro()));
		
		return rstd;
	}

}
