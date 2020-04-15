package br.com.idylicaro.songfeel.model;

import java.io.Serializable;
import java.util.List;

public class PlayList implements Serializable {
    private int id;
    private String titulo;
    private List<Musica> musicas;

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public PlayList(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public PlayList() {
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
