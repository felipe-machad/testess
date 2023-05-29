package controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import model.Livro;
import model.LivroDAO;

@WebServlet(name = "CadastroLivro", urlPatterns = {"/CadastroLivro"})
public class CadastroLivro extends HttpServlet {
    private int id;
    private String titulo;
    private String autor;
    private String editora;
    private int ano_publicacao;
    private int num_paginas;
    private String genero;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        if(request.getParameter("cod")!= null){
            this.id = Integer.parseInt(request.getParameter("cod"));
        }
        
        //Recebendo parâmetros vindos do formulário de cadastro
        this.titulo = request.getParameter("titulo");
        this.autor = request.getParameter("autor");
        this.editora = request.getParameter("editora");
        this.ano_publicacao = Integer.parseInt(request.getParameter("ano_publicacao"));
        this.num_paginas = Integer.parseInt(request.getParameter("num_paginas"));
        this.genero = request.getParameter("genero");
        
        //Criando objeto da classe Proprietário, para que seja enviado
        //ao método de inserção no banco de dados
        Livro l = new Livro(
                this.titulo,
                this.autor,
                this.editora,
                this.ano_publicacao,
                this.num_paginas,
                this.genero
        );
               
        try {
            LivroDAO ldao = new LivroDAO();
            
            if(request.getParameter("cod")== null){
                ldao.insertProprietario(l);
            } else {
                l.setIdLivro(this.id);
                ldao.updateLivro(l);
            }
            
            response.sendRedirect("lista.jsp");
            
        } catch(SQLException | ClassNotFoundException erro) {
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroLivro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Ocorreu algum erro: " + erro + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}