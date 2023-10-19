<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/controller" var="linkController"/>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Itens</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/styleItensPedido.css"/>">
</head>

<body>
    <header class="cabecalho">
        
        <p class="titulo__site">iBook</p>
        
        <form class="buscar__produto">
            <input class="barra_pesquisa" type="text" id="numero"
            name="numero" placeholder="Buscar">
            <button class="botao__pesquisar" type="submit">
                <img class="butao__pesquisar__lupa" src="./assets/pesquisar.png" alt="Pesquisar">
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
    <main class="compras">

    <section class="compras__lista">

        <a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">   
            <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar 
        </a>

        <table class="compras__lista__produtos">
            <tr>
                <th class="compras__lista__produtos__header">Itens</th>
            </tr>
            
            <c:forEach items="${EntidadeObjeto.listaItens}" var="item">
            <tr>
            
            <td class="compras__lista__produtos__produto">
                <img src="./assets/${item.livro.codImagem}.png" class="imagem__produto" alt="Imagem do produto">

                <div class="compras__lista__produtos__produto__descricao">
                <p class=>
                    <strong class="compras__lista__produtos__produto__titulo__destaque">${item.livro.titulo}</strong>
                </p>
                
                <p>R$ ${item.precoItem}</p>
                
                <p>${item.qtdeProdutos} X itens</p>
                
                
                <p><strong class="compras__lista__produtos__produto__titulo__destaque">
                Endereço de entrega:
                </strong>
                 
                ${EntidadeObjeto.endereco.logradouro}, 
                						${EntidadeObjeto.endereco.bairro},
                						${EntidadeObjeto.endereco.cidade.descricao},
                						${EntidadeObjeto.endereco.cidade.estado.descricao}
                						</p>
                						
                 <p><strong class="compras__lista__produtos__produto__titulo__destaque">
                Status: </strong> ${item.statusPedido} </p>						
                
                <!-- <p><strong class="compras__lista__produtos__produto__titulo__destaque">
                Previsão de chegada: 
                </strong></p> -->
                
                </div>

                <div class="compras__lista__produtos__produto__acoes">
                    <a class="compras__lista__produtos__produto__comprar__novamente" href="/iBook/controller?acao=ExibeDadosProduto&id=${item.livro.id}">   
                        Comprar novamente
                    </a>
                    
                    <c:if test="${usuarioLogado.isAdmin == true}">
               		 <a class="compras__lista__produtos__produto__ver__compra" href="/iBook/controller?acao=VerItem">   
                        Ver compra
                    </a>
                    </c:if> 
                     
                    <a class="compras__lista__produtos__produto__trocar__produto" href="telaDeDevolucao.html">   
                        Trocar produto
                    </a>
                </div>

            </td>
            </tr>
            </c:forEach>

        </table>

    </section>

    </main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>  
</body>

</html>