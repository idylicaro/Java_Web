package model;

import java.io.Serializable;
import java.util.List;

public class PlayList implements Serializable {
    private int id;
    private String titulo;
    private Usuario usuario;
    private List<Musica> musicas;

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public PlayList(String titulo,Usuario usuario) {
        this.titulo = titulo;
        this.usuario = usuario;
    }

    public PlayList() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
