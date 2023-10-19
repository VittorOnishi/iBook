package br.com.iBook.strategy;

import java.math.BigDecimal;
import java.util.Iterator;

import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;

public class AlterarItensDoCarrinho implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		Item item = (Item)entidade;
		
		Item itemConsultado = buscaPorId(item.getId());
		itemConsultado.setQtdeProdutos(item.getQtdeProdutos());
		
		BigDecimal preco = item.getLivro().getPreco().multiply(new BigDecimal(item.getQtdeProdutos()));
		
		itemConsultado.setPrecoItem(preco);
		
		return null;
	}
	
	public Item buscaPorId(Integer id) {
		
		CarrinhoDeCompras cdc = new CarrinhoDeCompras();
		
		for (Item item : cdc.getItens()) {
			if(item.getId()== id) {
				return item;
			}
			
		}
		
		return null;
	}

}
