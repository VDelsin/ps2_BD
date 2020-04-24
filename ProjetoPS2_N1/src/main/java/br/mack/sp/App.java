package br.mack.sp;


import br.mack.sp.persistencia.ComputadorDAOMySQL;

import java.util.Scanner;

import br.mack.sp.persistencia.ProdutoDAOMySQL;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ComputadorDAOMySQL mysqlDAO = new ComputadorDAOMySQL();
        ProdutoDAOMySQL mysqlDAOP = new ProdutoDAOMySQL();
        int opc = 0;
        System.out.println("Informe qual Banco de Dados você gostaria de acessar");
        System.out.println(" 1- Computador ");
        System.out.println(" 2- Produto ");
        opc = input.nextInt();
        switch (opc) {
            case 1:
                InterfaceUsuarioC interfaceUsuarioC = new InterfaceUsuarioC(mysqlDAO);
                interfaceUsuarioC.iniciar();
                break;
            case 2:
                InterfaceUsuarioP interfaceUsuarioP = new InterfaceUsuarioP(mysqlDAOP);
                interfaceUsuarioP.iniciar();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

    }
}