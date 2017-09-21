<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem Vindo | Alterar Dados Usuario</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
        
        <style>
        .footer {
            position: absolute;
            bottom: 0;
            width: 100%;
            height: 60px;
            margin-bottom: 2px;
        }
    </style>
    </head>
    <body>
       <c:if  test="${sessionScope['logado'] != null}">

            <c:out value="${requestScope.logado}" />
           
        <div class="container-fluid">
            <div class="navbar-wrapper">
                <nav class="navbar navbar-default">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-education"></span> Curso Básico Java</a>
                        </div>
                        <div id="navbar" class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                            </ul>
                            <ul class="nav navbar-nav pull-right">
                                <li><a href="">${logado.getNome().toUpperCase()}  <i class="glyphicon glyphicon-user"></i> </a></li>
                                <li><a href="logout.jsp">Sair <i class="glyphicon glyphicon-log-out"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="jumbotron">
                        <h3 class="text-info text-center">Alterar Dados do Usuário</h3>
                        <hr>
                        <form action="ServletUsuarioController" method="post">
                            <div class="col-md-6">
                                <!--NOME--->
                               <div class="form-group">
                                   <label>Nome</label>
                                   <input type="text" class="form-control" name="nome" value="${usuario.nome}"  required>
                               </div> 
                               <!--RG--->
                               <div class="form-group">
                                   <label>RG</label>
                                   <input type="text" class="form-control" name="rg" value="${usuario.rg}" required>
                               </div>    
                            </div>
                            <div class="col-md-6">
                                <!----SOBRENOME--->
                                <div class="form-group">
                                   <label>Sobrenome</label>
                                   <input type="text" class="form-control" name="sobrenome" value="${usuario.sobrenome}" required>
                                </div>
                               <!--SENHA--->
                               <div class="form-group">
                                   <label>Senha</label>
                                   <input type="password" class="form-control" name="senha" value="${usuario.senha}" required>
                               </div>
                            </div>
                               <button type="submit" class="btn btn-warning form-control" name="opcao" value="alterarUsuario">Alterar Usuario</button>
                        </form>
                    </div>
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
    </c:if>
    </body>
</html>
