package br.com.iBook.dominio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido extends EntidadeDominio{

	private Usuario usuario;
	private static Endereco endereco;
	private static CartaoDeCredito cartao;
	private List<Item> itensDoPedido = new ArrayList<>();
	private static Frete frete;
	private BigDecimal valorTotal;
	private BigDecimal valorProdutos;
	private LocalDate dataPedido;
	
	public Pedido(Integer id, LocalDate dataPedido, BigDecimal valorTotal, Endereco endereco) {
		setId(id);
		this.dataPedido = dataPedido;
		this.valorTotal = valorTotal;
		Pedido.endereco = endereco;
	}
	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	public Pedido(Integer id) {
		// TODO Auto-generated constructor stub
		setId(id);
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		Pedido.endereco = endereco;
	}
	
	public CartaoDeCredito getCartao() {
		return cartao;
	}

	public void setCartao(CartaoDeCredito cartao) {
		Pedido.cartao = cartao;
	}
	public List<Item> getListaItens() {
		return itensDoPedido;
	}
	public void setListaItens(Item item) {
		this.itensDoPedido.add(item);
	}
	public void setListaItens(List<Item> listaItens) {
		this.itensDoPedido = listaItens;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = LocalDate.now();
	}
	public static Frete getFrete() {
		return frete;
	}
	public void setFrete(Frete frete) {
		Pedido.frete = frete;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getValorProdutos() {
		return valorProdutos;
	}
	public void setValorProdutos(BigDecimal valorProdutos) {
		this.valorProdutos = valorProdutos;
	}
	
	
	
}
