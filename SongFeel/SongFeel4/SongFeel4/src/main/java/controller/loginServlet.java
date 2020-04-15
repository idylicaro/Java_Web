package controller;

import DAO.UsuarioDAO;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina;
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");

        List<Object> res;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        res = usuarioDAO.read(null);

        if (res.size() > 0){
            request.getSession().setAttribute("Usuario",res.get(0));
            pagina = "/myaccount.jsp";
        }else{
            request.setAttribute("erroSTR","Email / Senha não encontrados!");
            pagina = "/error.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina) ;
        dispatcher.forward(request,response);
    }

}
