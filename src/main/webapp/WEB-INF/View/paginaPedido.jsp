<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<c:url value="/controller" var="linkController" />

<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Pedidos</title>
<link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
<link rel="stylesheet" href="<c:url value="/style/stylePedidos.css"/>">
</head>

<body>
	<header class="cabecalho">
		<p class="titulo__site">iBook</p>

		<form class="buscar__produto">
			<input class="barra_pesquisa" type="text" id="numero" name="numero"
				placeholder="Buscar">
			<button class="botao__pesquisar" type="submit">
				<img class="botao__pesquisar__lupa" src="./assets/pesquisar.png"
					alt="Pesquisar">
			</button>
		</form>

		<nav class="cabecalho__menu">
			<a class="cabecalho__menu__link"
				href="/iBook/controller?acao=Carrinho"> <img
				class="cabecalho__menu__icones" src="./assets/carrinho.png"
				alt="Carrinho"> Carrinho
			</a> <a class="cabecalho__menu__link"
				href="/iBook/controller?acao=PaginaConsultaVendas&id=110"> <img
				class="cabecalho__menu__icones" src="./assets/sacola.png"
				alt="Sacola">Compras
			</a> <a class="cabecalho__menu__link"
				href="/iBook/controller?acao=formLogin"> <img
				class="cabecalho__menu__icones" src="./assets/perfil.png"
				alt="Perfil">Perfil
			</a>
		</nav>

	</header>
	<main class="pedidos">

        <section class="pedidos">
		
		<c:choose>
			<c:when test="${usuarioLogado.isAdmin == true}">
            	<a class="link__voltar" href="/iBook/controller?acao=Perfil&id=${usuarioLogado.id}">
                	<img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
            	</a>
            </c:when>
            
            <c:otherwise>
            	<a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">
                	<img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
            	</a>
            </c:otherwise>
            
        </c:choose>
            
            <form class="buscar__pedido" action="${linkController}" method="get">

				<select class="select__filtro__busca__pedido"
					name="filtroPesquisaPedido" id="filtroPesquisaPedido">
					<option value="nome">Nome</option>
				</select> <input class="barra__pesquisa" type="text" id="paramBuscaPedido"
					name="paramBuscaPedido" placeholder="Buscar pedido"> <input
					type="hidden" name="acao" value="ConsultarPedido">

				<button class="botao__pesquisar" type="submit">
					<img class="botao__pesquisar__lupa" src="./assets/pesquisar.png"
						alt="Pesquisar">
				</button>

			</form>
		<c:choose>
    		<c:when test="${usuarioLogado.isAdmin == true}">
            	 <table class="pedidos__lista__produtos">
                <tr>
                    <th class="pedidos__lista__header">Pedidos</th>
                </tr>

				<c:forEach items="${EntidadeLista}" var="pedido">
                <tr class="pedidos__lista__informacoes">
                	<td><strong>Número</strong>
                		<p class="pedidos__lista__informacoes__dados__numeropedido"> ${pedido.id}</p>
                	</td>
        			
        			<td><strong>Data</strong>
        				<p class="pedidos__lista__informacoes__dados__numeropedido">${pedido.dataPedido}</p>
        			</td>
        			
        			<td><strong>Valor</strong>
        				<p class="pedidos__lista__informacoes__dados__numeropedido">R$ ${pedido.valorTotal + pedido.endereco.valorFrete}</p>
        			</td>
					
					<td><strong>Cliente</strong>
        				<p class="pedidos__lista__informacoes__dados__numeropedido">${pedido.usuario.nome}</p>
        			</td>
                    
                    <td class="pedidos__lista__informacoes__acoes__admin">
                        <a class="botao__pesquisar" href="/iBook/controller?acao=VerItensPedido&id=${pedido.id}">
							<img class="botao__pesquisar__lupa" src="./assets/icone_menu.png"
							alt="Pesquisar">
                        </a>
                      </td>
                      <td>  
                        <div class="pedidos__lista__informacoes__acoes__admin">
                        <form action="${linkController}">
								<select class="status__select" name="statusPedido" id="statusPedido"
									required>
									<option value="" disabled selected>Selecione o status</option>
									<option value="EM PROCESSAMENTO">EM PROCESSAMENTO</option>
									<option value="PEDIDO APROVADO">PEDIDO APROVADO</option>
									<option value="PAGAMENTO RECUSADO">PAGAMENTO RECUSADO</option>
									<option value="EM TRÂNSITO">EM TRÂNSITO</option>
									<option value="ENTREGUE">ENTREGUE</option>
									<option value="TROCA APROVADA">TROCA APROVADA</option>
									<option value="TROCA REALIZADA">TROCA REALIZADA</option>
									<option value="TROCA RECUSADA">TROCA RECUSADA</option>
								</select> <input type="hidden" name="idPedido" id="idPedido"
									value="${pedido.id}">
									
                        		<input type="hidden" name="idCliente" id="idCliente" value="${pedido.usuario.id}">
                        		<input type="hidden" name="valorPedido" id="valorPedido" value="${pedido.valorTotal}">

								<button class="status__alterar" type="submit" name="acao"
								id="acao" value="AlterarStatusPedido"><img class="botao__pesquisar__lupa" src="./assets/icone_atualizar.png"
								alt="Alterar"></button>
							</form> 
						</div>
                    </td>
                    </tr>
                </c:forEach>

            </table>
            </c:when>
    		<c:otherwise>
    		
    		<table class="pedidos__lista__produtos">
                <tr>
                    <th class="pedidos__lista__header" colspan="3">Pedidos</th>
                </tr>

				<c:forEach items="${EntidadeLista}" var="pedido">
                <tr class="pedidos__lista__informacoes">
                    <td class="pedidos__lista__informacoes__dados">

                        <p class="pedidos__lista__informacoes__dados__titulo"><strong class="titulo__destaque">
                                Dados do pedido:
                            </strong></p>

                        <p class="pedidos__lista__informacoes__dados__numeropedido">Número do pedido: ${pedido.id}</p>
                        <p class="pedidos__lista__informacoes__dados__datapedido">Data do pedido: ${pedido.dataPedido}</p>
                        <p class="pedidos__lista__informacoes__dados__preco">Valor: R$ ${pedido.valorTotal + pedido.endereco.valorFrete}</p>
					</td>
                        <!-- </td> -->

                        <!-- <td class="pedidos__lista__informacoes__dados"> -->
					<td class="pedidos__lista__informacoes__dados">
                        <p class="pedidos__lista__dados__produtos__titulo">
								<strong class="titulo__destaque"> Produtos: </strong>
							</p> 
						
							<c:forEach items="${pedido.listaItens}" var="itemPedido">
								<p class="pedidos__lista__dados__produtos__titulo">${itemPedido.qtdeProdutos}X
									${itemPedido.livro.titulo} 
									<!--<c:if test="${usuarioLogado.isAdmin == true}">
									- ${itemPedido.statusPedido} 
									</c:if>-->
								</p>
								<c:set var="produtoEstaEntregue" value="false" />
								<c:if test="${itemPedido.statusPedido == 'ENTREGUE'}">
									<c:set var="produtoEstaEntregue" value="true" />
								</c:if>
								
							</c:forEach>
					</td>	
					<!--<c:if test="${usuarioLogado.isAdmin == true}">	
							 <td class="pedidos__lista__informacoes__dados">

							<p class="pedidos__lista__informacoes__dados__titulo">
								<strong class="titulo__destaque"> Dados do cliente: </strong>
							</p>
							
							<p class="pedidos__lista__informacoes__dados__numeropedido">Nome: ${pedido.usuario.nome}</p>
							<p class="pedidos__lista__informacoes__dados__datapedido">E-mail: ${pedido.usuario.login.email}</p>
							<p class="pedidos__lista__informacoes__dados__preco">CPF: ${pedido.usuario.cpf}</p> <!-- </td> -->

							<!-- <td class="pedidos__lista__informacoes__dados">
							</td>
					</c:if> -->
					
                    <td class="pedidos__lista__informacoes__acoes">
                        <a class="pedidos__lista__informacoes__acoes__ver__pedido" href="/iBook/controller?acao=VerItensPedido&id=${pedido.id}">
                            Ver pedido
                        </a>
                        <c:if test="${produtoEstaEntregue}">
                        	<form action="${linkController}">
                        		<input type="hidden" name="idPedido" id="idPedido" value="${pedido.id}">
                    			<input type="hidden" name="statusPedido" id="statusPedido" value="TROCA SOLICITADA">
                    			<button class="pedidos__lista__informacoes__acoes__trocar__pedido" type="submit" name="acao" id="acao" value="SolicitarTrocaPedido">   
                        			Trocar pedido
                    			</button>
                    		</form>
	                       <!-- <a class="pedidos__lista__informacoes__acoes__trocar__pedido" href="/iBook/controller?acao=SolicitarTrocaPedido&id=${pedido.id}">
	                            Trocar pedido
	                        </a> -->
                        </c:if>
                       <!-- <c:if test="${usuarioLogado.isAdmin == true}">	
							<form action="${linkController}">

								<p class="pedidos__lista__informacoes__dados__titulo">
									<strong class="titulo__destaque"> Status: </strong>
								</p>
								<select class="status__select" name="statusItem" id="statusItem"
									required>
									<option value="" disabled selected>Selecione o status</option>
									<option value="EM PROCESSAMENTO">EM PROCESSAMENTO</option>
									<option value="PEDIDO APROVADO">PEDIDO APROVADO</option>
									<option value="PAGAMENTO RECUSADO">PAGAMENTO RECUSADO</option>
									<option value="EM TRÂNSITO">EM TRÂNSITO</option>
									<option value="ENTREGUE">ENTREGUE</option>
									<option value="TROCA APROVADA">TROCA APROVADA</option>
									<option value="TROCA REALIZADA">TROCA REALIZADA</option>
									<option value="TROCA RECUSADA">TROCA RECUSADA</option>
								</select> <input type="hidden" name="idItem" id="idItem"
									value="${EntidadeObjeto.item.id}">

								<button class="status__alterar" type="submit" name="acao"
									id="acao" value="AlterarStatus">Alterar Status</button>
							</form>
							</c:if>-->
                    </td>
                </tr>
                </c:forEach>

            </table>
    		
		 </c:otherwise>
		</c:choose>
        </section>

    </main>
</body>

</html>