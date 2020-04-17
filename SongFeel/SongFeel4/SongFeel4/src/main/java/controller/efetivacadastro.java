package controller;

import DAO.DataSource;
import DAO.UsuarioDAO;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/efetivacadastro")
public class efetivacadastro extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina ="/myaccount.jsp";

        String nome  = request.getParameter("txtNome");
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");

        Usuario usuario = new Usuario();

        if(nome.equals("") || email.equals("") || senha.equals("")){
            request.setAttribute("erroSTR","Prencha o formulario corretamente!");
            pagina = "/error.jsp";
        }else {
            usuario.setNome(nome);
            usuario.setEmail(email);
            usuario.setSenha(senha);

            DataSource dataSource = new DataSource();
            UsuarioDAO usuarioDAO = new UsuarioDAO(dataSource);
            usuarioDAO.create(usuario);
            System.out.println(usuario);
            try {
                dataSource.getConnection().close();
            } catch (SQLException ex) {
                System.out.println("Algum ao fechar a conexão: " + ex.getMessage());
                request.setAttribute("erroSTR", "Erro ao criar nova conta de usuario");
                pagina = "/error.jsp";
            }
        }
        if (usuario.getId() != 0){
            request.getSession().setAttribute("Usuario",usuario);
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request,response);
    }
}
