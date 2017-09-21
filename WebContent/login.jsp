<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <style>
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            margin-bottom: 2px;
        }
    </style>
    <body>
        <div class="container container-fluid">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6 text-center">
                    <center><img class="img img-responsive text-center" src="imagens/logo-curso.PNG" alt="logo-curso"/></center>
                </div>
                <div class="col-md-3"></div>
            </div>
           <div class="row">
                <br><br>
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <form action="ServletUsuarioController" autocomplete="off" method="post">
                        <div class="jumbotron">
                            <h3 class="title"><strong>Login</strong><i class="glyphicon glyphicon-lock pull-right"></i></h3>
                            <h5 class="title"> Informe os seguintes dados:</h5>
                            
                            <!--NOME--->
                            <div class="form-group">
                                <label>Nome:</label>
                                <input type="text" class="form-control" name="nome" required>
                            </div>
                            <!--SENHA--->
                            <div class="form-group">
                                <label>Senha:</label>
                                <input type="password" class="form-control" name="senha" required>
                            </div>
                            <button type="submit" class="btn btn-info form-control" name="opcao" value="logar">Entrar</button>
                        </div>
                    </form>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
        <footer class="footer text-center">
            <div class="container-fluid">
                <hr >
                <div class="col-md-4"> 
                    <span class="text-info pull-left"><strong>Matheus Friedhein Flores</strong></span>
                </div>
                <div class="col-md-4"> 
                    <span class="text-info text-center "><strong>Curso Java Web Básico</strong> @Todos direitos reservados 2017.</span>
                </div>
                <div class="col-md-4">
                    <span class="text-info pull-right"><strong>Prof.Dr. Alencar Machado</strong></span>
                </div>
            </div>
        </footer>
    </body>
</html>
