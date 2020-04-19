<!DOCTYPE html>
<jsp:useBean id="Usuario" type="model.Usuario" scope="session"/>
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
        <div class="row">
            <div class="col-md-12">
                <h4 class="text-center">
                    Crie sua playlist ${Usuario.nome} !
                </h4>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <form role="form" action="UploadMusicaServlet" method="POST">
                <div class="form-group">
                    <label for="artista">
                        Artista
                    </label>
                    <input type="text" class="form-control" id="artista" name="txtArtista">
                </div>
                <div class="form-group">
                    <label for="album">
                        Album
                    </label>
                    <input type="text" class="form-control" id="album" name="txtAlbum">
                </div>
                <div class="form-group">
                    <label for="nomemusica">
                        Nome da musica
                    </label>
                    <input type="text" class="form-control" id="nomemusica" name="txtNomeMusica">
                </div>
                <div class="form-group">
                    <label for="estilo">
                        Estilo
                    </label>
                    <select id="estilo" name="txtEstilo">
                        <option value="1">Heavy Metal</option>
                        <option value="2">City Pop</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputFile">Selecionar Arquivo MP3</label>
                    <input type="file" class="form-control-file" id="inputFile" name="fileMP3">
                </div>
                <button type="submit" class="btn btn-primary">
                    Adicionar Musica
                </button>

            </form>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>