<%--
  Created by IntelliJ IDEA.
  User: Dracula Castle
  Date: 12/04/2020
  Time: 00:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="Usuario" type="Model.Usuario" scope="request"/>
<html>
<head>
    <title>FUNCIONANDO</title>
</head>
<body>
    <h1>Bem vindo</h1>
    <hr/>
    Seu id: <strong>${Usuario.id}</strong> <br/>
    Seu nome: <strong>${Usuario.fullName}</strong> <br/>
    Seu username: <strong>${Usuario.username}</strong> <br/>
    Seu email: <strong>${Usuario.email}</strong> <br/>
</body>
</html>
