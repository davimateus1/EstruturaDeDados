import java.util.Arrays;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] n;
		int tamanho;
		Auxiliares i = new Auxiliares();
		Algoritmos a = new Algoritmos();
		int op;
		do {
			menu();
			op = in.nextInt();
			switch (op) {
			case 1:
				System.out.print("Tamanho do vetor ->");
				tamanho = in.nextInt();
				n = new int[tamanho];
				i.inserirValores(n);
				System.out.println("ANTES DA ORDENACAO");
				System.out.println(Arrays.toString(n));
				System.out.println("APOS A ORDENACAO");
				a.insertionSort(n);
				System.out.println(Arrays.toString(n));
				break;
			case 2:
				System.out.print("Tamanho do vetor ->");
				tamanho = in.nextInt();
				n = new int[tamanho];
				i.inserirValores(n);
				System.out.println("ANTES DA ORDENACAO");
				System.out.println(Arrays.toString(n));
				System.out.println("APOS A ORDENACAO");
				a.selectionSort(n);
				System.out.println(Arrays.toString(n));
				break;
			case 3:
				System.out.print("Tamanho do vetor ->");
				tamanho = in.nextInt();
				n = new int[tamanho];
				i.inserirValores(n);
				System.out.println("ANTES DA ORDENACAO");
				System.out.println(Arrays.toString(n));
				System.out.println("APOS A ORDENACAO");
				a.mergeSort(n);
				System.out.println(Arrays.toString(n));
				break;
			case 4:
				System.out.print("Tamanho do vetor ->");
				tamanho = in.nextInt();
				n = new int[tamanho];
				i.inserirValores(n);
				System.out.println("ANTES DA ORDENACAO");
				System.out.println(Arrays.toString(n));
				System.out.println("APOS A ORDENACAO");
				a.quickSort(n, 0, n.length - 1);
				System.out.println(Arrays.toString(n));
				break;
			case 5:
				System.out.print("Tamanho do vetor ->");
				tamanho = in.nextInt();
				n = new int[tamanho];
				i.inserirValores(n);
				System.out.println("ANTES DA ORDENACAO");
				System.out.println(Arrays.toString(n));
				System.out.println("APOS A ORDENACAO");
				a.bubbleSort(n);
				System.out.println(Arrays.toString(n));
				break;
			case 6:
				System.out.print("Tamanho do vetor ->");
				tamanho = in.nextInt();
				n = new int[tamanho];
				i.inserirValores(n);
				System.out.println("ANTES DA ORDENACAO");
				System.out.println(Arrays.toString(n));
				System.out.println("APOS A ORDENACAO");
				a.shellSort(n);
				System.out.println(Arrays.toString(n));
				break;
			case 7:
				System.out.print("Tamanho do vetor ->");
				tamanho = in.nextInt();
				n = new int[tamanho];
				i.inserirValores(n);
				System.out.println("ANTES DA ORDENACAO");
				System.out.println(Arrays.toString(n));
				System.out.println("APOS A ORDENACAO");
				a.heapSort(n);
				System.out.println(Arrays.toString(n));
				break;
			case 0:
				System.out.println("ENCERRANDO...");

			}
		} while (op != 0);
	}

	public static void menu() {
		System.out.println("MENU");
		System.out.println("1 - INSERTION SORT");
		System.out.println("2 - SELECTION SORT");
		System.out.println("3 - MERGE SORT");
		System.out.println("4 - QUICK SORT");
		System.out.println("5 - BUBBLE SORT");
		System.out.println("6 - SHELL SORT");
		System.out.println("7 - HEAP SORT");
		System.out.println("0 - ENCERRAR");

	}

}
