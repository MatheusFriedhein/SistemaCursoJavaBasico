<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bem Vindo | HOME</title>
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        
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
                                <li><a href="ServletUsuarioController?opcao=logout">Sair <i class="glyphicon glyphicon-log-out"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <div class="jumbotron">
                        <h3 class="text-info text-center">Cadastro de Usuário</h3>
                        <hr>
                        <form action="ServletUsuarioController" autocomplete="off" method="post">
                            <div class="col-md-6">
                                <!--NOME--->
                               <div class="form-group">
                                   <label>Nome</label>
                                   <input type="text" class="form-control" name="nome" required>
                               </div> 
                               <!--RG--->
                               <div class="form-group">
                                   <label>RG</label>
                                   <input type="text" class="form-control" name="rg" maxlength="10" required>
                               </div>    
                            </div>
                            <div class="col-md-6">
                                <!----SOBRENOME--->
                                <div class="form-group">
                                   <label>Sobrenome</label>
                                   <input type="text" class="form-control" name="sobrenome" required>
                                </div>
                               <!--SENHA--->
                               <div class="form-group">
                                   <label>Senha</label>
                                   <input type="password" class="form-control" name="senha" required>
                               </div>
                            </div>
                               <button type="submit" class="btn btn-primary form-control" name="opcao" value="cadastrarUsuario">Cadastrar Usuario</button>
                        </form>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
            <jsp:useBean id="listaUsuario" class="dao.UsuarioDao" />
            <c:set var="lista" value="${listaUsuario.usuario}"  />
            <div class="container">   
                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-8">
                        <div class="jumbotron">
                            <h3 class="text-center text-info">Usuários Cadatrados</h3>
                            <hr>
                            <table class="table table-striped table-hover">
                                <tr style="color: #1b6d85; ">
                                    <th class="text-center">Nome</th>
                                    <th class="text-center">Sobrenome</th>
                                    <th class="text-center">RG</th>
                                    <th class="text-center">Deletar</th>
                                    <th class="text-center">Atualizar</th>
                                </tr>
                                <c:forEach var="lis" items="${lista}">
                                    <tr>
                                        <td class="text-center"> <b> ${lis.nome}</b></td>
                                        <td class="text-center"> <b> ${lis.sobrenome}</b></td> 
                                        <td class="text-center"> <b> ${lis.rg}</b></td> 
                                        <td class="text-center"><a href="ServletUsuarioController?idUsuario=${lis.idUsuario}&&opcao=deletaUsuario"><span class="glyphicon glyphicon-remove btn btn-danger"></span></a></td>
                                        <td class="text-center"><a href="ServletUsuarioController?idUsuario=${lis.idUsuario}&&opcao=pesquisaUsuario"><span class="glyphicon glyphicon-refresh btn btn-success"></span></a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <div class="col-lg-2"></div>
                </div>
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
