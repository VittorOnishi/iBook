package br.com.iBook.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Item extends EntidadeDominio{
	
	private Integer qtdeProdutos;
	private Livro livro;
	private BigDecimal precoItem;
	private String statusPedido;
	private List<Item> listaDeItens = new ArrayList<>();
	
	public Item(Integer qtdeProdutos, Livro livro, BigDecimal precoCompra) {
		this.qtdeProdutos = qtdeProdutos;
		this.livro = livro;
		this.precoItem = precoCompra;
	}
	public Item(Integer qtdeProdutos, BigDecimal precoCompra, String statusPedido, Livro livro) {
		this.qtdeProdutos = qtdeProdutos;
		this.precoItem = precoCompra;
		this.statusPedido = statusPedido;
		this.livro = livro;
	}
	public Item(Integer id) {
		setId(id); 	
	}
	
	public Item(Integer id, Integer qtdeProdutos, Livro livro) {
		setId(id); 	
		this.qtdeProdutos = qtdeProdutos;
		this.livro = livro;
	}
	
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Integer getQtdeProdutos() {
		return qtdeProdutos;
	}

	public void setQtdeProdutos(Integer qtdeProdutos) {
		this.qtdeProdutos = qtdeProdutos;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public BigDecimal getPrecoItem() {
		return precoItem;
	}

	public void setPrecoItem(BigDecimal precoCompra) {
		this.precoItem = precoCompra;
	}
	public String getStatusPedido() {
		return statusPedido;
	}
	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}
	public List<Item> getListaDeItens() {
		return listaDeItens;
	}
	public void setListaDeItens(Item item) {
		this.listaDeItens.add(item);
	}
	
	
}
