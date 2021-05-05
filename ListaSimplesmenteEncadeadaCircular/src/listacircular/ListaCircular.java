package listacircular;

import java.util.Scanner;
import lseCirc.LSECircular;

public class ListaCircular {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LSECircular<Integer> lseC = new LSECircular();
        int op, num;
        do {
            menu();
            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Informe o valor para ser inserido no inicio:");
                    num = in.nextInt();
                    lseC.insereInicio(num);
                    break;
                case 2:
                    System.out.println("Informe o valor para ser inserido no final:");
                    num = in.nextInt();
                    lseC.insereFinal(num);
                    break;
                case 3:
                    lseC.exibirLista();
                    break;
                case 4:
                    lseC.removeInicial();
                    break;
                case 5:
                    lseC.removeFinal();
                    break;
                case 6:
                    System.out.println("Informe o valor que você deseja procurar: ");
                    num = in.nextInt();
                    lseC.contaValores(num);
                    break;
                case 0:
                    System.out.println("|-PROGRAMA ENCERRADO-|");
                    break;
                default: 
                    System.err.println("|-OPÇÃO INVÁLIDA-|");
                    break;
            }
        } while (op != 0);

    }

    public static void menu() {
        System.out.println("==========================================================");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Inserir um valor no inicio;");
        System.out.println("2 - Inserir valor no final;");
        System.out.println("3 - Exibir todos os valores;");
        System.out.println("4 - Remover no inicio;");
        System.out.println("5 - Remover no final;");
        System.out.println("6 - Consultar quantas vezes esse valor aparece na lista;");
        System.out.println("0 - Encerrar programa;");
        System.out.println("==========================================================");
        System.out.print("->");
    }
}
