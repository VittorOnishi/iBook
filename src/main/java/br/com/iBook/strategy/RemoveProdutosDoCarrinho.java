package br.com.iBook.strategy;

import java.util.Iterator;

import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;

public class RemoveProdutosDoCarrinho implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		CarrinhoDeCompras cdc = new CarrinhoDeCompras();
		
		Iterator<Item> it = cdc.getItens().iterator();
		
		while(it.hasNext()) {
			Item item = it.next();
			
              if(item.getId()== entidade.getId()) {
            
				it.remove();
				
			}
			
		}
		
		return null;
	}

}
