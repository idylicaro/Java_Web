package controller;

import model.PlayList;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PlayerServlet")
public class PlayerServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = "/error.jsp";
        Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
        if(usuario != null){
            PlayList playList = (PlayList) request.getSession().getAttribute("Playlist");
            if (playList != null){
                pagina = "/player.jsp";
            }else {
                request.setAttribute("erroSTR","Erro! Playlist nao conectado!");
            }
        }else {
                request.setAttribute("erroSTR","Erro! Usuario nao conectado!");
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request,response);
    }
}
