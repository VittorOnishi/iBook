<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/controller" var="linkController" />

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Perfil</title>
<link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
<link rel="stylesheet" href="<c:url value="/style/stylePerfil.css"/>">

</head>
<body>
	<header class="cabecalho">

		<p class="titulo__site">iBook</p>

		<form class="buscar__produto">
			<input class="barra_pesquisa" type="text" id="paramBuscaProduto"
				name="paramBuscaProduto" placeholder="Buscar">
			<button class="botao__pesquisar" type="submit">
				<img class="botao__pesquisar__lupa" src="./assets/pesquisar.png"
					alt="Pesquisar">
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
	<a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">
		<img class="icone__voltar" src="./assets/botaoVoltar.png">
		Voltar
	</a>

	<main class="perfil">

		<div class="perfil__link">
			<img class="perfil__imagem" src="./assets/perfil.png" alt="">
			<p>${usuarioLogado.nome}
				<br> ${usuarioLogado.login.email}
			</p>
		</div>
		<!-- <a class="perfil__link" href=""><img class="perfil__imagem"
			src="./assets/informacoescliente.png" alt="">
			<p>
				Minhas informações <br> Informações referentes ao uso da sua
				conta
			</p></a> <a class="perfil__link" href=""><img class="perfil__imagem"
			src="./assets/cartao.png" alt="">
			<p>
				Cartões<br>Cartões salvos na sua conta
			</p></a> <a class="perfil__link" href=""><img class="perfil__imagem"
			src="./assets/localizacao.png" alt="">
			<p>
				Endereços<br>Endereços vinculados à conta
			</p></a> --><a class="perfil__link"
			href="/iBook/controller?acao=PaginaConsultaUsuarios"><img
			class="perfil__imagem" src="./assets/clientes.png" alt="Clientes">
			<p>
				Clientes<br>Consultar cadastro de compradores
			</p></a> <a class="perfil__link"
			href="/iBook/controller?acao=PaginaConsultaVendas"><img
			class="perfil__imagem" src="./assets/vendas.png" alt="Vendas">
			<p>
				Vendas<br>Consultar vendas realizadas
			</p></a> <a class="perfil__link" href="/iBook/controller?acao=AnaliseVendas"><img
			class="perfil__imagem" src="./assets/grafico.png" alt="Grafico">
			<p>
				Estatísticas<br>Estatísticas de vendas
			</p></a> <a class="perfil__link" href="/iBook/controller?acao=LogOut"><img
			class="perfil__imagem" src="./assets/logout.png" alt="LogOut">
			<p>
				Log out<br>Encerrar sessão
			</p></a>
		<!-- <button class="perfil__link" type="submit"><img class="perfil__imagem" src="./assets/logout.png" alt="LogOut"> <p>Log out<br>Encerrar sessão</p></button> -->
	</main>
	<footer class="rodape">
		<p>Desenvolvido por Vittor Onishi</p>
	</footer>
</body>
</html>