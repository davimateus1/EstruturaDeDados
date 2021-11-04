
public class Auxiliares {
	public void inserirValores(int[] vet) {
		Scanner in = new Scanner(System.in);
		int i;
		for (i = 0; i < vet.length; i++) {
			System.out.print("[" + i + "] = ");
			vet[i] = in.nextInt();
		}
	}
	public void trocar(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
		
	}
	public int separate(int[] v, int esq, int dir) {
		int i = esq + 1;
		int j = dir;
		int pivot = v[esq];
		while(i <= j) {
			if(v[i] <= pivot) {
				i++;
			}else if(v[j] > pivot) {
				j--;
			}else if(i <= j) {
				//trocar(v,i,j);
				int aux = v[i];
				v[i] = v[j];
				v[j] = aux;
				i++;
				j--;
			}
		}
		//trocar(v,esq,j);
		int aux = v[esq];
		v[esq] = v[j];
		v[j] = aux;
		return j;
	}
	public void merge(int[] v, int [] l, int [] r) {
		int lSize = l.length;
		int rSize = r.length;
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < lSize && j < rSize) {
			if(l[i] <= r[j]) {
				v[k] = l[i];
				i++;
			}else {
				v[k] = r[j];
				j++;
			}
			k++;
		}
		while(i < lSize) {
			v[k] = l[i];
			i++;
			k++;
		}
		while(j < rSize ) {
			v[k] = r[j];
			j++;
			k++;
		}
		
	}
	public void heapify( int v[],  int n,  int i) {
        // Encontra o maior entre raiz, o filho esquerdo e o filho direito.
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && v[l] > v[largest])
            largest = l;

        if (r < n && v[r] > v[largest])
            largest = r;

        // faz a substituicao e continua empilhando caso a raiz nao seja o maior.
        if (largest != i) {
            final int swap = v[i];
            v[i] = v[largest];
            v[largest] = swap;

            heapify(v, n, largest);
        }
    }
	
}
