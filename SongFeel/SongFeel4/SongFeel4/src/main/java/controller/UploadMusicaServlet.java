package controller;

import DAO.DataSource;
import DAO.MusicaDAO;
import model.Musica;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/UploadMusicaServlet")
@MultipartConfig
//@MultipartConfig(fileSizeThreshold=1024*1024, maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class UploadMusicaServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pagina = "/error.jsp";
        if(request.getSession().getAttribute("Usuario") != null){
            try {
                String artista = request.getParameter("txtArtista");
                String album = request.getParameter("txtAlbum");
                String titulo = request.getParameter("txtNomeMusica");
                int estilo = Integer.parseInt(request.getParameter("txtEstilo"));

                InputStream arqOriginal = request.getPart("fileMP3").getInputStream();
                String nomeArquivoOriginal = request.getPart("fileMP3").getSubmittedFileName();
                String nomeArquivo = getServletContext().getRealPath("\\") +"\\musicas\\" +request.getPart("fileMP3").getSubmittedFileName();
                FileOutputStream arquivoMP3 = new FileOutputStream(nomeArquivo);
                // Le blocos de 1024 bytes e escreve no arquivoMP3
                byte b[] = new byte[1024];
                while (arqOriginal.available() > 0){
                    arqOriginal.read(b);
                    arquivoMP3.write(b);
                }
                arqOriginal.close();
                arquivoMP3.close();

                Musica musica = new Musica();
                musica.setAlbum(album);
                musica.setArtista(artista);
                musica.setEstilo(estilo);
                musica.setTitulo(titulo);
                musica.setLinkMP3("musicas\\"+nomeArquivoOriginal);

                DataSource dataSource = new DataSource();
                MusicaDAO musicaDAO = new MusicaDAO(dataSource);
                musicaDAO.create(musica);
                dataSource.getConnection().close();

                pagina = "/myaccount.jsp";

            }catch (Exception ex){
                request.setAttribute("erroSTR","Upload Falhou!");
                ex.printStackTrace();
            }
        }else {
            request.setAttribute("erroSTR","Usuario não conectado!");
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
        dispatcher.forward(request,response);
    }

}
