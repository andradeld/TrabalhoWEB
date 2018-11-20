package UFJF;

import java.util.ArrayList;


public interface daoInterface {
    classeUsuario findByUsuarioSenha(String usuario, String senha);
    ArrayList <classeUsuario> findByUsuarios();
}
