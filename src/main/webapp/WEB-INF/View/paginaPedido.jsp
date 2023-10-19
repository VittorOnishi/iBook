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
    <title>Pedidos</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/stylePedidos.css"/>">
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
    <main class="pedidos">

        <section class="pedidos">

            <a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">
                <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
            </a>
            
        <form class="buscar__pedido" action="${linkController}" method="get">
    
        <select class="select__filtro__busca__pedido" name="filtroPesquisaPedido" id="filtroPesquisaPedido">
            <option value="nome">Nome</option>
        </select>
        
        <input class="barra__pesquisa" type="text" id="paramBuscaPedido"
        name="paramBuscaPedido" placeholder="Buscar pedido">
        
        <input type="hidden" name="acao" value="ConsultarPedido">
        
        <button class="botao__pesquisar" type="submit">
            <img class="botao__pesquisar__lupa" src="./assets/pesquisar.png" alt="Pesquisar">
        </button>
        
    	</form>

            <table class="pedidos__lista__produtos">
                <tr>
                    <th class="pedidos__lista__header" colspan="2">Pedidos</th>
                </tr>
				
				<c:forEach items="${EntidadeLista}" var="pedido">
                <tr class="pedidos__lista__informacoes">
                    <td class="pedidos__lista__informacoes__dados">

                        <p class="pedidos__lista__informacoes__dados__titulo"><strong class="titulo__destaque">
                                Dados do pedido:
                            </strong></p>

                        <p class="pedidos__lista__informacoes__dados__numeropedido">Número do pedido: ${pedido.id}</p>
                        <p class="pedidos__lista__informacoes__dados__datapedido">Data do pedido: ${pedido.dataPedido}</p>
                        <p class="pedidos__lista__informacoes__dados__preco">Valor: R$ ${pedido.valorTotal}</p>

                        <!-- </td> -->

                        <!-- <td class="pedidos__lista__informacoes__dados"> -->
						
                        <p class="pedidos__lista__dados__produtos__titulo"><strong class="titulo__destaque">
                                Produtos:
                            </strong></p>
						<c:forEach items="${pedido.listaItens}" var="itemPedido">
                        <p class="pedidos__lista__dados__produtos__titulo">${itemPedido.qtdeProdutos}X ${itemPedido.livro.titulo}</p>
						</c:forEach>

                        <!-- </td> -->

                    <td class="pedidos__lista__informacoes__acoes">
                        <a class="pedidos__lista__informacoes__acoes__ver__pedido" href="/iBook/controller?acao=VerItensPedido&id=${pedido.id}">
                            Ver pedido
                        </a>
                        <a class="pedidos__lista__informacoes__acoes__trocar__pedido" href="telaDeDevolucao.html">
                            Trocar pedido
                        </a>
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