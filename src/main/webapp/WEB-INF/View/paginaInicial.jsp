<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/controller" var="linkController"/>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
   	<link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/styleHome.css"/>">
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
    <main class="home">

        <img class="home__produtos__anuncio" src="./assets/header_anuncio.png" alt="Anuncio">

    <section class="home__produtos__lista">
    
    <c:forEach items="${EntidadeDominio}" var="produto">
        <div class="home__produtos__produto"> 
        <a id="selecionarProduto" class="home__produtos__produto__link" href="/iBook/controller?acao=ExibeDadosProduto&id=${produto.id}">
            <img class="imagem__produto" src="<c:url value="/assets/${produto.codImagem}.png"/>" alt="Produto"/>
            <h3>${produto.titulo}</h3>
            <p>R$ ${produto.preco}</p>
        </a>
        </div>
    </c:forEach>    
        </section>



    </main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>  
</body>
</html>