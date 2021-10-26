package appfila;

import Questao1.Queue;
import java.util.Scanner;

public class AppFila {
/*
    Para esse tipo de atividade, o melhor a ser usado é a fila
    por conta da regra FIFO que é First in First out
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue fila = new Queue();
        int op;
        int num;
        do {
            menu();
            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Informe o número que você deseja adicionar na lista de pedidos:");
                    num = in.nextInt();
                    addPedido(fila, num);
                    break;
                case 2:
                    removePedido(fila);
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
        System.out.println("Selecione uma opção: ");
        System.out.println("1 - Adicionar número de pedido.");
        System.out.println("2 - Remover número de pedido.");
        System.out.println("0 - Encerrar programa;");
        System.err.print("->");
    }
    
    public static void addPedido(Queue fila, int num){
        fila.enqueue(num);
    }
    
     public static void removePedido(Queue fila){
         if (fila.isEmpty() == true) {
             System.out.println("A fila está vazia!");
         }else{
             System.out.println("O pedido que foi removido foi o pedido " + fila.head() + ".");
             fila.dequeue();
         }
    } 

}
