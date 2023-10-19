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
    <title>Carrinho</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/stylePaginaCarrinho.css"/>">
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
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=Carrinho">
                <img class="cabecalho__menu__icones" src="./assets/carrinho.png" alt="Carrinho"> Carrinho</a>
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=PaginaConsultaVendas&id=110">
                <img class="cabecalho__menu__icones" src="./assets/sacola.png" alt="Sacola">Compras</a>
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=formLogin">
                    <img class="cabecalho__menu__icones" src="./assets/perfil.png" alt="Perfil">Perfil</a>
        </nav> 
    </header>
    
    <a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>
    <form action="${linkController}"> 
    <main class="carrinho">

        <section class="carrinho__produtos">

            <section class="carrinho__conteudo">
                    <div  class="carrinho__produtos__tabela">
                        <h2 class="carrinho__produtos__header">Itens</h2>
                    
                    <c:set var="contadorElementosLista" value="0" scope="page" />
                     <c:set var="valorTotal" value="0" scope="page" />
                   
                    <c:forEach items="${Itens}" var="item">
                    <div class="carrinho__produtos__produto">
                        <img class="imagem__produto" src="./assets/${item.livro.codImagem}.png" alt="imagem do produto">
                        <div class="carrinho__produtos__informacoes">
                            <p class="carrinho__produtos__informacoes__nome">${item.livro.titulo}</p>
                            
                            <p class="carrinho__produtos__valor">R$ ${item.precoItem}</p>

							<!--<input class="carrinho__produtos__selecao__unidade" 
								   type="number" 
								   id="qtdeProdutos" 
								   name="qtdeProdutos" 
								   min="1"
								   max="${item.livro.qtde}" 
								   value="${item.qtdeProdutos}">-->
                             
                             <p class="carrinho__produtos__valor">${item.qtdeProdutos} X</p>
                             
                             <input type="hidden" id="id" name="id" value="${item.id}">
                             
                            <!--<select class="carrinho__produtos__selecao__unidade" id="qtdeItens" name="qtdeItens">
								<option value="${item.qtdeProdutos}" >${item.qtdeProdutos}</option>
								<c:forEach var="qtdeProdutos" begin="1" end="${item.livro.qtde}" step="1">
				         		<option value="${qtdeProdutos}" >${qtdeProdutos}</option>
				      			</c:forEach>
                            </select> -->
                            
							<div class="carrinho__produtos__acoes">
                            
                            <a class="carrinho__produtos__excluir" href="/iBook/controller?acao=RemoverDoCarrinho&id=${item.id}">Excluir</a>
                            
                            <a class="carrinho__produtos__alterar" href="/iBook/controller?acao=VisualizarItemDoCarrinho&id=${item.id}">Alterar</a>
                           
                            <!--<button class="carrinho__produtos__alterar" type="submit" name="acao" id="acao" value="AlterarCarrinho">Alterar</button> -->
                     	
                        	</div>
                        </div>                        
                    </div>
                    	
					<c:set var="valorTotal"
						value="${valorTotal + item.precoItem}" scope="page" />
						
					<c:set var="contadorElementosLista"
						value="${contadorElementosLista + item.qtdeProdutos}" scope="page" />
                    
                    </c:forEach>
                   
                   <c:if test="${contadorElementosLista == 0}">
                    <div>
                    	<h2 class="carrinho__produtos__produto">Seu carrinho está vazio :(</h2>
                   	</div>
                    </c:if>
                   
            </div>
            
              


        </section> 
       
        <div class="carrinho__resumo__compra">
            <div class="carrinho__resumo__compra__informacoes">
            <h2 class="carrinho__resumo__compra__titulo">Resumo</h2>
            
            <p class="carrinho__resumo__compra__dados">Quantidade de itens:
            ${contadorElementosLista}</p>
            
            <p class="carrinho__resumo__compra__dados">Total do pedido: R$ ${valorTotal}</p>
            </div>
            <div class="carrinho__resumo__compra__acao">
            <input type="hidden" name="idUsuario" id="idUsuario" value="110">
            
            <c:if test="${contadorElementosLista != 0}">
            <input class="carrinho__produtos__comprar" type="submit" name="acao" id="acao" value="Continuar">
           	</c:if>
           	
           	<a class="carrinho__produtos__voltar" href="/iBook/controller?acao=PaginaInicial">Voltar as compras</a>
            </div>
            </div>     
    </section>

        
    </main>
     </form>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>

</html>