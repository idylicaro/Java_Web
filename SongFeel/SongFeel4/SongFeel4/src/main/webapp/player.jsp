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

    <script type="text/javascript">
        var musics = new Array(); //lista de musicas
        var repeat = false;       // modo repetir
        var totalDeMusicas =0;
        var url = "http://localhost:8080/SongFeel4/"
        function setupPlayer() {
            var divMusicas = document.getElementById("playerContent");
            var filhos = divMusicas.childNodes;
            for (i=0; i< filhos.length; i++){
                if(filhos[i].nodeName == "div"){
                    musics.push(filhos[i].title);
                    totalDeMusicas++;
                }
            }
            var player = document.getElementById("musicplayer");
            player.src = url+musics[0];
            player.play();
        }
        function play(objectMusica) {

        }
    </script>

</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-12" align="center">
            <a href="/myplaylists.jsp"><img class="rounded mx auto d-block" src="Images\LOGO.jpg" width="25%"></a>
        </div>
    </div>
    <div id="playerContent">
        <c:forEach var="music" items="${Playlist.musicas}">
            <div class="musica" title="${music.linkMP3}" onclick="play(this)">
                ${music.titulo} - ${music.artista}
            </div>
        </c:forEach>
    </div>
    <div>
        <audio controls id="musicplayer" src="" ></audio>
    </div>


<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>
