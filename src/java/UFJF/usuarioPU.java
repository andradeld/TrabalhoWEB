package UFJF;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "TABELA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "usuarioPU.findAll", query = "SELECT u FROM usuarioPU u")
    , @NamedQuery(name = "usuarioPU.findByUsuario", query = "SELECT u FROM usuarioPU u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "usuarioPU.findBySenha", query = "SELECT u FROM usuarioPU u WHERE u.senha = :senha")})
public class usuarioPU implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "USUARIO")
    private String usuario;
    @Size(max = 45)
    @Column(name = "SENHA")
    private String senha;

    public usuarioPU() {
    }

    public usuarioPU(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof usuarioPU)) {
            return false;
        }
        usuarioPU other = (usuarioPU) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UFJF.usuarioPU[ usuario=" + usuario + " ]";
    }
    
}
