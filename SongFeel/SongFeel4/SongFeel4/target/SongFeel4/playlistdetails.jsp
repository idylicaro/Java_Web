<!DOCTYPE html>
<jsp:useBean id="Usuario" type="model.Usuario" scope="session"/>
<jsp:useBean id="Playlist" type="model.PlayList" scope="session"/>
<%@ page isELIgnored= "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>SongFeel</title>

    <meta name="description" content="SongFeel - seu player de musica favorito!">
    <meta name="author" content="Idylicaro">

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" align="center">
            <img class="rounded mx auto d-block" src="Images\LOGO.jpg" width="25%">
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <h3 class="text-center text-primary">
                SongFeel - Sua playlist na Web!
            </h3>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center text-primary">
                - Minhas Playlists -
            </h4>
        </div>
    </div>
    <div class="row" id="navbar">
        <div class="col-md-2">
            &nbsp;
        </div>
        <div class="col-md-8">
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link active" href="./NovaPlaylist">Nova Playlist</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/myplaylists.jsp">Minhas Playlists</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Upload Musica</a>
                </li>
            </ul>
        </div>
        <div class="col-md-2">
            &nbsp;
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">&nbsp</div>
            <div class="col-md-8">
                <h4>
                    ${Playlist.titulo} <img class="img-fluid" src="Images/play.jpg" alt="Toca Playlist" title="Toca Playlist" width="32" height="32">
                </h4>
            </div>
        <div class="col-md-2">&nbsp</div>
    </div>
    <div class="row">
        <div class="col-md-2">&nbsp</div>
            <div class="col-md-8">
                <a href="./RecuperaMusicasServlet?idplaylist=${Playlist.id}"><h5>+ Adicionar Músicas </h5> </a>
            </div>
        <div class="col-md-2">&nbsp</div>
    </div>
        <c:forEach var="musica" items="${Playlist.musicas}">
            <div class="row">
                <div class="col-md-2">&nbsp</div>
                <div class="col-md-8">
                    <span class="tituloMusica">${musica.titulo}${musica.artista}</span>
                    <span class="artista">${musica.artista} (Album: ${musica.album})</span>
                </div>
                <div class="col-md-2">&nbsp</div>
            </div>
        </c:forEach>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>
