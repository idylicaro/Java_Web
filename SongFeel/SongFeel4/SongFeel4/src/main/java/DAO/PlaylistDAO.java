package DAO;

import model.Musica;
import model.PlayList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO implements  GenericDAO {
    private  DataSource dataSource;
    public PlaylistDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Override
    public void create(Object o) {
        try{
            PlayList playList = (PlayList) o;
            String SQL = "INSERT INTO tblPlaylist VALUES(null, ?, ?)";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,playList.getTitulo());
            stm.setInt(2,playList.getUsuario().getId());
            int res = stm.executeUpdate();
            if(res == 0){
                throw new RuntimeException("Não foi possivel incluir playlist!");
            }
            ResultSet rs = stm.getGeneratedKeys();
            if(rs.next()){
                playList.setId(rs.getInt(1));
            }
        }catch (SQLException ex){
            System.out.println("Erro ao cadastrar playlist: "+ ex.getMessage());
        }
    }

    @Override
    public List<Object> read(Object o) {
        try{
            String SQL = "SELECT * FROM tblPlaylist WHERE idUsuario = ?";
            Integer idUser = (Integer) o;
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setInt(1,idUser);
            ResultSet rs = stm.executeQuery();
            ArrayList<Object> playLists= new ArrayList<Object>();
            PlayList auxPlaylist;
            while (rs.next()){
                auxPlaylist = new PlayList();
                auxPlaylist.setId(rs.getInt("idPlaylist"));
                auxPlaylist.setTitulo(rs.getString("titulo"));
                playLists.add(auxPlaylist);
            }
            rs.close();
            stm.close();
            return playLists;
        }catch (SQLException ex){
            System.out.println("Error ao recuperar playlist: "+ex.getMessage());
        }
        return null;
    }

    @Override
    public void update(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    public PlayList readPlaylistDetailsById(int id){
        try{
            String SQL = "SELECT tblPlaylist.idPlaylist AS idPlaylist, " +
                         "tblPlaylist.idUsuario AS idUsuario, " +
                         "tblPlaylist.titulo AS pl_titulo, " +
                         "tblMusica.idMusica AS idMusica, " +
                         "tblMusica.titulo AS titulo, " +
                         "tblMusica.artista AS artista, " +
                         "tblMusica.album AS album, " +
                         "tblMusica.estilo AS estilo, " +
                         "tblMusica.linkMP3 AS linkMP3 " +
                         "FROM tblPlaylist LEFT OUTER JOIN tblMusicaPlaylist USING (idPlaylist) " +
                         "LEFT OUTER JOIN tblMusica USING (idMusica) WHERE idPlaylist = ? ";
            PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            PlayList playList = null;

            do{
                if (playList == null && rs.next()) {
                    playList = new PlayList();
                    playList.setMusicas(new ArrayList<Musica>());
                    playList.setId(rs.getInt("idPlaylist"));
                    playList.setTitulo(rs.getString("pl_titulo"));
                }//ifplaylist
                    if(rs.getString("titulo") != null){
                        Musica musica = new Musica();
                        musica.setTitulo(rs.getString("titulo"));
                        musica.setId(rs.getInt("idMusica"));
                        musica.setArtista(rs.getString("artista"));
                        musica.setAlbum(rs.getString("album"));
                        musica.setLinkMP3(rs.getString("linkMP3"));
                        playList.getMusicas().add(musica);
                }
            }while ((rs.next()));
            rs.close();
            stm.close();
            return playList;
        }catch (SQLException ex){
            System.out.println("Error ao recuperar detalhes da playlist: "+ex.getMessage());
        }
        return null;
    }
}
