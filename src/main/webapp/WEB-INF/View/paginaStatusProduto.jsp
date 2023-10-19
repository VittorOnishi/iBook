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
    <title>Status</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/stylePaginaStatusProduto.css"/>">
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
    <a class="link__voltar" href="telaDeCompras.html">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>

    <main class="status">

    <section class="status__entrega">
            <div class="status__entrega__informacoes">
                <p class="status__entrega__informacoes__informacao">
                    Numero de pedido:
                </p>
                <p class="status__entrega__informacoes__informacao">
                    Descricao:
                </p>
                <p class="status__entrega__informacoes__informacao">
                    Endereco de entrega:
                </p>
                <p class="status__entrega__informacoes__informacao">
                    Previsão de chegada:
                </p>
            </div>

            <div>
                <img class="imagem__produto" src="./assets/trilogia-o-senhor-dos-aneis-novo-01.png" alt="imagem do produto">
            </div>
    </section>
    
    <section class="barra__status">
    <h2 class="status__titulo">Status:</h2>
    <img src="./assets/status de entrega.png" alt="Status de entrega">
    </section>
    
</main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>  
</body>
</html>