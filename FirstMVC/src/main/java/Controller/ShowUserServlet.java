package Controller;


import Model.Usuario;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pUser = request.getParameter("user");
        String pSenha = request.getParameter("senha");
        String pModo  = request.getParameter("modo");

        String pagina="/erro.jsp";

        if (pUser.equals("idylicaro") && pSenha.equals("1234")) {
            Usuario u = new Usuario();
            u.setId(1010);
            u.setUsername("idylicaro");
            u.setFullName("Idyl Icaro dos Santos");
            u.setEmail("idylicaro.se@hotmail.com");
            if (pModo.equals("html")){
                request.setAttribute("Usuario",u);
                pagina = "/okay.jsp";
            }else{
                String resultado =  new Gson().toJson(u);
                request.setAttribute("UsuarioJSON", resultado);
                pagina = "/result.jsp";
            }

        }
        //para manter a url
        RequestDispatcher dispatcher;
        dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request,response);
    }

}

