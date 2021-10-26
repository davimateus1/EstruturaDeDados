package abbatividade;

import abbatividade.ABB.ABB;
import java.util.Scanner;

public class ABBAtividade {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op;
        ABB<Integer> arvore = new ABB();
        ABB<Integer> arvoreRepetidos = new ABB();
        int num, R;

        do {
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Informe um valor para ser inserido, lembrando que pode ser repetido: ");
                    num = in.nextInt();
                    arvoreRepetidos.insertNRecursivoRepetidos(num);
                    break;
                case 2:
                    System.out.println("Informe um valor para ser inserido, lembrando que não pode ser repetido: ");
                    num = in.nextInt();
                    arvore.insertNRecursivo(num);
                    break;
                case 3:
                    System.out.println("Informe o valor não repetido que você deseja buscar: ");
                    num = in.nextInt();
                    Object N = arvore.busca(num);
                    if (N == null) {
                        System.err.println("VALOR NÃO ENCONTRADO!");
                    } else {
                        System.out.println("O valor foi encontrado: " + N + "!");
                    }
                    break;
                case 4:
                    System.out.println("Informe o valor repetido que você deseja buscar: ");
                    num = in.nextInt();
                    R = arvoreRepetidos.conta(num);
                    if (R == 0) {
                        System.err.println("VALOR NÃO ENCONTRADO!");
                    } else {
                        System.out.println("Valor encontrado! Este valor se repetiu " + R + " vezes!");
                    }
                    break;
                case 5:
                    System.out.println("========================================");
                    System.out.println("Árvore sem repetidos Pré ordem: ");
                    arvore.preOrdemNRecursivo();
                    System.out.println("========================================");
                    System.out.println("Árvore com repetidos Pré ordem: ");
                    arvoreRepetidos.preOrdemNRecursivo();
                    System.out.println("========================================");
                    break;
                case 6:
                    System.out.println("========================================");
                    System.out.println("Árvore sem repetidos em Ordem: ");
                    arvore.emOrdemNRecursivo();
                    System.out.println("========================================");
                    System.out.println("Árvore com repetidos em Ordem: ");
                    arvoreRepetidos.emOrdemNRecursivo();
                    System.out.println("========================================");
                    break;
                case 7:
                    System.out.println("Informe o valor a ser removido: ");
                    num = in.nextInt();
                    arvore.remocao(num);
                    arvoreRepetidos.remocao(num);
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.err.println("Opção inválida!");
                    break;
            }
        } while (op != 0);
    }

    public static void menu() {
        System.out.println("SELECIONE UMA OPÇÃO: ");
        System.out.println("1 - Inserir valor na árvore(Pode ser repetido);");
        System.out.println("2 - Inserir valor na árvore(Não pode ser repetido);");
        System.out.println("3 - Buscar valor não repetido;");
        System.out.println("4 - Buscar valor repetido;");
        System.out.println("5 - Exibição Pré Ordem;");
        System.out.println("6 - Exibição em Ordem;");
        System.out.println("7 - Remover da árvore;");
        System.out.println("0 - Encerrar o programa.");
        System.out.print("->");
    }
}
