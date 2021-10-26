package appfila;

import Questao2.Queue;
import java.util.Scanner;

public class AppFila2 {
/*
    Para esse tipo de atividade, o melhor a ser usado é a fila
    por conta da regra FIFO que é First in First out
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue fila = new Queue();
        int op;
        double num;
        do {
            System.out.println("José avaliações de projeto: ");
            menu();
            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Informe a nota de avaliação deste projeto: ");
                    num = in.nextDouble();
                    addProjeto(fila, num);
                    break;
                case 2:
                    removeProjeto(fila);
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
        System.out.println("1 - Adicionar projeto;");
        System.out.println("2 - Remover projeto;");
        System.out.println("0 - Encerrar programa;");
        System.err.print("->");
    }
    
    public static void addProjeto(Queue fila, double num){
        fila.enqueue(num);
    }
    
     public static void removeProjeto(Queue fila){
         if (fila.isEmpty() == true) {
             System.out.println("A fila de projetos está vazia!");
         }else{
             System.out.println("O projeto removido foi o " + fila.head() + ".");
             fila.dequeue();
         }
    } 

}