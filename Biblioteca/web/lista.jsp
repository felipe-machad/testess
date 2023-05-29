<%-- 
    Document   : listar
    Created on : 10 de mai. de 2023, 09:44:15
    Author     : QI
--%>
<%@page import="model.Livro"%>
<%@page import="model.LivroDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblcitecefa</title>
    </head>
    <body>
        <h1>LISTAR</h1>
        <hr>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Titulo</th>
                    <th>Autor</th>
                    <th>Editora</th>
                    <th>Ano_pub</th>
                    <th>numpag</th>
                    <th>gen</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <%
                LivroDAO ldao = new LivroDAO();
                for(Livro l : ldao.listLivro()) {
                %>
                <tr>
                    <td><%= l.getIdLivro() %></td>
                    <td><%= l.getTitulo() %></td>
                    <td><%= l.getAutor() %></td>
                    <td><%= l.getEditora() %></td>
                    <td><%= l.getAno_publicacao() %></td>
                    <td><%= l.getNum_paginas() %></td>
                    <td><%= l.getGenero() %></td>
                    <td>
                        <a href="UpdateLivro?cod=<%= l.getIdLivro() %>">📝</a>
                    </td>
                    <td onclick="confirmDelete(<%= l.getIdLivro() %>)">❌</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <hr>
        <a href="home.jsp">Página Inicial</a>
        
        <script>
            function confirmDelete(cod) {
                if(confirm("Deseja realmente excluir?")){
                    window.location.replace("DeleteLivro?cod=" + cod);
                } else {
                    alert("Exclusão cancelada!");
                }
            }
        </script>
    </body>
</html>