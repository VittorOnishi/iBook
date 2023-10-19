package br.com.iBook.fachada;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.iBook.controle.Conexao;
import br.com.iBook.dao.BandeiraCartaoDAO;
import br.com.iBook.dao.CartaoDeCreditoDAO;
import br.com.iBook.dao.EnderecoDAO;
import br.com.iBook.dao.IDAO;
import br.com.iBook.dao.LivroDAO;
import br.com.iBook.dao.PedidoDAO;
import br.com.iBook.dao.UsuarioDAO;
import br.com.iBook.dominio.BandeiraCartao;
import br.com.iBook.dominio.CarrinhoDeCompras;
import br.com.iBook.dominio.CartaoDeCredito;
import br.com.iBook.dominio.Endereco;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.dominio.Item;
import br.com.iBook.dominio.Livro;
import br.com.iBook.dominio.Login;
import br.com.iBook.dominio.Pedido;
import br.com.iBook.dominio.Usuario;
import br.com.iBook.strategy.AdicionarAoCarrinho;
import br.com.iBook.strategy.AlterarItensDoCarrinho;
import br.com.iBook.strategy.CalcularFrete;
import br.com.iBook.strategy.CalcularPrecoItens;
import br.com.iBook.strategy.CalcularPrecoTotalDoCarrinho;
import br.com.iBook.strategy.IStrategy;
import br.com.iBook.strategy.RemoveProdutosDoCarrinho;
import br.com.iBook.strategy.ValidarCpf;

public class Fachada implements IFachada {
	
	private Map<String, Map<String, List<IStrategy>>> mainMap;
	
	private Map<String, List<IStrategy>> mapaRNS;
		
	private Map<String, IDAO> daos;
		
		
		
		public Fachada() {
			
			mainMap = new HashMap<String, Map<String, List<IStrategy>>>();
			mapaRNS = new HashMap<String, List<IStrategy>>();
			daos = new HashMap<String, IDAO>();
		
			
			Conexao conn = new Conexao();
			Connection connection = conn.recuperarConexao();
			
			List<IStrategy> adicionarItemAoCarrinho = new ArrayList<IStrategy>();
			
			adicionarItemAoCarrinho.add(new CalcularPrecoItens());
			adicionarItemAoCarrinho.add(new CalcularPrecoTotalDoCarrinho());
			adicionarItemAoCarrinho.add(new AdicionarAoCarrinho());
			
			List<IStrategy> removerItemAoCarrinho = new ArrayList<IStrategy>();
			
			removerItemAoCarrinho.add(new RemoveProdutosDoCarrinho());
			
			List<IStrategy> alterarCarrinho = new ArrayList<IStrategy>();
			
			alterarCarrinho.add(new AlterarItensDoCarrinho());
			
			List<IStrategy> salvarPedido = new ArrayList<IStrategy>();
			
			salvarPedido.add(new CalcularFrete());
			
			List<IStrategy> salvarUsuario = new ArrayList<IStrategy>();
			
			salvarUsuario.add(new ValidarCpf());
			
			List<IStrategy> salvarEndereco = new ArrayList<IStrategy>();
			
			salvarEndereco.add(new ValidarCpf());
			
			List<IStrategy> salvarCartao = new ArrayList<IStrategy>();
			
			salvarCartao.add(new ValidarCpf());
			
			
			mapaRNS.put("Adicionar ao Carrinho", adicionarItemAoCarrinho);
			mapaRNS.put("Remover do Carrinho", removerItemAoCarrinho);
			mapaRNS.put("Alterar Carrinho", alterarCarrinho);
			mapaRNS.put("Salvar", salvarPedido);
			mapaRNS.put("Salvar", salvarEndereco);
			mapaRNS.put("Salvar", salvarUsuario);
			mapaRNS.put("Salvar", salvarCartao);
			
			
			mainMap.put(Pedido.class.getName(), mapaRNS);
			mainMap.put(Item.class.getName(), mapaRNS);
			mainMap.put(Usuario.class.getName(), mapaRNS);
			mainMap.put(Endereco.class.getName(), mapaRNS);
			mainMap.put(CartaoDeCredito.class.getName(), mapaRNS);
			
			daos.put(Usuario.class.getName(), new UsuarioDAO(connection));
			daos.put(Login.class.getName(), new UsuarioDAO(connection));
			daos.put(Endereco.class.getName(), new EnderecoDAO(connection));
			daos.put(CartaoDeCredito.class.getName(), new CartaoDeCreditoDAO(connection));
			daos.put(BandeiraCartao.class.getName(), new BandeiraCartaoDAO(connection));
			daos.put(Livro.class.getName(), new LivroDAO(connection));
			daos.put(Pedido.class.getName(), new PedidoDAO(connection));
			
		}

