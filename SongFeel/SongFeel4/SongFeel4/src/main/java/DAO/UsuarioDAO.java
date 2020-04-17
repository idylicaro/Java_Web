package DAO;

import model.Musica;
import model.PlayList;
import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements GenericDAO{
    private DataSource dataSource;
    public UsuarioDAO(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public void create(Object o){
        try {
            if (o instanceof Usuario){
                Usuario usuario = (Usuario) o;
                String SQL = "INSERT INTO tblUsuario VALUES (null,?,?,?)";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
                stm.setString(1, usuario.getNome());
                stm.setString(2, usuario.getEmail());
                stm.setString(3, usuario.getSenha());

                //verifica quantas "rows" foram afetadas
                int res = stm.executeUpdate();
                if(res !=0){
                    ResultSet rs = stm.getGeneratedKeys();
                    if(rs.next()){
                        usuario.setId(rs.getInt(1));
                    }
                    rs.close();
                }
                stm.close();


            }else{
                throw new RuntimeException("Invalid User Model Object");
            }
        }catch (SQLException ex){
            System.out.println("Erro a inserir usuario "+ex.getMessage());
        }
    }
    public List<Object> read(Object o){
        try {
            if(o instanceof Usuario){
                Usuario incomplete = (Usuario) o;
                String SQL = "SELECT * FROM tblUsuario WHERE email = ? AND senha =?";
                PreparedStatement stm = dataSource.getConnection().prepareStatement(SQL);
                stm.setString(1,incomplete.getEmail());
                stm.setString(2,incomplete.getSenha());
                ResultSet rs = stm.executeQuery();

                ArrayList <Object> result = new ArrayList<Object>();
                if (rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setId(rs.getInt("idUsuario"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    result.add(usuario);
                    stm.close();
                    rs.close();

                    return result;
                }
            }else{
                throw new RuntimeException("Invalid Object");
            }
        }catch (SQLException ex){
            System.out.println("ERROR ao recuperar usuario:" + ex.getMessage());
        }
        return null;

    }public void update(Object o){

    }public void delete(Object o){

    }
}
