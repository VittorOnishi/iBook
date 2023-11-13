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
    <title>Alterar quantidade</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/stylePaginaItemCarrinho.css"/>">
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
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=ConsultarPedido&id=110">
                <img class="cabecalho__menu__icones" src="./assets/sacola.png" alt="Sacola">Compras</a>
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=formLogin">
                    <img class="cabecalho__menu__icones" src="./assets/perfil.png" alt="Perfil">Perfil</a>
        </nav>    
    </header>
    
    <a class="link__voltar" href="/iBook/controller?acao=Carrinho">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>
    <form action="${linkController}"> 
    <main class="carrinho__item">

            <section class="carrinho__conteudo__item">
                    <div  class="carrinho__produtos__tabela">
                        <h2 class="carrinho__produtos__header">Item</h2>

                    <div class="carrinho__produtos__produto">
                        <img class="imagem__produto" src="./assets/${EntidadeObjeto.livro.codImagem}.png" alt="imagem do produto">
                        <div class="carrinho__produtos__informacoes">
                            <p class="carrinho__produtos__informacoes__nome">${EntidadeObjeto.livro.titulo}</p>
                            
                            <p class="carrinho__produtos__valor">R$ ${EntidadeObjeto.precoItem}</p>

							<!--<input class="carrinho__produtos__selecao__unidade" 
								   type="number" 
								   id="qtdeProdutos" 
								   name="qtdeProdutos" 
								   min="1"
								   max="${item.livro.qtde}" 
								   value="${item.qtdeProdutos}">-->
                             
                             <input type="hidden" id="id" name="id" value="${EntidadeObjeto.id}">
                             <input type="hidden" id="precoItem" name="precoItem" value="${EntidadeObjeto.livro.preco}">
                             
                             <select class="carrinho__produtos__selecao__unidade" id="qtdeItens" name="qtdeItens">
								<option value="${EntidadeObjeto.qtdeProdutos}" >${EntidadeObjeto.qtdeProdutos}</option>
								<c:forEach var="qtdeProdutos" begin="1" end="${EntidadeObjeto.livro.qtde}" step="1">
				         		<option value="${qtdeProdutos}" >${qtdeProdutos}</option>
				      			</c:forEach>
                            </select> 
                            
							<div class="carrinho__produtos__acoes">
                   
                           	<button class="carrinho__produtos__alterar__submit" type="submit" name="acao" id="acao" value="AlterarCarrinho">Alterar</button>
                     	
                        	</div>
                        </div>                        
                    </div>
                   
            </div>
         
        </section> 
        
    </main>
    </form>
 <!--  <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer> -->
</body>

</html>