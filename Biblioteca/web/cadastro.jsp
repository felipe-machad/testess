<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Biblioteca</title>
    </head>
    <body>
        <h1>Cadastro Livro</h1>
        <hr>
        <form action="CadastroLivro" method="post">
            <h3>Novo Livro</h3>
            <input type="text" name="titulo" placeholder="Titulo do Livro">
            <br><br>
            <input type="text" name="autor" placeholder="Autor do Livro">
            <br><br>
            <input type="text" name="editora" placeholder="Editora">
            <br><br>
            <input type="number" name="ano_publicacao" placeholder="Ano de Publicação" maxlength="4">
            <br><br>
            <input type="number" name="num_paginas" placeholder="Numero de Paginas">
            <br><br>
           
            <select name="genero" required>
                <option value="">Selecione o gênero</option>
                <option value="narrativo">narrativo</option>
                <option value="épico">épico</option>
                <option value="lírico">lírico</option>
                <option value="dramático">dramático</option>
 
            </select>
            <input type="submit" value="cadastrar" ><hr><br>
     
        </form>
        <a href="home.jsp" >Pagina inicial</a>
        
    </body>
</html>
