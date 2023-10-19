<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="br.com.iBook.dominio.*" %>

<c:url value="/controller" var="linkController"/>

<!DOCTYPE html>
<html lang="pt-br">

<%
  Usuario usuario = (Usuario)session.getAttribute("usuario");

%>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Dados Cliente</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/styleCadastroClientes.css"/>">
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
    
    <a class="link__voltar" href="/iBook/controller?acao=ExibeDadosUsuario&id=${EntidadeObjeto.id}">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>
    
    <main class="cliente">
    
            <form class="cliente__cadastro" action="${linkController}" method="post">
                <div class="cliente__cadastro__dados">
                <div class="cliente__cadastro__informacoes__pessoais">
                <h2 class="cliente__cadastro__titulo">Dados Pessoais</h2>
                
                <input type="hidden" name="id" value="${EntidadeObjeto.id}" />
                
                
                
                <select class="cliente__cadastro__select" id="genero" name="genero">
                    <option value="${EntidadeObjeto.genero}">${EntidadeObjeto.genero}</option>
                    <option value="M">Masculino</option>
                    <option value="F">Feminino</option>
    				<option value="Outro">Outro</option>
                </select>
                
                <input class="cliente__cadastro__campos" type="text" name="nomeCliente" id="nomeCliente" value="${EntidadeObjeto.nome}" placeholder="Nome" required>
                
                <input class="cliente__cadastro__campos" type="text" name="dataNasc" id="dataNasc" value="<fmt:formatDate value="${EntidadeObjeto.dataNasc}" pattern="dd/MM/yyyy"/>" pattern="\d{2}/\d{2}/\d{4}" placeholder="Data de nascimento" required>
                
                <input class="cliente__cadastro__campos" type="text" name="cpf" id="cpf" value="${EntidadeObjeto.cpf}" placeholder="CPF" required>
                
                <c:forEach items="${EntidadeObjeto.listadeTelefones}" var="telefone" >
                
		                <input class="cliente__cadastro__campos" type="text" name="telefone" id="telefone" value="${telefone.numero}" pattern="\d{2} \d{4,5}-\d{4}" placeholder="Telefone" required>
		                
		                 <input type="hidden" name="tel_id" value="${telefone.id}" />
		                
		                <select class="cliente__cadastro__select" name="tipoTelefone" id="tipoTelefone" required>
		                    <option value="${telefone.tipo}">${telefone.tipo}</option>
							<option value="Residencial">Residencial</option>
							<option value="Celular">Celular</option>
							<option value="Contato">Contato</option>
		                </select>
		                
                </c:forEach>
                
                <input class="cliente__cadastro__campos" type="text" name="e-mail" id="e-mail" value="${EntidadeObjeto.login.email}"  pattern="[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}" placeholder="E-mail" required>
                
                <input class="cliente__cadastro__campos" type="password" name="senha" id="senha" value="${EntidadeObjeto.login.senha}" placeholder="Senha" required>
                
                <input class="cliente__cadastro__campos" type="password" name="senhaConfirmacao" id="senhaConfirmacao" value="${EntidadeObjeto.login.senha}" placeholder="Confirmar senha" required>
                
                </div>
			
                </div>
			
                <div>
                	<input type="hidden" name="acao" value="AlterarUsuario">
                    <input class="cliente__cadastro__cadastrar" type="submit" value="Atualizar">
                </div>
            </form>

           
    </main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>

</html>