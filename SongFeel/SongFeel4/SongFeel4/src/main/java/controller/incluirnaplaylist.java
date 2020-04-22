package controller;

import DAO.DataSource;
import DAO.PlaylistDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/incluirnaplaylist")
public class incluirnaplaylist extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        String pagina = "/result.jsp";
        DataSource dataSource = null;
        try {
            System.out.println(request.getParameter("idplaylist"));
            int idPlaylist = Integer.parseInt(request.getParameter("idplaylist"));
            int idMusica = Integer.parseInt(request.getParameter("idmusica"));
             dataSource = new DataSource();
            PlaylistDAO playlistDAO = new PlaylistDAO(dataSource);
            if (playlistDAO.includeMusicaPlaylist(idPlaylist,idMusica)){

            }else {
                request.setAttribute("strRESULT","ERRO");
            }
            dataSource.getConnection().close();
            request.setAttribute("strRESULT","OK");
        }catch (Exception ex){
            if(dataSource != null){
                try {
                    dataSource.getConnection().close();
                }catch (Exception e){
                    System.out.println("erro ao finalizar conexao: "+ e.getMessage());
                }
            }
            System.out.println("Erro ao inserir: "+ ex.getMessage());
            ex.printStackTrace();
            request.setAttribute("strRESULT", "Erro ao inserir musica na playlist!");
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request,response);
    }
}
/*catch (RuntimeException ex) {
            request.setAttribute("strRESULT","Musica duplicada na playlist!");
        }*/
