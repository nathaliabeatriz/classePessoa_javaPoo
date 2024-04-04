package com.mycompany.trabalho_1;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PessoaFisica extends Pessoa{
    private String nomePai;
    private String nomeMae;
    private char sexo;
    private LocalDate dataNascimento;
    private String cpf;
    private String rg;
    private String nacionalidade;
    private String naturalidade;
    private double salario;
    
    //Construtor
    public PessoaFisica(String nome, String endereco, String telefone, int codigo,
            String nomePai, String nomeMae, char sexo, LocalDate dataNasc, String cpf, String rg, String nacionalidade, String naturalidade, double salario){
        super(nome, endereco, telefone, codigo);
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.sexo = sexo;
        this.dataNascimento = dataNasc;
        this.cpf = cpf;
        this.rg = rg;
        this.nacionalidade = nacionalidade;
        this.naturalidade = naturalidade;
        this.salario = salario;
    }
    
    //Getters
    public String getNomePai() {
        return nomePai;
    }
    public String getNomeMae() {
        return nomeMae;
    }
    public char getSexo() {
        return sexo;
    }
    public String getDataNascimento() {
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = this.dataNascimento.format(formatadorData);
        return dataFormatada;
    }
    public String getCpf() {
        return cpf;
    }
    public String getRg() {
        return rg;
    }
    public String getNacionalidade() {
        return nacionalidade;
    }
    public String getNaturalidade() {
        return naturalidade;
    }
    public double getSalario() {
        return salario;
    }
    //Setters
    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }
    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public void setNaturalidade(String naturalidade){
        this.naturalidade = naturalidade;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public void imprimirDados(){
        super.imprimir();
        System.out.println("Nome do pai: " + this.nomePai + "\nNome da mãe: " + this.nomeMae + "\nSexo: " + this.sexo + 
                "\nData de nascimento: " + this.getDataNascimento() + "\nCPF: " + this.cpf + "\nRG: " + this.rg + 
                "\nNacionalidade: " + this.nacionalidade + "\nNaturalidade: " + this.naturalidade + "\nSalário: " + d.format(this.salario));
    }
    
    public void exibirSalarioAnual(){
        System.out.println("Nome: " + this.getNome() + "\nSalário Anual: " + d.format(this.calcularSalarioAnual()));   
    }
    
    public void aumentarSalario(double porcentagem){
        double aumento = this.salario*(porcentagem/100);
        this.salario += aumento;
        System.out.println("Aumento de " + d.format(aumento) + " realizado com sucesso!");
    }
    
    public void aumentarSalario(int valor){
        this.salario += valor;
        System.out.println("Aumento de " + d.format(valor) + " realizado com sucesso!");
    }
    
    private double calcularSalarioAnual(){
        return this.salario*12;
    }
    
    public void temQuePagarIR(){
        double salarioAnual = this.calcularSalarioAnual();
        if((double)salarioAnual/12 < 1903.99) 
            System.out.println("Pessoa Física " + this.getNome() + ": Isento de pagar imposto de renda.");
        else{
            System.out.println("Pessoa Física " + this.getNome() + ": Deve pagar imposto de renda");
            System.out.println("Valor: " + d.format(this.calculaIR()));
        }
    }
    
    private double calculaIR(){
        double salarioMes = this.salario;
        double IR=0;
        if(salarioMes >= 1903.99 && salarioMes <= 2826.65) IR = salarioMes*((double)7.5/100);
        else if(salarioMes >= 2826.66 && salarioMes <= 3751.05) IR = salarioMes*((double)15/100);
        else if(salarioMes >= 3751.06 && salarioMes <= 4664.68) IR = salarioMes*((double)22.5/100);
        else if(salarioMes >= 4664.68) IR = salarioMes*((double)27.5/100);
        return IR;
    }
    
    public void imprimePrestacaoIR(int parcelas){
        double valorImposto = this.calculaIR();
        if(parcelas>8){
            System.out.println("Número máximo de parcelas é 8.");
            return;
        }
        if(parcelas<2){
            System.out.println("Número mínimo de parcelas é 2.");
            return;
        }
        System.out.println("Valor de cada parcela: " + d.format((double)valorImposto/parcelas));
    }
}
