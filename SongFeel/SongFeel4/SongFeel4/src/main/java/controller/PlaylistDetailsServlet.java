package controller;

import DAO.DataSource;
import DAO.PlaylistDAO;
import model.PlayList;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PlaylistDetailsServlet")
public class PlaylistDetailsServlet extends HttpServlet {
    // apenas para gerenciar view e url
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario user = (Usuario) request.getSession().getAttribute("Usuario");
        String pagina = "/error.jsp";
        if (user != null) {
            try {
                DataSource dataSource = new DataSource();
                PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
                int id = Integer.parseInt(request.getParameter("id"));
                PlayList playList = playlistDAO.readPlaylistDetailsById(id);
                if (playList != null) {
                    request.getSession().setAttribute("Playlist",playList);
                    pagina = "/playlistdetails.jsp";
                } else {
                    request.setAttribute("erroSTR", "Erro ao recuperar Playlist!");
                }
            } catch (Exception ex) {
                request.setAttribute("erroSTR", "Erro inesperado! :" + ex.getMessage());
            }

        }else {
            request.setAttribute("erroSTR", "Usuario não está conectado!)");
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request, response);
    }
}