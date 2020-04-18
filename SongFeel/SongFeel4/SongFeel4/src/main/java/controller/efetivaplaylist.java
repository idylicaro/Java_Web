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
import java.util.ArrayList;

@WebServlet("/efetivaplaylist")
public class efetivaplaylist extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = "/index.jsp";
        try {
            Usuario user = (Usuario) request.getSession().getAttribute("Usuario");
            if (user != null) {
                String tituloPlaylist = request.getParameter("txtNome");

                PlayList playList = new PlayList(tituloPlaylist, user);

                DataSource dataSource = new DataSource();

                PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
                playlistDAO.create(playList);
                dataSource.getConnection().close();
                if(user.getPlayLists() == null){
                    user.setPlayLists(new ArrayList<PlayList>());
                }
                user.getPlayLists().add(playList);
                request.getSession().setAttribute("Usuario",user);
                pagina = "/myplaylists.jsp";
            }
        }catch (Exception e){
            System.out.println("Erro ao cadastrar playlist!");
            request.setAttribute("erroSTR","Erro ao criar playlist!");
            pagina = "/error.jsp";
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request,response);
    }

}
