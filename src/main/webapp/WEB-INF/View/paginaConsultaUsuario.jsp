<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/controller" var="linkController"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Informações do usuario</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/styleConsultaClientes.css"/>">
</head>
<body>
    <header class="cabecalho">
        <p class="titulo__site">iBook</p>

        <form class="buscar__produto">
            <input class="barra_pesquisa" type="text" id="buscaProduto"
            name="buscaProduto" placeholder="Buscar">
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

    <a class="link__voltar" href="/iBook/controller?acao=Perfil&id=108">   
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar 
    </a>

    <div class="busca__clientes">
    <form class="buscar__cliente" action="${linkController}" method="get">
    
        <select class="select__filtro__busca__cliente" name="filtroPesquisaClientes" id="filtroPesquisaClientes">
            <option value="nome">Nome</option>
        </select>
        
        <input class="barra__pesquisa" type="text" id="paramBuscaCliente"
        name="paramBuscaCliente" placeholder="Buscar cliente">
        
        <input type="hidden" name="acao" value="ConsultarUsuarios">
        
        <button class="botao__pesquisar" type="submit">
            <img class="botao__pesquisar__lupa" src="./assets/pesquisar.png" alt="Pesquisar">
        </button>
        
    </form>
    </div>

    <main class="perfil">
           
    <h2 class="perfil__titulo">Informações do usuário</h2>

	<c:forEach items="${EntidadeDominio}" var="cliente">
    <section class="perfil__informacoes">


        <div class="perfil__informacoes__container">

            <div class="perfil__informacoes__container__cliente">
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Nome: </strong>${cliente.nome}</p>
                <p class="perfil__informacoes__container__cliente__informacao"><strong>E-mail:</strong> ${cliente.login.email}</p>
                
                <c:forEach items="${cliente.listadeTelefones}" var="telefone">
                		<p class="perfil__informacoes__container__cliente__informacao"><strong>Telefone: </strong>${telefone.numero}</p>
                </c:forEach>
                
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Data de nascimento: </strong><fmt:formatDate value="${cliente.dataNasc}" pattern="dd/MM/yyyy"/></p>
            </div>
            
            <img class="perfil__imagem" src="./assets/perfil_imagem_maior.png">

        </div>

        <div class="perfil__informacoes__container__acoes">
            <a class="perfil__acoes__excluir" href="/iBook/controller?acao=ExcluirUsuario&id=${cliente.id}">   
                Excluir conta
            </a>
            <a class="perfil__acoes__alterar" href="/iBook/controller?acao=ExibeDadosUsuario&id=${cliente.id}">   
                Ver dados
            </a>
        </div>

    </section>
    </c:forEach>
    
    </main>
</body>
</html>