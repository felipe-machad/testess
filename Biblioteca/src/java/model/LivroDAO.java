package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivroDAO {
    private static Connection conn;
    
    public LivroDAO() throws SQLException, ClassNotFoundException {
        conn = MyConnection.getConnection();
    }
    
    //Iniciando métodos do CRUD
    //SELECT (READ)
    public ArrayList<Livro> listLivro() throws SQLException {
        //Criar lista vazia
        ArrayList<Livro> list = new ArrayList<>();
        
        //Query SQL
        String query = "SELECT * FROM Livros";
        
        //Preparando a query para lançar no banco de dados
        PreparedStatement prep = conn.prepareStatement(query);
        
        //Recebendo o resultado da query na variável result
        //da classe ResultSet
        ResultSet result = prep.executeQuery();
        
        //Enqunto houverem resultados, executa a operação
        while(result.next()) {
            //Objeto vazio de Proprietario
            Livro Livro = new Livro();
            
            //Inserindo atributos neste objeto por meio dos setters
            Livro.setIdLivro(result.getInt("id"));
            Livro.setTitulo(result.getString("titulo"));
            Livro.setAutor(result.getString("autor"));
            Livro.setEditora(result.getString("editora"));
            Livro.setAno_publicacao(result.getInt("ano_publicacao"));
            Livro.setNum_paginas(result.getInt("num_paginas"));
            Livro.setGenero(result.getString("genero"));
            
            //Adicionando objeto preenchido na lista
            list.add(Livro);
        }
        //Retornando a lista com todos os registros do BD
        return list;
    }
    
    //Insert (CREATE)
    public void insertProprietario(Livro pro) throws SQLException {
        //Criar a query para inserção
        String query = "INSERT INTO livros(titulo, autor, editora, ano_publicacao, num_paginas, genero)"
                + "VALUES(?,?,?,?,?,?)";
        
        //Preparando a query para lançar no BD
        PreparedStatement prep = conn.prepareStatement(query);
        
        //Pegar os atributos recebidos do objeto Proprietario
        //e lançar na query
        prep.setString(1, pro.getTitulo());
        prep.setString(2, pro.getAutor());
        prep.setString(3, pro.getEditora());
        prep.setInt(4, pro.getAno_publicacao());
        prep.setInt(5, pro.getNum_paginas());
        prep.setString(6, pro.getGenero());
        
        //Lnaçar a query pronta para o BD
        prep.execute();
        prep.close();
    }
    
    //DELETE
    public void deleteLivro(int i) throws SQLException {
        String query = "DELETE FROM livros "
                + "WHERE id = " + i;
        
        PreparedStatement prep = conn.prepareStatement(query);
        
        prep.execute();
        prep.close();
    }
    
    
    //LIST BY ID (Selecionar apenas um registro)
    public Livro listById(int id) throws SQLException {
        Livro l = new Livro();
        
        String sql = "SELECT * FROM Livros "
                + "WHERE id = " + id;
        
        PreparedStatement prep = conn.prepareStatement(sql);
        ResultSet result = prep.executeQuery();
        
        if(result.next()) {
            l.setIdLivro(result.getInt("id"));
            l.setTitulo(result.getString("titulo"));
            l.setAutor(result.getString("autor"));
            l.setEditora(result.getString("editora"));
            l.setAno_publicacao(result.getInt("ano_publicacao"));
            l.setNum_paginas(result.getInt("num_paginas"));
            l.setGenero(result.getString("genero"));
        }
        
        return l;
    }
    
    
    //UPDATE
    public void updateLivro(Livro l) throws SQLException {
        String sql = "UPDATE Livros SET titulo = ?,"
                + "autor = ?, editora = ?, ano_publicacao = ?,"
                + "num_paginas = ?, genero = ? "
                + "WHERE id = ?";
        
        PreparedStatement prep = conn.prepareStatement(sql);

        prep.setString(1, l.getTitulo());
        prep.setString(2, l.getAutor());
        prep.setString(3, l.getEditora());
        prep.setInt(4, l.getAno_publicacao());
        prep.setInt(5, l.getNum_paginas());
        prep.setString(6, l.getGenero());
                prep.setInt(7, l.getIdLivro());
        
        prep.execute();
        prep.close();
    }
}