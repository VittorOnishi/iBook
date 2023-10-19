<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/controller" var="linkController"/>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/styleLogin.css"/>">
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
    
    <main class="login">

        <section class="login__form">
        <img class="imagem__perfil" src="./assets/perfil_imagem_maior.png" alt="Perfil">

            <form class="login__cliente" action="">
                <input class="login__cliente__campos" type="text" id="email"
                name="email" placeholder="E-mail">

                <input class="login__cliente__campos" type="text" id="senha"
            name="senha" placeholder="Senha">

            <input class="login__cliente__botao" type="submit" name="acao" value="Login">

            <a class="login__cliente__link" href="/iBook/controller?acao=formCadastroUsuario">Criar conta</a>
            </form>
        </section>    
    </main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>

</html>