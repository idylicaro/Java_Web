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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MyPlaylistsServlet")
public class MyPlaylistsServlet extends HttpServlet {
    // apenas para gerenciar view e url
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = "/myaccount.jsp";
        try{
            Usuario usuario = (Usuario)request.getSession().getAttribute("Usuario");
            if (usuario != null){ // ta logado ?
                if(usuario.getPlayLists() == null){ //nao tem playlist?
                    //recupera do banco
                    DataSource dataSource = new DataSource();
                    PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
                    List<Object> list = playlistDAO.read(usuario.getId());
                    dataSource.getConnection().close();
                    if(list != null){
                        ArrayList<PlayList> myplaylists = new ArrayList<PlayList>();
                        for (Object o : list){
                            PlayList auxPlaylist = (PlayList) o;
                            auxPlaylist.setUsuario(usuario);
                            myplaylists.add(auxPlaylist);
                        }
                        usuario.setPlayLists(myplaylists);
                        request.getSession().setAttribute("Usuario",usuario);
                        pagina = "/myplaylists.jsp";
                    }
                }
            }
        }catch (SQLException ex){
            System.out.println("Erro ao recuperar playlists: "+ ex.getMessage());
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request,response);
    }
}
