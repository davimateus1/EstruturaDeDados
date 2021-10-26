package listaldec;

import java.util.Scanner;
import ldes.LDECircular;

public class ListaLdeC {

    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
        LDECircular<Integer> lista1 = new LDECircular();
        LDECircular<Integer> lista2 = new LDECircular();
        int op, num;
        do{
        menu();
        op = in.nextInt();
        switch(op){
            case 1:
                System.out.println("Informe o valor que você deseja inserir:");
                num = in.nextInt();
                lista1.insereValorFinal(num);
                System.out.println("-VALOR INSERIDO-");
                break;
            case 2:
                System.out.println("Informe o valor que você deseja inserir:");
                num = in.nextInt();
                lista2.insereValorFinal(num);
                System.out.println("-VALOR INSERIDO-");
                break;
            case 3:
                lista1.concatenarListas(lista2);
                System.out.println("Listas concatenadas!");
                break;
            case 4:
                lista2 = lista1.divideListas();
                System.out.println("Lista dividida!");
                break;
            case 5: 
                lista1.exibe();
                break;
            case 6: 
                lista2.exibe();
                break;
            case 0: 
                System.err.println("Programa encerrado!");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
        
        }while(op != 0);
    }

    public static void menu(){
        System.out.println("ESCOLHA UMA OPÇÃO:");
        System.out.println("1 - Inserir um valor na lista n° 1;");
        System.out.println("2 - Inserir um valor na lista n° 2;");
        System.out.println("3 - Concatenar as listas;");
        System.out.println("4 - Dividir as listas;");
        System.out.println("5 - Exibir valores da lista n° 1;");
        System.out.println("6 - Exibir valores da lista n° 2;");
        System.out.println("0 - Encerrar o programa;");
        System.out.print("->");
        
    }
}
