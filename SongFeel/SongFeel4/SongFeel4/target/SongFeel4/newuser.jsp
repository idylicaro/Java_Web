<!DOCTYPE html>
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
                    Faça Parte!
                </h4>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <h3 class="text-center">
                Entrar!
            </h3>
            <form role="form" action="efetivacadastro" method="POST">
                <div class="form-group">
                    <label for="exampleNome">
                        Seu Nome:
                    </label>
                    <input type="text" class="form-control" id="exampleNome" name="txtNome">
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">
                        Seu Email:
                    </label>
                    <input type="email" class="form-control" id="exampleInputEmail1" name="txtEmail">
                </div>
                <div class="form-group">

                    <label for="exampleInputPassword1">
                        Sua Senha
                    </label>
                    <input type="password" class="form-control" id="exampleInputPassword1" name="txtSenha">
                </div>
                <button type="submit" class="btn btn-primary">
                    Efetivar Cadastro
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