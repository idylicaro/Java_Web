<!DOCTYPE html>
<jsp:useBean id="Usuario" type="model.Usuario" scope="session"/>
<%@ page isELIgnored= "false" %>
<html lang="pt-br">
    <head>
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
                    Bem Vindo, ${Usuario.nome}!
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
                            <a class="nav-link active" href="#">Nova Playlist</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="./MyPlaylistsServlet">Minhas Playlists</a>
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

        </div>
    </div>

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
