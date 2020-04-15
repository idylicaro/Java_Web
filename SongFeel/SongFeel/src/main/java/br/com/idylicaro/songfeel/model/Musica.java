package br.com.idylicaro.songfeel.model;

import java.io.Serializable;

public class Musica implements Serializable {
    private int id;
    private String titulo;
    private String artista;
    private String album;
    private int estilo;
    private String linkMP3;

    public Musica(int id, String titulo, String artista, String album, int estilo, String linkMP3) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.estilo = estilo;
        this.linkMP3 = linkMP3;
    }

    public Musica() {
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

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getEstilo() {
        return estilo;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public String getLinkMP3() {
        return linkMP3;
    }

    public void setLinkMP3(String linkMP3) {
        this.linkMP3 = linkMP3;
    }
}
