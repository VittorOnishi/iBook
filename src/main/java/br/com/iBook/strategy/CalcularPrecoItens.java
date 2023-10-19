package br.com.iBook.strategy;

import java.math.BigDecimal;

import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;

public class CalcularPrecoItens implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Item item = (Item) entidade;
		
		BigDecimal preco = item.getPrecoItem().multiply(new BigDecimal(item.getQtdeProdutos()));
		
		item.setPrecoItem(preco);
		
		return null;
	}

}
