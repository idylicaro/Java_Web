<!DOCTYPE html>
<jsp:useBean id="erroSTR" type="java.lang.String" scope="request" />
<html lang="en">
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
            <div class="col-md-12">
                <img align="center" class="rounded mx auto d-block" src="Images\LOGOVERDE.jpg" width="50%">
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
                <h4 class="text-center text-primary" id="h4Error">
                    ERRO: ${erroSTR}
                </h4>
            </div>
        </div>

</div>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/scripts.js"></script>
</body>
</html>