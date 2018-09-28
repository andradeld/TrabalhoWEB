/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFJF;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pedro
 */
public class servletLista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String usuario_db;
    String senha_db;

    @Override
    public void init() {
        usuario_db = getInitParameter("usuario_banco");
        senha_db = getInitParameter("senha_banco");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession(false);
            //Enumeration <String> l = session.getAttributeNames();  //atributos
            if (session == null || session.getAttribute("login") == null){
              request.setAttribute("erro_login", "Nao logado");
              request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            //Pega a senha do banco de dados
            String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
            String DB_URL = "jdbc:derby://localhost:1527/dados";
            //Credenciais na database
            Connection conn = null;
            Statement stmt = null;
            String resp = null;
            //Cria HTMl
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Lista de usuários</title>");
            out.println("</head>");
            out.println("<body>");
            out.println( "<p>ID da sessão:" + session.getId() + "</p>");
            out.println("<h1>Lista de usuários:</h1>");
            //Tipo de resposta
            try {
               daoClasse teste = new daoClasse();
               ArrayList <classeUsuario> u = teste.findByUsuarios();
               //Iterar pela lista e imprimir
                
                
                out.println("<br><form action='Controller' method='post'>");
                out.println("<button type='submit' name='codigo_op' value='2'> Voltar para o menu </button>");
                out.println("</form>");
                //Acaba o HTML
                out.println("</body>");
                out.println("</html>");
            }catch (Exception e) {
                //Erros do class.name
                resp = e.getMessage();
                throw new ServletException(e);
            }
            //Cuida dos erros
             finally {
                System.out.printf(resp);
                //Fecha as conexoes
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                try {
                    if (conn != null) {
                        conn.close();
                    }

                } catch (SQLException e) {
                    throw new ServletException(e);
                }
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
