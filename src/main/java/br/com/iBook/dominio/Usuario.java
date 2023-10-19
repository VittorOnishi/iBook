package br.com.iBook.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Usuario extends EntidadeDominio {
	
	private String nome;
	private String genero;
	private String cpf;
	private Date dataNasc;
	private Boolean isAdmin;
	private ArrayList<Telefone> listadeTelefones = new ArrayList<>();
	private ArrayList<Endereco> listadeEnderecos = new ArrayList<>();
	private ArrayList<CartaoDeCredito> listadeCartoes = new ArrayList<>();
	private ArrayList<Pedido> listadePedidos = new ArrayList<>();
	private Login login;
	private CarrinhoDeCompras carrinho;	
	
	
	public Usuario(String nome, String genero, String cpf, Date dataNasc, Boolean isAdmin, Login login) {
		setNome(nome);
		this.genero = genero;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.isAdmin = isAdmin;
		this.login = login;
	}
	
	public Usuario(String nome, String genero, String cpf, Date dataNasc, Login login) {
		setNome(nome);
		this.genero = genero;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.login = login;
	}

	public Usuario(String nome) {
		setNome(nome);
	}

	public Usuario(Integer id) {
		setId(id);
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		Objects.requireNonNull(nome);
		nome = nome.trim().toUpperCase();
		this.nome = nome;
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void setGenero(String genero) {
		Objects.requireNonNull(genero);
		genero = genero.trim().toUpperCase();
		this.genero = genero;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		Objects.requireNonNull(cpf);
		this.cpf = cpf;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}
	
	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public ArrayList<Telefone> getListadeTelefones() {
		return listadeTelefones;
	}

	public void setListadeTelefones(Telefone telefone) {
		Objects.requireNonNull(telefone);
		this.listadeTelefones.add(telefone);
	}

	public ArrayList<Endereco> getListadeEnderecos() {
		return listadeEnderecos;
	}

	public void setListadeEnderecos(Endereco endereco) {
		this.listadeEnderecos.add(endereco);
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public ArrayList<CartaoDeCredito> getListadeCartoes() {
		return listadeCartoes;
	}

	public void setListadeCartoes(CartaoDeCredito cartao) {
		this.listadeCartoes.add(cartao);
	}

	public CarrinhoDeCompras getCarrinho() {
		return carrinho;
	}

	public void setCarrinho(CarrinhoDeCompras carrinho) {
		this.carrinho = carrinho;
	}

	public ArrayList<Pedido> getListadePedidos() {
		return listadePedidos;
	}

	public void setListadePedidos(Pedido pedido) {
		this.listadePedidos.add(pedido);
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
}
