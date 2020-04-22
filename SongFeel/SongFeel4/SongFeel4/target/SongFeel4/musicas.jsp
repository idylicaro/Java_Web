<!DOCTYPE html>
<jsp:useBean id="Usuario" type="model.Usuario" scope="session"/>
<jsp:useBean id="ListaMusicas" type="java.util.List" scope="request"/>
<jsp:useBean id="idPlaylist" type="java.lang.String" scope="request"/>
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

    <script>function adicionar(varidPlaylist, varidMusica) {
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET","http://localhost:8080/SongFeel4/incluirnaplaylist?idplaylist="+varidPlaylist+"&idmusica="+varidMusica);
        xmlhttp.onreadystatechange = function () {
            if(xmlhttp.status === 200 && xmlhttp.readyState === 4){
                alert(xmlhttp.responseText);
            }
        };
        xmlhttp.send();
    }
    </script>

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
                - Todas Musicas -
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
                    <a class="nav-link" href="./NovaMusicaServlet">Upload Musica</a>
                </li>
            </ul>
        </div>
        <div class="col-md-2">
            &nbsp;
        </div>
    </div>
    <!--tags interativas com jstl-->
    <c:forEach var="musica" items="${ListaMusicas}">
        <div class="row">
            <div class="col-md-2">&nbsp;</div>
            <div class="col-md-1">
                <button class="btn" onclick="adicionar(${idPlaylist},${musica.id})">+</button>
                <!--<a href="./incluirnaplaylist?idmusica=${musica.id}&idplaylist=${idPlaylist}"><h4> + </h4> </a> -->
            </div>
            <div class="col-md-7">
                ${musica.titulo} - (${musica.artista})&nbsp;
                <span class="artista"> Album ${musica.album} <br/> </span>
                <span class="artista">Estilo:
                    <c:if test="${musica.estilo == 1}"> HEAVY METAL</c:if>
                    <c:if test="${musica.estilo == 2}"> CITY POP</c:if>
                    <c:if test="${musica.estilo == 4}"> GAMES</c:if>
                </span>
            </div>
        </div>
    </c:forEach>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>

