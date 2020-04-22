package controller;

import DAO.DataSource;
import DAO.MusicaDAO;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/RecuperaMusicasServlet")
public class RecuperaMusicasServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = "/error.jsp";
        try {
            Usuario usuario = (Usuario) request.getSession().getAttribute("Usuario");
            if(usuario == null){
                request.setAttribute("erroSTR","Usuario não conectado!");
            }else {
                DataSource dataSource = new DataSource();
                MusicaDAO musicaDAO = new MusicaDAO(dataSource);
                List<Object> lista = musicaDAO.read(null);
                if(lista == null){
                    request.setAttribute("erroSTR","Erro ao recuperar musicas do banco de dados!");
                }else {
                    String idPlaylist = request.getParameter("idplaylist");
                    request.setAttribute("idPlaylist",idPlaylist);
                    request.setAttribute("ListaMusicas",lista);
                    pagina = "/musicas.jsp";
                }
                dataSource.getConnection().close();
            }
        }catch (Exception ex){
            System.out.println("Erro ao montar pagina de musicas: " +ex.getMessage());
            request.setAttribute("erroSTR","Erro ao montar pagina de musicas");
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request,response);
    }
}
