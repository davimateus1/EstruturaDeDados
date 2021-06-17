package aplicaçãolse;

import java.util.Scanner;
import logica.LSEOrdenado;

public class AplicaçãoLSE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSEOrdenado<Integer> lse = new LSEOrdenado();
        int op;
        int num;
        do {
            menu();
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.print("Informe o valor para ser inserido: ");
                    num = in.nextInt();
                    lse.insereOrdDecrescente(num);
                    break;
                case 2:
                    System.out.print("Informe o valor para ser removido: ");
                    num = in.nextInt();
                    lse.removeValor(num);
                    break;
                case 3:
                    lse.exibeValores();
                    break;
                case 0:
                    System.err.println("Programa encerrado.");
                    break;
                default:
                    System.err.println("Opção inválida!");
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.print("1- Inserir um novo valor na lista;\n2 - Remover um valor;"
                + "\n3 - Exibir valores;\n0 - Encerrar.\nInforme o opção que você deseja: ");
    }
}
