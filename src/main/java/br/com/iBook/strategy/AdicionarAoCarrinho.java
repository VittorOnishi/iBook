package br.com.iBook.strategy;

import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;

public class AdicionarAoCarrinho implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Item item = (Item) entidade;
		
		CarrinhoDeCompras cdc = new CarrinhoDeCompras();
		
		cdc.adiciona(item);
		
		return null;
	}

}
