package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.lookup.SourceTypeBinding;

import dao.UsuarioDao;
import model.Usuario;

@WebServlet("/ServletUsuarioController")
public class ServletUsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletUsuarioController() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//sessao
        HttpSession sessao = request.getSession(true);
        
        //variavel que pega ACAO dos botoes
        String opcao = request.getParameter("opcao");

        //IF LOGAR USUARIO
        if (opcao.equals("logar")) {
            String nome = request.getParameter("nome");
            String senha = request.getParameter("senha");
            try {
                Usuario usuario = new UsuarioDao().login(nome, senha);
                if (usuario != null) {
                    sessao.setAttribute("logado", usuario);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/principal/principal.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
        //CADASTRAR USUARIO
        else if (opcao.equals("cadastrarUsuario")) {
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String senha = request.getParameter("senha");
            int rg = Integer.parseInt(request.getParameter("rg"));
            //CRIA USUARIO SETA ATRIBUTOS
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setRg(rg);
            usuario.setSenha(senha);
            usuario.setSobrenome(sobrenome);
            try {
                boolean retorno = new UsuarioDao().inserirUsuario(usuario);
                if (retorno) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/principal/principal.jsp");
                    requestDispatcher.forward(request, response);
                    out.println("<script>alert ('Usuario cadastrado com Sucesso');</script>");
                    out.println("<script>window.location='jsp/principal/principal.jsp'</script>");
                } else {
                    out.println("<script>alert ('Não foi Possivel cadastrar Usuario, tente novamente');</script>");
                    out.println("<script>window.location='jsp/principal/principal.jsp'</script>");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
        //IF DO ALTERAR USUARIO 
        else if (opcao.equals("alterarUsuario")) {
            String nome = request.getParameter("nome");
            String sobrenome = request.getParameter("sobrenome");
            String senha = request.getParameter("senha");
            int rg = Integer.parseInt(request.getParameter("rg"));

            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setRg(rg);
            usuario.setSenha(senha);
            usuario.setSobrenome(sobrenome);
            try {
                boolean retorno = new UsuarioDao().alteraUsuario(usuario);
                if (retorno) {
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/principal/principal.jsp");
                    requestDispatcher.forward(request, response);
                    out.println("<script>alert ('Usuario Alterado com Sucesso');</script>");
                    out.println("<script>window.location='jsp/principal/principal.jsp'</script>");
                } else {
                    out.println("<script>alert ('Não foi Possivel Alterar Usuario, tente novamente');</script>");
                    out.println("<script>window.location='jsp/principal/principal.jsp'</script>");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } 
        //IF DO PESQUISA USUARIO
        else if (opcao.equals("pesquisaUsuario")) {
          int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
          try {
              Usuario u = new UsuarioDao().PesquisaUsuario(idUsuario);
              if (u != null) {  //MANDA PRA JSP O USUARIO
                  request.setAttribute("usuario", u);
                  RequestDispatcher rd = request.getRequestDispatcher("jsp/usuario/alteraUsuario.jsp");
                  rd.forward(request, response);
              } else {
                  RequestDispatcher rd = request.getRequestDispatcher("jsp/principal/principal.jsp");
                  rd.forward(request, response);
              }
          } catch (Exception ex) {
              ex.printStackTrace();
              
          }
          
      } 
        //IF DO DELETA USUARIO
        else if (opcao.equals("deletaUsuario")) {
          int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
          try {
              boolean retorno = new UsuarioDao().deletarUsuario(idUsuario);
              if (retorno) {
                  RequestDispatcher rd = request.getRequestDispatcher("jsp/principal/principal.jsp");
                  rd.forward(request, response);
              } else {
                  RequestDispatcher rd = request.getRequestDispatcher("jsp/principal/principal.jsp");
                  rd.forward(request, response);
              }
          } catch (Exception ex) {
              ex.printStackTrace();
          }
      }
      //IF DO LOGOUT
      else if (opcao.equals("logout")) {
    	  sessao.invalidate();
  		  response.sendRedirect("login.jsp");
      }
      
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	//INICIO METODO-POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}//FIM METODO-POST

}
