package DAO;

import model.Musica;
import model.PlayList;
import model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements GenericDAO{
    public void create(Object o){

    }
    public List<Object> read(Object o){
        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setEmail("idylicaro.se@hotmail.com");
        usuario.setNome("idylicaro");
        usuario.setSenha("1234");

        ArrayList<PlayList> playLists = new ArrayList<PlayList>();
        PlayList list1 = new PlayList();
        list1.setId(1);
        list1.setTitulo("Crassicos do rock");
        ArrayList<Musica> musicasP1 = new ArrayList<Musica>();

        Musica m1 = new Musica();
        m1.setId(1);
        m1.setArtista("Iron Maiden");
        m1.setTitulo("Wasted Years");
        m1.setEstilo(1);
        m1.setAlbum("Somewhere In Time");

        musicasP1.add(m1);
        list1.setMusicas(musicasP1);
        playLists.add(list1);
        usuario.setPlayLists(playLists);

        ArrayList<Object> resultado = new ArrayList<Object>();
        resultado.add(usuario);
        return resultado;

    }public void update(Object o){

    }public void delete(Object o){

    }
}
