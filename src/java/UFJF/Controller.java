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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author pedro
 */
public class Controller extends HttpServlet {

    //Valida
    private void validacao(HttpServletRequest request, HttpServletResponse response) throws ServletException{
        String usuario_db;
        String senha_db;
        usuario_db = getInitParameter("usuario_banco");
        senha_db = getInitParameter("senha_banco");
        //Pega a senha do banco de dados
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/dados";
        //Credenciais na database
        Connection conn = null;
        Statement stmt = null;
        String resp = null;
        //Usuario e senha enviados pelo formulario
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");
        //Tipo de resposta
        try {
            //Registrar driver JDBC
            Class.forName(JDBC_DRIVER);
            //Abre conexão
            conn = DriverManager.getConnection(DB_URL, usuario_db, senha_db);
            //Faz query sql
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT usuario, senha FROM app.tabela where upper(usuario) = '" + usuario.toUpperCase() + "' and senha='" + senha + "'";
            ResultSet rs = stmt.executeQuery(sql);
            boolean result = false;
            //Extrai os dados dos resultados
            if (rs.next()) {
                result = true;
            }
            if (result) {
                HttpSession session = request.getSession(true);
                session.setAttribute("login", true);
                session.setAttribute("teste", new Integer(222));
                request.getRequestDispatcher("menu.jsp").forward(request, response);
            } else {
                request.setAttribute("erro_login", "Senha errada");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            //Cuida dos erros
            resp = e.getMessage();
            throw new ServletException(e);
        } catch (Exception e) {
            //Erros do class.name
            resp = e.getMessage();
            throw new ServletException(e);
        } finally {
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
    
    //Invalidacao
    private void invalidacao (HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
    
    //Controller
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if(session == null && request.getParameter("codigo_op") == null){
            request.setAttribute("erro_login", "Nao logado");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else{
            //Aqui é se a sessao ja existe
            int s = Integer.parseInt(request.getParameter("codigo_op"));
            switch (s){
                //Logar
                case -1:{
                    validacao(request,response);
                    break;
                }
                //Sair do sistema
                case 0:{
                    invalidacao(request,response);
                    break;
                }
                //Exibir lista de usuarios
                case 1:{
                    request.getRequestDispatcher("servletLista").forward(request, response);
                    break;
                }
                //Voltar pro menu da lista de usuarios
                case 2:{
                    response.sendRedirect("menu.jsp");
                    //request.getRequestDispatcher("menu.jsp").forward(request, response);
                    break;
                }
                default:{
                    session.removeAttribute("codigo_op");
                    break;
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
