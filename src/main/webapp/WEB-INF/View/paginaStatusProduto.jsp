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
<title>Status</title>
<link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
<link rel="stylesheet"
	href="<c:url value="/style/stylePaginaStatusProduto.css"/>">
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
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=Carrinho">
                <img class="cabecalho__menu__icones" src="./assets/carrinho.png" alt="Carrinho"> Carrinho</a>
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=ConsultarPedido&id=110">
                <img class="cabecalho__menu__icones" src="./assets/sacola.png" alt="Sacola">Compras</a>
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=formLogin">
                    <img class="cabecalho__menu__icones" src="./assets/perfil.png" alt="Perfil">Perfil</a>
        </nav>  
	</header>
	<a class="link__voltar" href="/iBook/controller?acao=VerItensPedido&id=${EntidadeObjeto.id}"> <img
		class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
	</a>

	<main class="status">

		<section class="status__entrega">
			<div class="status__entrega__informacoes">
				<p class="status__entrega__informacoes__informacao">
					<strong>Numero de pedido: </strong> ${EntidadeObjeto.id}
				</p>
				<p class="status__entrega__informacoes__informacao">
					<strong>Endereco de entrega:</strong>
					${EntidadeObjeto.endereco.logradouro},
					${EntidadeObjeto.endereco.numero},
					${EntidadeObjeto.endereco.cidade.descricao} -
					${EntidadeObjeto.endereco.cidade.estado.descricao}
				</p>
				<p class="status__entrega__informacoes__informacao">
					<strong>Valor do item: </strong> R$
					${EntidadeObjeto.item.precoItem}
				</p>
				<p class="status__entrega__informacoes__informacao">
					<strong>Status: </strong>${EntidadeObjeto.item.statusPedido}
				</p>
			</div>

			<div>
				<img class="imagem__produto"
					src="./assets/${EntidadeObjeto.item.livro.codImagem}.png"
					alt="imagem do produto">
			</div>
		</section>

		<section class="barra__status">
			<form action="${linkController}">
				<h2 class="status__titulo">Status:</h2>
				<select class="status__select" name="statusItem"
					id="statusItem" required>
					<option value="" disabled selected>${EntidadeObjeto.item.statusPedido}</option>
					<option value="EM PROCESSAMENTO">EM PROCESSAMENTO</option>
					<option value="PEDIDO APROVADO">PEDIDO APROVADO</option>
					<option value="PAGAMENTO RECUSADO">PAGAMENTO RECUSADO</option>
					<option value="EM TRÂNSITO">EM TRÂNSITO</option>
					<option value="ENTREGUE">ENTREGUE</option>
					<option value="TROCA APROVADA">TROCA APROVADA</option>
					<option value="TROCA REALIZADA">TROCA REALIZADA</option>
					<option value="TROCA RECUSADA">TROCA RECUSADA</option>
				</select> 
				
				<input type="hidden" name="idItem" id="idItem" value="${EntidadeObjeto.item.id}">
				
				<input type="hidden" name="idUsuario" id="idUsuario" value="${EntidadeObjeto.item.usuario.id}">
				
				<input type="hidden" name="precoItem" id="precoItem" value="${EntidadeObjeto.item.precoItem}">
				
				<button class="status__alterar" type="submit" name="acao" id="acao" value="AlterarStatus">
					Alterar Status
				</button>
			</form>
		</section>

	</main>
	<footer class="rodape">
		<p>Desenvolvido por Vittor Onishi</p>
	</footer>
</body>
</html>