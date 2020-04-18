package DAO;

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
}
