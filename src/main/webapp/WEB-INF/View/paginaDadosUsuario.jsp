<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/controller" var="linkController"/>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dados do Cliente</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/styleConsultaClientes.css"/>">
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
    
    <a class="link__voltar" href="/iBook/controller?acao=PaginaConsultaUsuarios">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>
    
    <main class="perfil">
    
       <section class="perfil__informacoes">
        
        <h2 class="cliente__cadastro__titulo">DADOS PESSOAIS</h2>
        
        <div class="perfil__informacoes__container">
   
            <div class="perfil__informacoes__container__cliente">
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Nome: </strong>${EntidadeObjeto.nome}</p>
                
                <p class="perfil__informacoes__container__cliente__informacao"><strong>E-mail:</strong> ${EntidadeObjeto.login.email}</p>
                
                <c:forEach items="${EntidadeObjeto.listadeTelefones}" var="telefone">
                		<p class="perfil__informacoes__container__cliente__informacao"><strong>Telefone: </strong>${telefone.numero}</p>
                </c:forEach>
                
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Data de nascimento: </strong><fmt:formatDate value="${EntidadeObjeto.dataNasc}" pattern="dd/MM/yyyy"/></p>
            
            	<p class="perfil__informacoes__container__cliente__informacao"><strong>CPF: </strong>${EntidadeObjeto.cpf}</p>
            </div>
            
            <img class="perfil__imagem" src="./assets/perfil_imagem_maior.png">

        </div>

        <div class="perfil__informacoes__container__acoes">
            <a id="alterarDadosCliente" class="perfil__acoes__alterar" href="/iBook/controller?acao=ExibeUsuario&id=${EntidadeObjeto.id}">   
                Alterar dados
            </a>
        </div>
       
    </section>
    
    <c:forEach items="${EntidadeObjeto.listadeEnderecos}" var="endereco">
    
    <section class="perfil__informacoes">
	
	<h2 class="cliente__cadastro__titulo">${endereco.tipoEndereco}</h2>

        <div class="perfil__informacoes__container">

            <div class="perfil__informacoes__container__cliente">
            
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Logradouro: </strong>${endereco.logradouro}</p>
                
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Tipo de Residencia: </strong>${endereco.tipoResidencia}</p>
              
	            <p class="perfil__informacoes__container__cliente__informacao"><strong>Tipo de Logradouro: </strong>${endereco.tipoLogradouro}</p>
                
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Numero: </strong>${endereco.numero}</p>
            
             	<p class="perfil__informacoes__container__cliente__informacao"><strong>Observação: </strong>${endereco.observacao}</p>
             
             	 <p class="perfil__informacoes__container__cliente__informacao"><strong>Bairro: </strong>${endereco.bairro}</p>
             	 
             	 <p class="perfil__informacoes__container__cliente__informacao"><strong>CEP: </strong>${endereco.cep}</p>
             	 
             	 <p class="perfil__informacoes__container__cliente__informacao"><strong>Cidade: </strong>${endereco.cidade.descricao}, ${endereco.cidade.estado.descricao}</p>
             	 
             	 <p class="perfil__informacoes__container__cliente__informacao"><strong>País: </strong>${endereco.cidade.estado.pais.descricao}</p>   	  
             	   
            </div>
            
            <img class="perfil__imagem" src="./assets/localizacao_128px.png">

        </div>

        <div class="perfil__informacoes__container__acoes">
            <a class="perfil__acoes__excluir" href="/iBook/controller?acao=ExcluirEndereco&id=${endereco.id}">   
                Excluir endereco
            </a>
            <a class="perfil__acoes__alterar" href="/iBook/controller?acao=ExibeEndereco&id=${endereco.id}">   
                Alterar dados
            </a>
        </div>
   
    </section>
   </c:forEach>
    
    <c:forEach items="${EntidadeObjeto.listadeCartoes}" var="cartao">
    
    <section class="perfil__informacoes">

		<h2 class="cliente__cadastro__titulo">CARTÃO DE CREDITO</h2>
			
        <div class="perfil__informacoes__container">

            <div class="perfil__informacoes__container__cliente">
            
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Numero do Cartão: </strong>${cartao.nrCartao}</p>
                
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Nome do portador: </strong>${cartao.nomeCartao}</p>
                
                <p class="perfil__informacoes__container__cliente__informacao"><strong>Código de segurança: </strong>${cartao.codSeguranca}</p>
            
            	<p class="perfil__informacoes__container__cliente__informacao"><strong>Bandeira: </strong>${cartao.bandeira.bandeira}</p>
            </div>
            
            <img class="perfil__imagem" src="./assets/cartao_128px.png">

        </div>

        <div class="perfil__informacoes__container__acoes">
            <a class="perfil__acoes__excluir" href="/iBook/controller?acao=ExcluirCartao&id=${cartao.id}">   
                Excluir cartao
            </a>
            <a class="perfil__acoes__alterar" href="/iBook/controller?acao=ExibeCartao&id=${cartao.id}">   
                Alterar dados
            </a>
        </div>
      
    </section>
     </c:forEach>
           
    </main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>

</html>