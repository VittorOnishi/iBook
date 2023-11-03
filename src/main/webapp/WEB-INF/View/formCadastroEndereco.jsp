<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/controller" var="linkController"/>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastrar novo endereco</title>
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
    
    <a class="link__voltar" href="/iBook/controller?acao=PaginaInicial">
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar
    </a>
    
    <main class="cliente">
        
     <form class="cliente__cadastro" action="${linkController}" method="post">
        
       <div class="cliente__cadastro__dados">
		
		
                <div class="cliente__cadastro__informacoes__endereco"> 
                
                    <h2 class="cliente__cadastro__titulo">ENDERE�O DE ENTREGA</h2>
                                
                     <input type="hidden" name="id" value="${usuarioLogado.id}" />
                     
                     <input type="hidden" name="tipoEndereco" value="ENTREGA" />
                
                <select class="cliente__cadastro__select" name="tipoResidencia" id="tipoResidencia" required>
                     <option value="" disabled selected>Tipo de residencia</option>
                     <option value= "casa">Casa</option>
                     <option value= "apartamento">Apartamento</option>
                
                </select>
                
                <input class="cliente__cadastro__campos" type="text" name="logradouro" id="logradouro" placeholder="Logradouro" required>
                
                <select class="cliente__cadastro__select" name="tipoLogradouro" id="tipoLogradouro" required>
                    <option value="" disabled selected>Tipo de logradouro</option>
                    <option value= "estrada">Estrada</option>
                    <option value= "rua">Rua</option>
                </select>
                
                <input class="cliente__cadastro__campos" type="text" name="numero" id="numero" placeholder="N�mero" required>
                
                <input class="cliente__cadastro__campos" type="text"
						name="observacao" id="observacao" placeholder="Observa��o"
						required> 
                
                <input class="cliente__cadastro__campos" type="text" name="bairro" id="bairro" placeholder="Bairro" required>
                
                <input class="cliente__cadastro__campos" type="text" name="cep" id="cep" pattern="\d{5}-\d{3}"  placeholder="CEP" required>
                
                <input class="cliente__cadastro__campos" type="text" name="cidade" id="cidade" placeholder="Cidade" required>
                
                <select class="cliente__cadastro__select" id="estado" name="estado" required>
                	<option value="" disabled selected>Selecione um estado</option>
					<option value="AL">Alagoas</option>
					<option value="AP">Amap�</option>
					<option value="AM">Amazonas</option>
					<option value="BA">Bahia</option>
					<option value="CE">Cear�</option>
					<option value="DF">Distrito Federal</option>
					<option value="ES">Espirito Santo</option>
					<option value="GO">Goi�s</option>
					<option value="MA">Maranh�o</option>
					<option value="MT">Mato Grosso</option>
					<option value="MS">Mato Grosso do Sul</option>
					<option value="MG">Minas Gerais</option>
					<option value="PA">Par�</option>
					<option value="PB">Para�ba</option>
					<option value="PR">Paran�</option>
					<option value="PE">Pernambuco</option>
					<option value="PI">Piau�</option>
					<option value="RJ">Rio de Janeiro</option>
					<option value="RN">Rio Grande no Norte</option>
					<option value="RS">Rio Grande do Sul</option>
					<option value="RO">Rond�nia</option>
					<option value="RR">Roraima</option>
					<option value="SC">Santa Catarina</option>
					<option value="SP">S�o Paulo</option>
					<option value="SE">Sergipe</option>
					<option value="TO">Tocantins</option>
                </select>
                
                <input class="cliente__cadastro__campos" type="text" name="pais" id="pais" placeholder="Pa�s" required>
                
                </div>
                </div>
			
                <div>
                	<input type="hidden" id="usu_id" name="usu_id" value="${usuarioLogado.id}">
                	<input type="hidden" name="acao" value="CadastrarEndereco">
                    <input class="cliente__cadastro__cadastrar" type="submit" value="Cadastrar">
                </div>
            </form>

           
    </main>
    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>

</html>