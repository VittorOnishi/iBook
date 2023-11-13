<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/controller" var="linkController"/>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Alterar Dados Endereco</title>
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
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=Carrinho">
                <img class="cabecalho__menu__icones" src="./assets/carrinho.png" alt="Carrinho"> Carrinho</a>
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=ConsultarPedido&id=110">
                <img class="cabecalho__menu__icones" src="./assets/sacola.png" alt="Sacola">Compras</a>
            <a class="cabecalho__menu__link" href="/iBook/controller?acao=formLogin">
                    <img class="cabecalho__menu__icones" src="./assets/perfil.png" alt="Perfil">Perfil</a>
        </nav>  
    </header>
    
    <a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>
    
    <main class="cliente">
        
     <form class="cliente__cadastro" action="${linkController}" method="post">
        
       <div class="cliente__cadastro__dados">
		
		
                <div class="cliente__cadastro__informacoes__endereco"> 
                
                    <h2 class="cliente__cadastro__titulo">${EntidadeObjeto.tipoEndereco}</h2>
                                
                     <input type="hidden" name="id" value="${EntidadeObjeto.id}" />
                     
                     <input type="hidden" name="tipoEndereco" value="${EntidadeObjeto.tipoEndereco}" />
                
                <select class="cliente__cadastro__select" name="tipoResidencia" id="tipoResidencia" required>
                    <option value="${EntidadeObjeto.tipoResidencia}">${EntidadeObjeto.tipoResidencia}</option>
                    <option value= "casa">Casa</option>
                     <option value= "apartamento">Apartamento</option>
                
                </select>
                
                <input class="cliente__cadastro__campos" type="text" name="logradouro" id="logradouro" value="${EntidadeObjeto.logradouro}" placeholder="Logradouro" required>
                
                <select class="cliente__cadastro__select" name="tipoLogradouro" id="tipoLogradouro">
                    <option value="${EntidadeObjeto.tipoLogradouro}">${EntidadeObjeto.tipoLogradouro}</option>
                    <option value= "estrada">Estrada</option>
                    <option value= "rua">Rua</option>
                </select>
                
                <input class="cliente__cadastro__campos" type="text" name="numero" id="numero" value="${EntidadeObjeto.numero}" placeholder="Número" required>
                
                <input class="cliente__cadastro__campos" type="text"
						name="observacao" id="observacao" value="${EntidadeObjeto.observacao}" placeholder="Observação"
						required> 
                
                <input class="cliente__cadastro__campos" type="text" name="bairro" id="bairro" value="${EntidadeObjeto.bairro}" placeholder="Bairro" required>
                
                <input class="cliente__cadastro__campos" type="text" name="cep" id="cep" value="${EntidadeObjeto.cep}" pattern="\d{5}-\d{3}"  placeholder="CEP" required>
                
                <input class="cliente__cadastro__campos" type="text" name="cidade" id="cidade" value="${EntidadeObjeto.cidade.descricao}" placeholder="Cidade" required>
                
                <select class="cliente__cadastro__select" id="estado" name="estado" required>
                    <option value="${EntidadeObjeto.cidade.estado.descricao}">${EntidadeObjeto.cidade.estado.descricao}</option>
					<option value="AC">Acre</option>
					<option value="AL">Alagoas</option>
					<option value="AP">Amapá</option>
					<option value="AM">Amazonas</option>
					<option value="BA">Bahia</option>
					<option value="CE">Ceará</option>
					<option value="DF">Distrito Federal</option>
					<option value="ES">Espirito Santo</option>
					<option value="GO">Goiás</option>
					<option value="MA">Maranhão</option>
					<option value="MT">Mato Grosso</option>
					<option value="MS">Mato Grosso do Sul</option>
					<option value="MG">Minas Gerais</option>
					<option value="PA">Pará</option>
					<option value="PB">Paraíba</option>
					<option value="PR">Paraná</option>
					<option value="PE">Pernambuco</option>
					<option value="PI">Piauí</option>
					<option value="RJ">Rio de Janeiro</option>
					<option value="RN">Rio Grande no Norte</option>
					<option value="RS">Rio Grande do Sul</option>
					<option value="RO">Rondônia</option>
					<option value="RR">Roraima</option>
					<option value="SC">Santa Catarina</option>
					<option value="SP">São Paulo</option>
					<option value="SE">Sergipe</option>
					<option value="TO">Tocantins</option>
                </select>
                
                <input class="cliente__cadastro__campos" type="text" name="pais" id="pais" value="${EntidadeObjeto.cidade.estado.pais.descricao}" placeholder="País" required>
                
                </div>
                </div>
			
                <div>
                	<input type="hidden" name="acao" value="AlterarEndereco">
                    <input class="cliente__cadastro__cadastrar" type="submit" value="Atualizar">
                </div>
            </form>

           
    </main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>

</html>