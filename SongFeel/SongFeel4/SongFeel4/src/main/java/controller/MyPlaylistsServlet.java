package controller;

import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MyPlaylistsServlet")
public class MyPlaylistsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String paginaRetorno;
        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
        if(usuario == null){
            paginaRetorno = "/index.html";
        }else{
            paginaRetorno = "/myplaylists.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaRetorno);
        dispatcher.forward(request,response);
    }
}
