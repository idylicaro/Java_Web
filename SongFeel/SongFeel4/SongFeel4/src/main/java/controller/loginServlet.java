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
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = "/error.jsp";
        String email = request.getParameter("txtEmail");
        String senha = request.getParameter("txtSenha");
        Usuario incompleto = new Usuario();
        incompleto.setEmail(email);
        incompleto.setSenha(senha);


        try {
            DataSource ds = new DataSource();
            UsuarioDAO usuarioDAO = new UsuarioDAO(ds);
            List<Object> res = usuarioDAO.read(incompleto);

            if (res != null && res.size() > 0){
                pagina = "/myaccount.jsp";
                request.getSession().setAttribute("Usuario",res.get(0));
            }else{
                request.setAttribute("erroSTR","Email / Senha Invalidos!");
            }
            ds.getConnection().close();
        }catch (Exception ex){
            request.setAttribute("erroSTR","Erro ao recuperar!");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina) ;
        dispatcher.forward(request,response);
    }

}
