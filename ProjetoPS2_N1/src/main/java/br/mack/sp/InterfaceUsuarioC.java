package br.mack.sp;

import br.mack.sp.entities.Computador;
import br.mack.sp.persistencia.ComputadorDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuarioC {
    ComputadorDAO dao;
    Scanner in;

    public InterfaceUsuarioC(ComputadorDAO dao) {
        this.in = new Scanner(System.in);
        this.dao = dao;
    }


    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opt = 0;
        while (true) {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1-Create");
            System.out.println("\t2-Read");
            System.out.println("\t3-Update");
            System.out.println("\t4-Delete");
            System.out.println("\t5-Sair");
            System.out.println("==============");
            opt = in.nextInt();
            in.nextLine();
            switch (opt) {
                case 1:
                    this.create();
                    break;

                case 2:
                    this.read();
                    break;

                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("Obrigado por utilizar o programa");
                    return;
            }
        }
    }

    private void create() {
        Computador computador = new Computador();
        System.out.println("** Criando novo Computador **\n");
        System.out.println("Informe a marca: ");
        computador.setMarca(in.nextLine());
        in.nextLine();

        System.out.println("Informe o processador: ");
        computador.setProcessador(in.nextLine());

        System.out.println("\nInforme a quantidade de RAM do computador: ");
        computador.setQtde_ram(in.nextInt());

        System.out.println("\nInforme o tamanho do HD em GB: ");
        computador.setTmn_disco(in.nextInt());

        if (dao.create(computador)) {
            System.out.println("Computador adicionado ao Banco de Dados!");
        } else {
            System.out.println("Falha ao adicionar Computador!");
        }
    }

    private void read() {

        List<Computador> computadores = dao.read();

        System.out.println("\n==========================================");
        System.out.println("=== Lista de Computadores Cadastrados ===");
        System.out.println("============================================\n");
        for (Computador computador : computadores) {
            System.out.println(computador);
        }
    }

    private void update() {
        in.nextLine();
        List<Computador> computadores = dao.read();
        System.out.println("\n==========================================");
        System.out.println("=== Lista de Computadores Cadastrados ===");
        System.out.println("============================================\n");
        for (Computador computador : computadores) {
            System.out.println(computador + "\n");
        }
        Computador computador = new Computador();
        System.out.println("Digite o ID do computador a ser alterado: ");
        computador.setId_computador(in.nextLong());
        in.nextLine();
        System.out.println("Informe a marca: ");
        computador.setMarca(in.nextLine());
        in.nextLine();

        System.out.println("\nInforme o processador");
        computador.setProcessador(in.nextLine());

        System.out.println("\nInforme a quantidade de RAM do computador: ");
        computador.setQtde_ram(in.nextInt());

        System.out.println("\nInforme o tamanho do HD em GB: ");
        computador.setTmn_disco(in.nextInt());

        if (dao.update(computador)) {
            System.out.println("Computador alterado no Banco de Dados!");
        } else {
            System.out.println("Falha ao alterar Computador!");

        }

    }

    private void delete() {
        List<Computador> computadores = dao.read();
        while (true) {
            System.out.println("\n==========================================");
            System.out.println("=== Lista de Computadores Cadastrados ===");
            System.out.println("============================================\n");
            int i = 0;
            for (Computador computador : computadores) {
                System.out.println(i + " - " + computador);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.println("Qual Computador você deseja remover? ");

            int opc = in.nextInt();

            in.nextLine();

            if (opc == i) {

                break;
            }

            if (opc >= computadores.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(computadores.get(opc))) {
                    System.out.println("Computador " + computadores.get(opc).getMarca() + " removido com sucesso");
                } else {
                    System.out.println("Falha ao tentar remover Computador");
                }
                break;
            }
        }
    }
}


