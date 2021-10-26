package atividadeavaliativa;

import atividadeavaliativa.questao2.Deque;
import java.util.Scanner;

public class AtividadeAvaliativa2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> numeros = new Deque();
        int num;
        int op;
        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    if (numeros.isFull() == false) {
                        System.out.println("Informe um numero: ");
                        num = in.nextInt();
                        numeros.push(num);
                    } else {
                        System.out.println("A Deque está cheia!");
                    }
                    break;
                case 2:
                    if (numeros.isEmpty() == false) {
                        System.out.println(numeros.pop());
                    } else {
                        System.out.println("A Deque está vazia!");
                    }
                    break;
                case 3:
                    if (numeros.isFull() == false) {
                        System.out.println("Informe um numero: ");
                        num = in.nextInt();
                        numeros.inject(num);
                    } else {
                        System.out.println("A Deque está cheia!");
                    }
                    break;
                case 4:
                    if (numeros.isEmpty() == false) {
                        System.out.println(numeros.eject());
                    } else {
                        System.out.println("A Deque está vazia!");
                    }
                    break;
                case 0:
                    System.err.println("Programa encerrado!");
                    break;
                default:
                    System.err.println("Opção inválida!");
                    break;

            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Push (Insere no inicio)");
        System.out.println("2 - Pop (Remove no incio)");
        System.out.println("3 - Inject (Insere no final)");
        System.out.println("4 - Eject (Remove e retorna)");
        System.out.println("0 - Encerrar Programa");
        System.out.print("->");

    }
}
