package empresa;

import Produtos.CadastroProduto;
import java.util.Scanner;

public class Empresa {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CadastroProduto C = new CadastroProduto();
        int op;
        String codigo;
        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    C.cadastroP();
                    break;
                case 2:
                    C.exibeInfoGeral();
                    break;
                case 3:
                    System.out.println("Informe o codigo do produto que você deseja alterar o preço: ");
                    codigo = in.next();
                    C.alteraPreco(codigo);
                    break;
                case 4:
                    System.out.println("Informe o codigo do produto que você deseja alterar o estoque: ");
                    codigo = in.next();
                    C.alteraEstoque(codigo);
                    break;
                case 5:
                    System.out.println("Informe o codigo do produto que você deseja exibir as informações: ");
                    codigo = in.next();
                    C.exibeInfo(codigo);
                    break;
                case 6:
                    System.out.println("Informe o codigo do produto que você deseja exibir as informações: ");
                    codigo = in.next();
                    C.removeProduto(codigo);
                    break;
                case 0:
                    System.err.println("PROGRAMA ENCERRADO!");
                    break;
                default:
                    System.err.println("Opção inválida!");
                    break;
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.println("Selecione uma opção:");
        System.out.println("1 - Cadastrar um novo produto;");
        System.out.println("2 - Exibir as informações de todos os produtos cadastrados;");
        System.out.println("3 - Alterar preço de um produto;");
        System.out.println("4 - Alterar o estoque de um produto;");
        System.out.println("5 - Exibir informações de um determinado produto;");
        System.out.println("6 - Remover um produto do cadastro;");
        System.out.println("0 - Encerrar o programa;");
        System.out.print("->");
    }
}
