/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFJF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author pedro
 */
public class daoClasse implements daoInterface {
    
    @Override
    public classeUsuario findByUsuarioSenha(String usuario, String senha){
        
        String usuario_db = "nbuser";
        String senha_db = "abc1234";
        //usuario_db = getInitParameter("usuario_banco");
        //senha_db = getInitParameter("senha_banco");
        //Pega a senha do banco de dados
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/dados";
        //Credenciais na database
        Connection conn = null;
        Statement stmt = null;
        String resp = null;        
        
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
            //Extrai os dados dos resultados
            if (rs.next()) {
                classeUsuario user = new classeUsuario(); //Usuario para retornar
                user.setNome(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                rs.close();
                stmt.close();
                conn.close();
                return user;
            }
            else{
                rs.close();
                stmt.close();
                conn.close();
                return null;
            }
        } catch (SQLException e) {
            //Cuida dos erros
            resp = e.getMessage();
            throw new RuntimeException(e);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(daoClasse.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } 
        finally {
            //Fecha as conexoes
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    @Override
    public ArrayList <classeUsuario> findByUsuarios(){
        
        String usuario_db = "nbuser";
        String senha_db = "abc1234";
        //usuario_db = getInitParameter("usuario_banco");
        //senha_db = getInitParameter("senha_banco");
        //Pega a senha do banco de dados
        String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";
        String DB_URL = "jdbc:derby://localhost:1527/dados";
        //Credenciais na database
        Connection conn = null;
        Statement stmt = null;
        String resp = null;        
        
        try {
            //Registrar driver JDBC
            Class.forName(JDBC_DRIVER);
            //Abre conexão
            conn = DriverManager.getConnection(DB_URL, usuario_db, senha_db);
            //Faz query sql
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT usuario FROM app.tabela order by usuario asc";
            ResultSet rs = stmt.executeQuery(sql);
            ArrayList <classeUsuario> users = new ArrayList<>();
            //Extrai os dados dos resultados
            while (rs.next()) {
                classeUsuario user = new classeUsuario();
                user.setNome(rs.getString("usuario"));
                user.setSenha(rs.getString("senha"));
                users.add(user);
            }
            rs.close();
            stmt.close();
            conn.close();
            return users;
        } catch (SQLException e) {
            //Cuida dos erros
            resp = e.getMessage();
            throw new RuntimeException(e);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(daoClasse.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        } 
        finally {
            //Fecha as conexoes
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
