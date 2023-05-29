<%@page import="model.Livro" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    Livro l = (Livro)request.getAttribute("livr");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca</title>
    </head>
    <body>
        <h1>EDITAR</h1>
        <hr>
        <form action="CadastroLivro" method="post">
            <input type="int" name="cod" value="<%= l.getIdLivro() %>" readonly>
            <br><br>
            
            <input type="text" name="titulo" value="<%= l.getTitulo() %>" placeholder="Titulo do livro" required>
            
            <br><br>
            
            <input type="text" name="autor" value="<%= l.getAutor() %>" placeholder="Autor do Livro" required>
        
            <br><br>
            
            <input type="text" name="editora" value="<%= l.getEditora() %>" placeholder="Editora do Livro" required>
            
            <br><br>
            
            <input type="number" name="ano_publicacao" value="<%= l.getAno_publicacao() %>" placeholder="ano_publicacao" required maxlength="4">
            
            <br><br>
            
            <input type="number" name="num_paginas" value="<%= l.getNum_paginas() %>" placeholder="num_paginas" required>
            
            <br><br>
            
            <select name="genero" required>
                <option value="<%= l.getGenero() %>"><%= l.getGenero() %></option>
                <option value="narrativo">narrativo</option>
                <option value="épico">épico</option>
                <option value="lírico">lírico</option>
                <option value="dramático">dramático</option>
            </select>
            
            <input type="submit" value="Atualizar">
        </form>
        <br>
        <a href="home.jsp">Página Inicial</a>
    </body>
</html>