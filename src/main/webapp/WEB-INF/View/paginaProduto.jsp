<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page contentType="text/html; charset=UTF-8" %>


<c:url value="/controller" var="linkController"/>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Venda</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/stylePaginaProduto.css"/>">
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
    
    <a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>

	<form action="${linkController}">    
    <main class="produto">
	<section class="produto__vitrine">
	<div>
        <img class="produto__imagem" src="./assets/${EntidadeObjeto.codImagem}.png" alt="Imagem do produto">
		<input type="hidden" name="codImage" id="codImage" value="${EntidadeObjeto.codImagem}">
	</div>
        <div class="produto__venda">
        	<input type="hidden" name="id" value="${EntidadeObjeto.id}">

            <h1 class="produto__nome"><strong class="titulo__destaque">${EntidadeObjeto.titulo}</strong></h1>
            
            <input type="hidden" name="tituloItem" id="tituloItem" value="${EntidadeObjeto.titulo}">

            <p class="produto__preco"><strong class="produto__preco__destaque">R$ ${EntidadeObjeto.preco}</strong><br></p>
            
            <input type="hidden" name="precoItem" id="precoItem" value="${EntidadeObjeto.preco}">

            <div class="produto__quantidade">
            
           <!-- <input class="produto__selecao__unidade" 
            	   type="number" id="qtdeItens" 
            	   name="qtdeItens" 
            	   min="1" max="${EntidadeObjeto.qtde}" 
            	   value="1"> -->
            
                <select class="produto__selecao__unidade" id="qtdeItens" name="qtdeItens"  required>	
				<c:forEach var="qtdeProdutos" begin="1" end="${EntidadeObjeto.qtde}" step="1">
         			<option value="${qtdeProdutos}" >${qtdeProdutos}</option>
      			</c:forEach>
                </select>  
                
                <input type="hidden" name="qtdeEmEstoque" id="qtdeEmEstoque" value="${EntidadeObjeto.qtde}">
                
                <p class="produto__quantidade__unidades">Unidade</p>
            </div>

            <div class="produto__links">
                
                <input class="produto__links__compra" type="submit" name="acao" id="acao" value="Comprar">
                            				
                <input class="produto__links__adiciona__carrinho" type="submit" name="acao" id="acao" value="Adicionar ao carrinho">
            </div>
         
        </div>
        </section>
        
         <section class="produto__tabela__informacoes">
         
         <table class="tabela__livro">
		<thead>
		        
		<tr>
			<th colspan="2">Informações do produto</th>
			
		</tr>
		
		    </thead>
		    <tbody>
		        <tr>
		            <td>Autor</td>
		            <td>${EntidadeObjeto.autor}</td>
		        </tr>
		        <tr>
		            <td>Categoria</td>
		            <td>${EntidadeObjeto.categoria}</td>
		        </tr>
		        <tr>
		            <td>Ano</td>
		            <td>${EntidadeObjeto.ano}</td>
		        </tr>
		        <tr>
		            <td>Editora</td>
		            <td>${EntidadeObjeto.editora}</td>
		        </tr>
		        <tr>
		            <td>Edição</td>
		            <td>${EntidadeObjeto.edicao}</td>
		        </tr>
		        <tr>
		            <td>Número de páginas</td>
		            <td>${EntidadeObjeto.numeroPaginas}</td>
		        </tr>
		        <tr>
		            <td>Sinopse</td>
		            <td>${EntidadeObjeto.sinopse}</td>
		        </tr>
		        <tr>
		            <td>Altura</td>
		            <td>${EntidadeObjeto.altura} cm 
		            <input type="hidden" name="alturaProduto" id="alturaProduto" value="${EntidadeObjeto.altura}">
		            </td>
		        </tr>
		        <tr>
		            <td>Largura</td>
		            <td>${EntidadeObjeto.largura} cm
		            <input type="hidden" name="larguraProduto" id="larguraProduto" value="${EntidadeObjeto.largura}">
		            </td>
		        </tr>
		        <tr>
		            <td>Profundidade</td>
		            <td>${EntidadeObjeto.profundidade} cm
		            <input type="hidden" name="profundidadeProduto" id="profundidadeProduto" value="${EntidadeObjeto.profundidade}">
		            </td>
		        </tr>
		        <tr>
		            <td>Código de barras</td>
		            <td>${EntidadeObjeto.codBarras}</td>
		        </tr>
		    </tbody>
		</table>
         
         </section>
        
        
    </main>
    </form>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>
</html>