import java.util.Scanner;

public class Algoritmos {
	public void inserirValores(int[] vet) {
		Scanner in = new Scanner(System.in);
		int i;
		for (i = 0; i < vet.length; i++) {
			System.out.print("[" + i + "] = ");
			vet[i] = in.nextInt();
		}
	}

	public void insertionSort(int[] vetor) {
		int x, j;
		for (int i = 1; i < vetor.length; i++) {
			x = vetor[i];
			j = i - 1;
			while ((j >= 0 && vetor[j] > x)) {
				vetor[j + 1] = vetor[j];
				j = j - 1;
			}
			vetor[j + 1] = x;
		}
	}

	public void selectionSort(int[] v) {
		for (int i = 0; i < v.length; i++) {
			int menor = i;
			for (int j = i + 1; j < v.length; j++) {
				if (v[j] < v[menor])
					menor = j;
			}
			// trocando as posicoes
			int aux = v[i];
			v[i] = v[menor];
			v[menor] = aux;

		}
	}

	public void mergeSort(int[] v) {
		int len = v.length;
		if (len < 2) {
			return;
		}

		int mid = len / 2;
		int[] left = new int[mid];
		int[] right = new int[len - mid];
		for (int i = 0; i < mid; i++) {
			left[i] = v[i];
		}
		for (int i = mid; i < len; i++) {
			right[i - mid] = v[i];
		}
		mergeSort(left);
		mergeSort(right);

		// concatenar as duas metades
		Auxiliares aux = new Auxiliares();
		aux.merge(v, left, right);

	}

	public void quickSort(int[] v, int esq, int dir) {
		Auxiliares aux = new Auxiliares();
		if (esq < dir) {
			int j = aux.separate(v, esq, dir);
			quickSort(v, esq, j - 1);
			quickSort(v, j + 1, dir);
		}
	}

	public void bubbleSort(int[] vet) { 
		int pos = 0, i, aux;
		int fim = vet.length - 1;
		boolean troca = true;
		while (troca == true) {
			troca = false;
			for (i = 0; i < fim; i++) { // varredura
				if (vet[i] > vet[i + 1]) {
					aux = vet[i];
					vet[i] = vet[i + 1];
					vet[i + 1] = aux;
					troca = true;
					pos = i;
				}
			}
			fim = pos;
		}
	}

	public void shellSort(int[] v) {
		int i, j, h = 1, value;
		do {
			h = 3 * h + 1;
		} while (h < v.length);
		do {
			h = h / 3;
			for (i = h; i < v.length; i++) {
				value = v[i];
				j = i - h;
				while (j >= 0 && value < v[j]) {
					v[j + h] = v[j];
					j = j - h;
				}
				v[j + h] = value;
			}
		} while (h > 1);

	}

	public void heapSort(int v[]) {
         int n = v.length;
         Auxiliares aux = new Auxiliares();
        // Construção do Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
           aux.heapify(v, n, i);
        }

        // Heap Sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = v[0];
            v[0] = v[i];
            v[i] = temp;

            aux.heapify(v, i, 0);
        }
    }

    
}
