package atividadeavaliativa;

import atividadeavaliativa.questao1.Queue;
import java.util.Scanner;

public class AtividadeAvaliativa {

    static int cont = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue clientes = new Queue(10);
        int op;
        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    forneceSenha(clientes);
                    break;
                case 2:       
                    chamaSenha(clientes);
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

    public static void forneceSenha(Queue cli) {    
        if (cli.isEmpty() == true) {
            cont++;
            System.out.println("Não tem ninguém na fila, você será o proximo a ser atendido. Senha: " + cont + ".");
            cli.enqueue(cont);
        }else if (cli.isFull() == true){
            System.out.println("Por conta da COVID-19 o limite máximo é de 10 pesssoas, por favor, volte mais tarde.");
        }
        else{
            cont++;
            System.out.println("Sua senha é a senha " + cont + ".");
            cli.enqueue(cont);
        }
    }

    public static void chamaSenha(Queue cli) {
        System.out.println("SENHA CHAMADA: " + cli.dequeue());
    }

    public static void menu() {
        System.out.println("Informe uma opção:");
        System.out.println("1 - Solicitar uma senha; ");
        System.out.println("2 - Senha chamada; ");
        System.out.println("0 - Encerrar programa;");
        System.out.print("->");
    }

}
