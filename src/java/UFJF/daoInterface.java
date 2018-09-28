/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UFJF;

import java.util.ArrayList;

/**
 *
 * @author pedro
 */
public interface daoInterface {
    classeUsuario findByUsuarioSenha(String usuario, String senha);
    ArrayList <classeUsuario> findByUsuarios();
}
