package com.mycompany.trabalho_1;

public class PessoaJuridica extends Pessoa{
    private String cnpj;
    private String inscricaoEstadual;
    private double faturamentoMensal;
    private int faixa;
    private int numeroFuncionarios;
    
    //Construtor
    public PessoaJuridica(String nome, String endereco, String telefone, int codigo, String cnpj, String inscricaoEstadual, double faturamentoMensal, int nFuncionarios){
        super(nome, endereco, telefone, codigo);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.faturamentoMensal = faturamentoMensal;
        this.faixa = this.definirFaixa(this.calcularFaturamentoAnual());
        this.numeroFuncionarios = nFuncionarios;
    }
    
    //Getters
    public String getCnpj(){
        return cnpj;
    }
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }
    public double getFaturamentoMensal() {
        return faturamentoMensal;
    }
    public int getFaixa() {
        return faixa;
    }
    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }
    //Setters
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }
    public void setFaturamentoMensal(double faturamentoMensal) {
        this.faturamentoMensal = faturamentoMensal;
    }
    public void setFaixa(int faixa) {
        this.faixa = faixa;
    }
    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }
    

    public void imprimirDados() {
        super.imprimir();
        System.out.println("CNPJ: " + this.cnpj + "\nInscrição Estadual: " + this.inscricaoEstadual + "\nFaturamento Mensal: " +
                d.format(this.faturamentoMensal) + "\nFaixa: " + this.faixa + "\nNúmero de funcionários: " + this.numeroFuncionarios);
    }
    
    private double calcularFaturamentoAnual(){
        return this.faturamentoMensal * 12;
    }
    
    private int definirFaixa(double fatAnual){
        int f = 0;
        if(fatAnual <= 180000) f = 1;
        else if(fatAnual > 180000 && fatAnual <= 360000) f = 2;
        else if(fatAnual > 360000 && fatAnual <= 720000) f = 3;
        else if(fatAnual > 720000 && fatAnual <= 1800000) f = 4;
        else if(fatAnual > 1800000 && fatAnual <= 3600000) f = 5;
        else if(fatAnual > 3600000 && fatAnual <= 4800000) f = 6;
        return f;
    }
    
    public void imprimirFaturamentoAnual(){
        System.out.println("Faturamento Anual: " + d.format(this.calcularFaturamentoAnual()));
    }
    
    public void alterarFaturamento(double valor){
        this.faturamentoMensal += valor;
        if(valor<0) 
            System.out.println("Valor de " + d.format(Math.abs(valor)) + " removido do faturamento mensal!");
        else
            System.out.println("Valor de " + d.format(valor) + " adicionado ao faturamento mensal!");
    }
    
    public void gerarGuiaDePagamento(){
        double fatAnual = this.calcularFaturamentoAnual();
        double IR = 0;
        switch(this.faixa){
            case 1 -> IR = fatAnual * 0.04;
            case 2 -> IR = (fatAnual * 0.073) - 5940;
            case 3 -> IR = (fatAnual * 0.095) - 13860;
            case 4 -> IR = (fatAnual * 0.107) - 22500;
            case 5 -> IR = (fatAnual * 0.143) - 87300;
            case 6 -> IR = (fatAnual * 0.19) - 378000;
        }
        System.out.println("Guia de pagamento");
        System.out.println("Valor do imposto: " + d.format(IR));
    }
}