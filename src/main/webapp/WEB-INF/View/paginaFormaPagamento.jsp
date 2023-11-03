<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/controller" var="linkController"/>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pagamento</title>
    <link rel="stylesheet" href="<c:url value="/style/styleFormaPagamento.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
</head>

<body>
    <header class="cabecalho">
        <p class="titulo__site">iBook</p>

        <form class="buscar__produto">
            <input class="barra_pesquisa" type="text" id="numero"
            name="numero" placeholder="Buscar">
            <button class="botao__pesquisar" type="submit">
                <img class="botao__pesquisar__lupa" src="./assets/pesquisar.png" alt="Pesquisar">
            </button>
        </form>

        <nav class="cabecalho__menu">
            <a class="cabecalho__menu__link" href="telaCarrinho.html">
                <img class="cabecalho__menu__icones" src="./assets/carrinho.png" alt="Carrinho"> Carrinho</a>
            <a class="cabecalho__menu__link" href="telaDePedidos.html">
                <img class="cabecalho__menu__icones" src="./assets/sacola.png" alt="Sacola">Compras</a>
            <a class="cabecalho__menu__link" href="telaPerfil.html">
                    <img class="cabecalho__menu__icones" src="./assets/perfil.png" alt="Perfil">Perfil</a>
        </nav>  
    </header>

    <a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>

    <main class="pagamento">

        <section class="pagamento__produto__metodos">
			
			<form class="pagamento__selecao">
				
				<c:forEach items="${usuarioLogado.listadeCartoes}" var="cartao">
                <div class="pagamento__selecao__opcao">
                    <label class="pagamento__selecao__opcao__seletor">
                        <input type="checkbox" id="idCartao" name="idCartao" value="${cartao.id}">
                        <span class="checkmark"></span>
                        Cartão de crédito 
                        <br>
                        ${cartao.bandeira.bandeira} - ${cartao.nrCartao}</label>
                </div>
                </c:forEach>

                <div class="pagamento__acoes">
                    <a class="pagamento__adiciona__metodo" href="/iBook/controller?acao=AdicionarCartao">
                        <img class="imagem__adicionar" src="./assets/adicionar.png" alt="add"> Adicionar método de pagamento
                    </a>
                <a class="pagamento__adiciona__cupom" href="/iBook/controller?acao=ConsultarCupons&id=${usuarioLogado.id}">
                    <img class="imagem__adicionar" src="./assets/adicionar.png" alt="add"> Adicionar cupom de desconto
                    </a>
                    </div>
                    
                 <c:forEach items="${Itens}" var="item">
		  
		  			<c:set var="valorProdutos"
						value="${valorProdutos + item.precoItem}" scope="page" />
				 
				 </c:forEach>
				
				 <c:forEach items="${usuarioLogado.listadeEnderecos}" var="endereco">
	            	<c:if test="${endereco.id == pedidoEnderecoId}">
	            	<c:set var="valorFrete"
							value="${endereco.valorFrete}" scope="page" />
				 	</c:if>
				 </c:forEach>
				 
				 <c:set var="valorCupons" value="0" scope="page" />
					<c:forEach items="${CuponsSelecionados}" var="cupons">
							<c:set var="valorCupons" value="${valorCupons + cupons.desconto}" scope="page" />
					</c:forEach>
				
				<input type="hidden" id="pedidoEnderecoId" name="pedidoEnderecoId" value="${pedidoEnderecoId}">
				<input type="hidden" id="valorProdutos" name="valorProdutos" value="${valorProdutos - valorCupons}">
				<input type="hidden" id="valorFrete" name="valorFrete" value="${valorFrete}">
				<!--<input type="hidden" id="valorTotal" name="valorTotal" value="${valorTotal}">-->
				<input type="hidden" id="idUsuario" name="idUsuario" value="${usuarioLogado.id}">
                <input class="pagamento__selecao__confirmar" id="acao" name="acao" type="submit" value="Confirmar pagamento">

			
				</form>            
        </section>

        <section class="descricao__produto">

            <p class="resumo__compra">
                <strong>
                    Resumo da compra
                </strong>
            </p>
			
			<c:forEach items="${Itens}" var="item">
			
            <p class="resumo__compra__produto">
              <strong>Produto:</strong> ${item.livro.titulo} - ${item.qtdeProdutos}X 
            </p>
			</c:forEach>
			 
            <p class="resumo__compra__preco">
                <strong> Valor do frete:</strong> R$ ${valorFrete}
            </p>
			
			<p class="resumo__compra__quantidade">
     			<strong>Valor itens:</strong> R$ ${valorProdutos}
            </p>
            
            <p class="resumo__compra__quantidade">
     			<strong>Desconto:</strong> R$ ${valorCupons}
            </p>
            
            <c:set var="valorTotal" value="${valorProdutos + valorFrete - valorCupons}" scope="page" />
            
            <c:choose>
            
            <c:when test="${valorTotal <= 0}">
	            <p class="resumo__compra__quantidade">
	     			<strong>Valor total: R$ 0.00</strong>
	            </p>
            </c:when>
            
            <c:otherwise>
				<p class="resumo__compra__quantidade">
	     			<strong>Valor total: R$ ${valorTotal}</strong>
	            </p>
            </c:otherwise>
            </c:choose>
        </section>

    </main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>

</html>