		@Override
		public String salvar(EntidadeDominio entidade) {
			String nmClasse = entidade.getClass().getName();
			mapaRNS = mainMap.get(nmClasse);
			List<IStrategy> rns = mapaRNS.get("Salvar");
			StringBuilder msgs = new StringBuilder();

			for(IStrategy s:rns) {
				String msg = s.processar(entidade);
				if(msg != null){ 
					msgs.append(msg);
				}			
			}
			if(msgs.length()==0) {
				IDAO dao = daos.get(nmClasse);
				try {
					dao.salvar(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
					
			}else {
				return msgs.toString();
			}
			return null;
		}

		@Override
		public String excluir(EntidadeDominio entidade) {
			// TODO Auto-generated method stub
			String nmClasse = entidade.getClass().getName();
			
				IDAO dao = daos.get(nmClasse);
				try {
					dao.excluir(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			return null;
		}

		@Override
		public String alterar(EntidadeDominio entidade) {
			// TODO Auto-generated method stub
			String nmClasse = entidade.getClass().getName();
//			mapaRNS = mainMap.get(nmClasse);
//			List<IStrategy> rns = mapaRNS.get("ALTERAR");
//			StringBuilder msgs = new StringBuilder();
//			
//			for(IStrategy s:rns) {
//				String msg = s.processar(entidade);
//				if(msg != null) {
//					System.out.println(msgs.append(msg));
//				}			
//			}
//			
//			if(msgs.length()==0) {
				IDAO dao = daos.get(nmClasse);
				try {
					dao.alterar(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
//			}else {
//				return msgs.toString();
//			}
			return null;
		}

		@Override
		public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
			// TODO Auto-generated method stub
			String nmClasse = entidade.getClass().getName();
			List<EntidadeDominio> lista = new ArrayList<>();
			
				IDAO dao = daos.get(nmClasse);
				try {
					lista = dao.consultar(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			return lista;
		}
		
		public EntidadeDominio consultaUnica(EntidadeDominio entidade) {
			// TODO Auto-generated method stub
			String nmClasse = entidade.getClass().getName();
			List<EntidadeDominio> lista = new ArrayList<>();
			
				IDAO dao = daos.get(nmClasse);
				try {
					lista = dao.consultar(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				for(EntidadeDominio entDom: lista) {
					if(entDom.getClass().getName().equals(Usuario.class.getName())) {
						CalcularFrete cf = new CalcularFrete();
						cf.processar(entDom);
					}
					return entDom;	
				}
				return null;
		}
		
		public String adicionarItemAoCarrinho(EntidadeDominio entidade) {
			String nmClasse = entidade.getClass().getName();
			mapaRNS = mainMap.get(nmClasse);
			List<IStrategy> rns = mapaRNS.get("Adicionar ao Carrinho");
			StringBuilder msgs = new StringBuilder();
			
			for(IStrategy s:rns) {
				String msg = s.processar(entidade);
				if(msg != null) {
					msgs.append(msg);
				}			
			}
			if(msgs.length()==0) {
				return null;
			}else {
				return msgs.toString();
			}
		}
		
		public String alterarItemDoCarrinho(EntidadeDominio entidade) {
			String nmClasse = entidade.getClass().getName();
			mapaRNS = mainMap.get(nmClasse);
			List<IStrategy> rns = mapaRNS.get("Alterar Carrinho");
			StringBuilder msgs = new StringBuilder();
			
			for(IStrategy s:rns) {
				String msg = s.processar(entidade);
				if(msg != null) {
					msgs.append(msg);
				}			
			}
			if(msgs.length()==0) {
				return null;
			}else {
				return msgs.toString();
			}
		}
		
		public Item consultarItemDoCarrinho(EntidadeDominio entidade) {
			
			Item item = (Item)entidade;
			
			CarrinhoDeCompras cdc = new CarrinhoDeCompras();
			
			for(Item itm : cdc.getItens()) {
				if(itm.getId() == item.getId()) {
					return itm;
				}
			}
			return null;
		}
		
		public String removerItensDoCarrinho(EntidadeDominio entidade) {
			String nmClasse = entidade.getClass().getName();
			mapaRNS = mainMap.get(nmClasse);
			List<IStrategy> rns = mapaRNS.get("Remover do Carrinho");
			StringBuilder msgs = new StringBuilder();
			
			for(IStrategy s:rns) {
				String msg = s.processar(entidade);
				if(msg != null) {
					msgs.append(msg);
				}			
			}
			if(msgs.length()==0) {
				return null;
			}else {
				return msgs.toString();
			}
		}
		
		public EntidadeDominio calcularFrete(EntidadeDominio entidade) {
			String nmClasse = entidade.getClass().getName();
			mapaRNS = mainMap.get(nmClasse);
			List<IStrategy> rns = mapaRNS.get("Calcular frete");
			StringBuilder msgs = new StringBuilder();
			List<EntidadeDominio> lista = new ArrayList<>();
			
				IDAO dao = daos.get(nmClasse);
				try {
					lista = dao.consultar(entidade);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				for(EntidadeDominio entDom: lista) {
					for(IStrategy s:rns) {
						String msg = s.processar(entDom);
						if(msg != null) {
							msgs.append(msg);
						}else {
							return entDom;
						}
					}
				}
				return null;
		}
}//vemsermuralis@muralis.com.br - teste/dev
