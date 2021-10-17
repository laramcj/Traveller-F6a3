package br.com.masters3.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.masters3.beans.Usuario;
import br.com.masters3.dao.DataSource;
import br.com.masters3.dao.UsuarioDAO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			String pagina = "";			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Usuario usuario = this.recuperarUsuario(email,senha);
			if(usuario == null) {
				request.setAttribute("ErroMSG", "Usuário ou senha inválidos !!!");
				pagina = "/erro.jsp";
			}
			else {
				request.getSession().setAttribute("Usuario", usuario);
				pagina = "/dados_usuario.jsp";
			}
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		}
		catch (Exception ex) {
			System.out.println("ERRO on LOGINSERVLET "+ ex.getMessage());
		}
	}
	
	public Usuario recuperarUsuario(String email, String senha) {
		
		DataSource ds = new DataSource();
		
		UsuarioDAO usuarioDao = new UsuarioDAO(ds);
		
		Usuario usuarioFiltro = new Usuario();
		usuarioFiltro.setEmail(email);
		usuarioFiltro.setSenha(senha);
		
		return usuarioDao.read(usuarioFiltro);
		
	}
	
}
