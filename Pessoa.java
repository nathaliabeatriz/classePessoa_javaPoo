package com.mycompany.trabalho_1;
import java.text.DecimalFormat;
public abstract class Pessoa {
    public String formato = "R$ ###,###,##0.00";
    DecimalFormat d = new DecimalFormat(formato);
    
    private String nome;
    private String endereco;
    private String telefone;
    private int codigo;
    
    //Construtor
    public Pessoa(String nome, String endereco, String telefone, int codigo){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.codigo = codigo;
    }
    
    //Getters
    public String getNome() {
        return nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public String getTelefone() {
        return telefone;
    }
    public int getCodigo() {
        return codigo;
    }
    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public void imprimir(){
        System.out.println("Nome: " + this.nome + "\nEndereco: " + this.endereco +
                "\nTelefone: " + this.telefone + "\nCodigo: " + this.codigo);
    }
}
