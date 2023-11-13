package br.com.iBook.controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.iBook.command.CommandAdicionarAoCarrinho;
import br.com.iBook.command.CommandAlterar;
import br.com.iBook.command.CommandAlterarCarrinho;
import br.com.iBook.command.CommandAlterarStatus;
import br.com.iBook.command.CommandConsultar;
import br.com.iBook.command.CommandConsultarItemDoCarrinho;
import br.com.iBook.command.CommandConsultarPorId;
import br.com.iBook.command.CommandExcluir;
import br.com.iBook.command.CommandFormCadastroUsuario;
import br.com.iBook.command.CommandLogin;
import br.com.iBook.command.CommandMontaGrafico;
import br.com.iBook.command.CommandPaginaConsultaUsuario;
import br.com.iBook.command.CommandRemoverDoCarrinho;
import br.com.iBook.command.CommandSalvar;
import br.com.iBook.command.CommandSalvarCartao;
import br.com.iBook.command.CommandSalvarCompra;
import br.com.iBook.command.CommandSalvarEndereco;
import br.com.iBook.command.ICommand;
import br.com.iBook.dominio.EntidadeDominio;
import br.com.iBook.viewhelper.IViewHelper;
import br.com.iBook.viewhelper.VhAlterarUsuario;
import br.com.iBook.viewhelper.VhCadastrarUsuarios;
import br.com.iBook.viewhelper.VhCartaoDeCredito;
import br.com.iBook.viewhelper.VhConsultarPorId;
import br.com.iBook.viewhelper.VhConsultarUsuarios;
import br.com.iBook.viewhelper.VhCupom;
import br.com.iBook.viewhelper.VhEndereco;
import br.com.iBook.viewhelper.VhExcluir;
import br.com.iBook.viewhelper.VhFormCadastroUsuarios;
import br.com.iBook.viewhelper.VhGrafico;
import br.com.iBook.viewhelper.VhItem;
import br.com.iBook.viewhelper.VhLogin;
import br.com.iBook.viewhelper.VhPaginaConsultaClientes;
import br.com.iBook.viewhelper.VhPaginaInicial;
import br.com.iBook.viewhelper.VhPedido;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static Map<String, ICommand> commands;
    private static Map<String, IViewHelper> viewHelpers;
    private static Map<String, String> pages;
	
    public Controller() {
    	
    	commands = new HashMap<>();
        viewHelpers = new HashMap<>();
        pages = new HashMap<>();
        
        pages.put("PaginaInicial", "forward:paginaInicial.jsp");
        pages.put("ExibeDadosProduto", "forward:paginaProduto.jsp");
        
        pages.put("Adicionar ao carrinho", "forward:paginaProduto.jsp");
        pages.put("RemoverDoCarrinho", "forward:paginaCarrinho.jsp");
        pages.put("AlterarCarrinho", "forward:paginaCarrinho.jsp");
        pages.put("Carrinho", "forward:paginaCarrinho.jsp");
        pages.put("AlterarCarrinho", "forward:paginaCarrinho.jsp");
        pages.put("VisualizarItemDoCarrinho", "forward:paginaItemCarrinho.jsp");
        
        pages.put("Comprar", "forward:paginaCarrinho.jsp");
        
        pages.put("Continuar", "forward:paginaSelecaoEndereco.jsp");
        pages.put("Confirmar endereco", "forward:paginaFormaPagamento.jsp");
        pages.put("Confirmar pagamento", "forward:paginaPedido.jsp");
        pages.put("PaginaConsultaVendas", "forward:paginaPedido.jsp");
        pages.put("VerItensPedido", "forward:paginaItensPedido.jsp");
        pages.put("ConsultarPedido", "forward:paginaPedido.jsp");
        pages.put("VerItem", "forward:paginaStatusProduto.jsp");
        pages.put("AlterarStatus", "forward:paginaStatusProduto.jsp");
        pages.put("AlterarStatusPedido", "forward:paginaPedido.jsp");
        pages.put("SolicitarTrocaPedido", "forward:paginaPedido.jsp");
        pages.put("SolicitarTrocaItem", "forward:paginaItensPedido.jsp");
        pages.put("ConsultarCupons", "forward:paginaCupons.jsp");
        pages.put("AdicionarCupom", "forward:paginaFormaPagamento.jsp");
        
        pages.put("formLogin", "forward:paginaLogin.jsp");
        pages.put("Login", "forward:paginaPerfil.jsp");
        pages.put("LogOut", "forward:paginaInicial.jsp");
        
        pages.put("Perfil", "forward:paginaPerfil.jsp");
        
        pages.put("formCadastroUsuario", "forward:formCadastroUsuario.jsp");
        pages.put("CadastrarUsuario", "forward:paginaPerfil.jsp");
        
        pages.put("AdicionarCartao", "forward:formCadastroCartao.jsp");
        pages.put("CadastrarCartao", "forward:paginaFormaPagamento.jsp");
        
        pages.put("AdicionarEndereco", "forward:formCadastroEndereco.jsp");
        pages.put("CadastrarEndereco", "forward:paginaSelecaoEndereco.jsp");
        
        pages.put("PaginaConsultaUsuarios", "forward:paginaConsultaUsuario.jsp");
        pages.put("ConsultarUsuarios", "forward:paginaConsultaUsuario.jsp");
        
        pages.put("ExibeDadosUsuario", "forward:paginaDadosUsuario.jsp");
        pages.put("ExibeEndereco", "forward:formAlteraEndereco.jsp");
        pages.put("ExibeCartao", "forward:formAlteraCartao.jsp");
        pages.put("ExibeUsuario", "forward:formAlteraUsuario.jsp");
        
        pages.put("AlterarUsuario", "forward:paginaConsultaUsuario.jsp");
        pages.put("AlterarEndereco", "forward:paginaConsultaUsuario.jsp");
        pages.put("AlterarCartao", "forward:paginaConsultaUsuario.jsp");

        pages.put("ExcluirUsuario", "forward:paginaConsultaUsuario.jsp");
        pages.put("ExcluirCartao", "forward:paginaConsultaUsuario.jsp");
        pages.put("ExcluirEndereco", "forward:paginaConsultaUsuario.jsp");
        
        pages.put("AnaliseVendas", "forward:paginaGrafico.jsp");
        pages.put("GerarGrafico", "forward:paginaGrafico.jsp");
        
        

        // Mapear os comandos e view helpers correspondentes

        commands.put("PaginaInicial", new CommandConsultar());
        
        commands.put("LogOut", new CommandConsultar());
        
        commands.put("Login", new CommandLogin());
        commands.put("formLogin", new CommandLogin());
        
        commands.put("Perfil", new CommandConsultarPorId());
        
        commands.put("formCadastroUsuario", new CommandFormCadastroUsuario());
        commands.put("CadastrarUsuario", new CommandSalvar());
        
        commands.put("CadastrarEndereco", new CommandSalvarEndereco());
        
        commands.put("AdicionarCartao", new CommandFormCadastroUsuario());
        commands.put("CadastrarCartao", new CommandSalvarCartao());
        
        commands.put("CadastrarEndereco", new CommandSalvarEndereco());
        
        commands.put("PaginaConsultaUsuarios", new CommandPaginaConsultaUsuario());
        commands.put("ConsultarUsuarios", new CommandConsultar());
        commands.put("VerItensPedido", new CommandConsultarPorId());
        commands.put("VerItem", new CommandConsultarPorId());
        commands.put("AlterarStatus", new CommandAlterarStatus());
        commands.put("SolicitarTrocaItem", new CommandAlterarStatus());
        commands.put("SolicitarTrocaPedido", new CommandAlterarStatus());
        commands.put("AlterarStatusPedido", new CommandAlterarStatus());
        commands.put("ConsultarCupons", new CommandConsultar());
        commands.put("AdicionarCupom", new CommandExcluir());
        
        commands.put("ExibeDadosUsuario", new CommandConsultarPorId());
        commands.put("ExibeEndereco", new CommandConsultarPorId());
        commands.put("ExibeCartao", new CommandConsultarPorId());
        commands.put("ExibeUsuario", new CommandConsultarPorId());
        commands.put("ExibeDadosProduto", new CommandConsultarPorId());
        
        commands.put("Comprar", new CommandAdicionarAoCarrinho());
        commands.put("Adicionar ao carrinho", new CommandAdicionarAoCarrinho());
        commands.put("VisualizarItemDoCarrinho", new CommandConsultarItemDoCarrinho());
        commands.put("AlterarCarrinho", new CommandAlterarCarrinho());
        commands.put("RemoverDoCarrinho", new CommandRemoverDoCarrinho());
        
        commands.put("Continuar", new CommandConsultarPorId());
        
//      commands.put("Confirmar endereco", new CommandFormCadastroUsuario());
        commands.put("Confirmar pagamento", new CommandSalvarCompra());
        commands.put("PaginaConsultaVendas", new CommandConsultar());

        commands.put("ConsultarPedido", new CommandConsultar());
        
        commands.put("AlterarUsuario", new CommandAlterar());
        commands.put("AlterarEndereco", new CommandAlterar());
        commands.put("AlterarCartao", new CommandAlterar());
        
        commands.put("ExcluirUsuario", new CommandExcluir());
        commands.put("ExcluirCartao", new CommandExcluir());
        commands.put("ExcluirEndereco", new CommandExcluir());
        
        commands.put("AnaliseVendas", new CommandMontaGrafico());
        commands.put("GerarGrafico", new CommandMontaGrafico());
        
        
          
        viewHelpers.put("PaginaInicial", new VhPaginaInicial());
        
        viewHelpers.put("Login", new VhLogin());
        viewHelpers.put("formLogin", new VhLogin());
        viewHelpers.put("LogOut", new VhLogin());
        
        viewHelpers.put("Perfil", new VhConsultarPorId());
        
        viewHelpers.put("formCadastroUsuario", new VhFormCadastroUsuarios());
        viewHelpers.put("CadastrarUsuario", new VhCadastrarUsuarios());

        viewHelpers.put("AdicionarEndereco", new VhEndereco());
        viewHelpers.put("CadastrarEndereco", new VhEndereco());
        viewHelpers.put("AdicionarCartao", new VhCartaoDeCredito());
        viewHelpers.put("CadastrarCartao", new VhCartaoDeCredito());
        
        viewHelpers.put("PaginaConsultaUsuarios", new VhPaginaConsultaClientes());
        viewHelpers.put("ConsultarUsuarios", new VhConsultarUsuarios());
        
        viewHelpers.put("ExibeDadosUsuario", new VhConsultarPorId());
        viewHelpers.put("ExibeEndereco", new VhConsultarPorId());
        viewHelpers.put("ExibeCartao", new VhConsultarPorId());
        viewHelpers.put("ExibeUsuario", new VhConsultarPorId());
        viewHelpers.put("ExibeDadosProduto", new VhConsultarPorId());
        viewHelpers.put("PaginaConsultaVendas", new VhPedido());
        viewHelpers.put("ConsultarPedido", new VhPedido());
        viewHelpers.put("VerItensPedido", new VhConsultarPorId());
        viewHelpers.put("VerItem", new VhItem());
        viewHelpers.put("SolicitarTrocaItem", new VhItem());
        
        viewHelpers.put("Comprar", new VhItem());
        viewHelpers.put("Adicionar ao carrinho", new VhItem());
        viewHelpers.put("Carrinho", new VhItem());
        viewHelpers.put("Continuar", new VhPedido());
        viewHelpers.put("Confirmar endereco", new VhPedido());
        viewHelpers.put("Confirmar pagamento", new VhPedido());
        viewHelpers.put("SolicitarTrocaPedido", new VhPedido());
        viewHelpers.put("AlterarStatusPedido", new VhPedido());
        
        viewHelpers.put("AlterarUsuario", new VhAlterarUsuario());
        viewHelpers.put("AlterarCartao", new VhCartaoDeCredito());
        viewHelpers.put("AlterarEndereco", new VhEndereco());
        viewHelpers.put("AlterarStatus", new VhItem());
        viewHelpers.put("ConsultarCupons", new VhCupom());
        viewHelpers.put("AdicionarCupom", new VhCupom());
        
        viewHelpers.put("ExcluirUsuario", new VhExcluir());
        viewHelpers.put("ExcluirCartao", new VhExcluir());
        viewHelpers.put("ExcluirEndereco", new VhExcluir());
        viewHelpers.put("RemoverDoCarrinho", new VhItem());
        viewHelpers.put("AlterarCarrinho", new VhItem());
        viewHelpers.put("VisualizarItemDoCarrinho", new VhItem());
        
        viewHelpers.put("AnaliseVendas", new VhGrafico());
        viewHelpers.put("GerarGrafico", new VhGrafico());
   
    }

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paramAcao = request.getParameter("acao");
        
        System.out.println(paramAcao);

        ICommand command = commands.get(paramAcao);
        IViewHelper viewHelper = viewHelpers.get(paramAcao);

        if (command != null || viewHelper != null) {
            EntidadeDominio entidade = viewHelper.getEntidade(request, response);
            
            Resultado rstd = new Resultado();
            
            if(command != null) {
            		
            	rstd = command.execute(entidade);
            
            }
            
            viewHelper.setView(rstd.getEntidades(), request, response);
            viewHelper.setView(rstd.getEntidade(), request, response);
            	
            VhLogin vhlogin = new VhLogin();
            	
            vhlogin.setView(rstd.getEntidade(), request, response);
            	  
            
            if(rstd.getMsg() != null) {
            	
            	PrintWriter out = response.getWriter();
        		out.print(rstd.getMsg());
            	
            }
            
            String nextPage = pages.get(paramAcao);

            if (nextPage.startsWith("forward:") && rstd.getMsg() == null) {
                String forwardPage = nextPage.substring("forward:".length());
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/View/" + forwardPage);
                dispatcher.forward(request, response);
                
            } else if (nextPage.startsWith("redirect:")) {
                String redirectPage = nextPage.substring("redirect:".length());
                response.sendRedirect(redirectPage);
            } 
    }
}

}
