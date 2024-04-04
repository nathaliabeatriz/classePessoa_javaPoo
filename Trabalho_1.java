package com.mycompany.trabalho_1;
import java.time.LocalDate;

public class Trabalho_1 {
    
    public static void main(String[] args) {
        PessoaFisica pf1 = new PessoaFisica("Ana de Lurdes", "Avenida dos Jacarés, 675", "98516 4578", 456, "João Oliveira", "Joana Silva", 'F', LocalDate.of(2000, 2, 12), "617.789.523-98", "SP-45.609.054", "Brasileira", "Campinas", 3500.00);
        PessoaFisica pf2 = new PessoaFisica("Jeremias Carvalho", "Rua Um - dois - três, 9809", "97883 0983", 023, "André da Silva", "Maria Santos", 'M', LocalDate.of(1987, 9, 30), "876.452.012-34", "MG-45.890.987", "Brasileiro", "Ouro Preto", 1800.0);
        PessoaJuridica pj1 = new PessoaJuridica("Companhia 123", "Rua Brasil, 789", "90789 3456", 523, "49.123.789/0001-31", "M.143.980", 287000, 78);
        
        System.out.println("Informações das Pessoas Físicas cadastradas:\n");
        pf1.imprimirDados();
        System.out.println();
        pf2.imprimirDados();
        System.out.println();
        pf1.aumentarSalario(5.5);
        pf1.exibirSalarioAnual();
        System.out.println();
        pf2.aumentarSalario(50);
        pf2.exibirSalarioAnual();
        System.out.println();
        pf1.temQuePagarIR();
        pf1.imprimePrestacaoIR(4);
        System.out.println();
        pf2.temQuePagarIR();
        
        System.out.println("\nInformações das Pessoas Jurídicas cadastradas:\n");
        pj1.imprimirDados();
        System.out.println();
        pj1.alterarFaturamento(-150.000);
        System.out.println();
        pj1.imprimirFaturamentoAnual();
        System.out.println();
        pj1.gerarGuiaDePagamento();
    }
}
