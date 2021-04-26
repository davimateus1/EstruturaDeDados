package atividadequatrolde;

import LDEs.LDE;
import java.util.Scanner;

public class AtividadeQuatroLDE {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LDE<Integer> valores = new LDE();
        int num, op, valor;
        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Informe o valor:");
                    num = in.nextInt();
                    valores.insereOrdenadoDecrescente(num);
                    break;
                case 2:
                    System.out.println("Informe o valor que você deseja remover: ");
                    num = in.nextInt();
                    valores.removeValor(num);
                    break;
                case 3:
                    valores.exibeDecrescente();
                    break;
                case 4:
                    valores.exibeCrescente();
                    break;
                case 5:
                    System.out.println("Informe o valor que você deseja consultar: ");
                    valor = in.nextInt();
                    valores.exibeInformacoes(valor);
                    break;
                case 0:
                    System.err.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (op != 0);

    }

    public static void menu() {
        System.out.println("Informe oque você deseja fazer: ");
        System.out.println("1 - Inserir um valor;");
        System.out.println("2 - Remover um valor;");
        System.out.println("3 - Exibir valores em ordem decrescente;");
        System.out.println("4 - Exibir valores em ordem crescente; ");
        System.out.println("5 - Exibir informaçõess do objeto;");
        System.out.println("0 - Encerrar o programa;");
        System.err.print("->");
    }

}
