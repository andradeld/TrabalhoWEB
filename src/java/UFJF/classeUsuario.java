package UFJF;

public class classeUsuario {
    private String nome;
    private String senha;
    
    public String getNome(){
        return this.nome;
    }
    public String getSenha(){
        return this.senha;
    }
    public void setNome(String n){
        this.nome = n;
    }
    public void setSenha(String s){
        this.senha = s;
    }
}
