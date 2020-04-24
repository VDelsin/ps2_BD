package br.mack.sp;

import br.mack.sp.entities.Produto;
import br.mack.sp.persistencia.ProdutoDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuarioP {
    ProdutoDAO daoP;
    Scanner in;

    public InterfaceUsuarioP(ProdutoDAO daoP) {
        this.in = new Scanner(System.in);
        this.daoP = daoP;
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
            System.out.println("1-Create");
            System.out.println("2-Read");
            System.out.println("3-Update");
            System.out.println("4-Delete");
            System.out.println("5-Sair");
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
        Produto produto = new Produto();
        System.out.println("== Criando novo Produto ==");
        System.out.println("Informe o produto:  ");
        produto.setDescricao(in.nextLine());
        in.nextLine();

        System.out.println("Informe a marca do produto: ");
        produto.setMarca(in.nextLine());

        System.out.println("\nInforme o preço do produto: ");
        produto.setPreco(in.nextDouble());
        if (daoP.create(produto)) {
            System.out.println("Produto adicionado ao Banco de dados!");
        } else {
            System.out.println("Falha ao adicionar Produto!");
        }
    }

    private void read() {
        List<Produto> produtos = daoP.read();

        System.out.println("\n====================================");
        System.out.println("=== Lista de Produtos Cadastrados ===");
        System.out.println("=======================================");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private void update() {
        List<Produto> produtos = daoP.read();

        System.out.println("\n====================================");
        System.out.println("=== Lista de Produtos Cadastrados ===");
        System.out.println("=======================================");
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
        Produto produto = new Produto();
        System.out.println("\nDigite o ID do Produto a ser alterado: ");
        produto.setId(in.nextLong());
        in.nextLine();

        System.out.println("\nInforme a descrição: ");
        produto.setDescricao(in.nextLine());
        in.nextLine();

        System.out.println("Informe a marca");
        produto.setMarca(in.nextLine());

        System.out.println("\nInforme o preço: ");
        produto.setPreco(in.nextDouble());

        if (daoP.update(produto)) {
            System.out.println("Produto alterado no Banco de Dados!");
        } else {
            System.out.println("Falha ao alterar Produto!");
        }

    }

    private void delete() {
        List<Produto> produtos = daoP.read();

        while (true) {
            System.out.println("\n====================================");
            System.out.println("=== Lista de Produtos Cadastrados ===");
            System.out.println("=======================================\n");
            int i = 0;
            for (Produto produto : produtos) {
                System.out.println(i + " - " + produto);
                i++;
            }
            System.out.println(i + " - Cancelar operação\n");

            System.out.print("\nQual produto deseja remover? ");
            int opc = in.nextInt();

            in.nextLine();

            if (opc == i) {
                break;
            }

            if (opc >= produtos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (daoP.delete(produtos.get(opc))) {
                    System.out.println("Produto " + produtos.get(opc).getDescricao() + " removido com sucesso");
                } else {
                    System.out.println("Falha ao tentar remover Produto");
                }
                break;
            }
        }
    }
}
