package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/NovaMusicaServlet")
public class NovaMusicaServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String pagina = "/error.jsp";
            if(request.getSession().getAttribute("Usuario") != null){
                pagina = "/novamusica.jsp";
            }else {
                request.setAttribute("erroSTR","Usuario não conectado!");
            }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
            dispatcher.forward(request,response);
    }
}
