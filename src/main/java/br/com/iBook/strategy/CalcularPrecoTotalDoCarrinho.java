package br.com.iBook.strategy;

import java.math.BigDecimal;

import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;

public class CalcularPrecoTotalDoCarrinho implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		Item item = (Item) entidade;
		
		BigDecimal preco = item.getPrecoItem().multiply(new BigDecimal(item.getQtdeProdutos()));
		
		CarrinhoDeCompras cdc = new CarrinhoDeCompras();
		
		if(cdc.getValorCarrinho() == null){
			cdc.setValorCarrinho(new BigDecimal(0));
		}

			preco = item.getPrecoItem().add(cdc.getValorCarrinho());
			cdc.setValorCarrinho(preco);
			
		
		return null;
	}

}
