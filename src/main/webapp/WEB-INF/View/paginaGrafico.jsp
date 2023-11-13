<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<c:url value="/controller" var="linkController"/>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gráfico</title>
    <link rel="stylesheet" href="<c:url value="/style/styleTemplate.css"/>">
    <link rel="stylesheet" href="<c:url value="/style/stylePaginaGrafico.css"/>">
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

     <a class="link__voltar" href="/iBook/controller?acao=Perfil&id=108">   
        <img class="icone__voltar" src="./assets/botaoVoltar.png"> Voltar 
    </a>
       
     <main class="grafico">

	<div class="pagina__grafico__formulario">
		<div class="pagina__grafico__titulos">
        <h2>Gráfico de Vendas</h2>
        <hr>
      </div>
			<form action="${linkController}">
      
      
         <div class="">
		    <label for="dtInicio" class="calendario_label">Data Inicio</label>
		    <div class="">
		      <input type="date" class="pagina__grafico__inputs" id="dtInicio" name="dtInicio" >
		    </div>
		  </div>
      
      
      
        <div class="">
		    <label for="dtFim" class="calendario_label">Data Fim</label>
		    <div class="">
		      <input type="date" class="pagina__grafico__inputs" id="dtFim" name="dtFim" >
		    </div>
		  </div>
      
      
      <div class="">
     		<button type="submit" class="gerar__grafico" id="acao" name="acao" value="GerarGrafico">
     			Gerar Grafico
     		</button>
      		
      </div>
      </form>
		</div>
		
		<div class="grafico__grafico">
		<div>
		
			<canvas id="myChart"></canvas>
		
		</div>
		</div>
			
			<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

				<script>
				  const ctx = document.getElementById('myChart');
				  
				  new Chart(ctx, {
					  type: 'line',
				    data: {
				    	
				    	  labels: ${txtLabels},
				          datasets: ${dataSet}
				    },
				    options: {
				      scales: {
				        y: {
				          beginAtZero: true
				        }
				      }
				    }
				  });
				  
				</script>
  </main>

    <footer class="rodape">
        <p>Desenvolvido por Vittor Onishi</p>
    </footer>
</body>

</html>