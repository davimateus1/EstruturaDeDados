package metodos.hashing;

public class HComTratamentoColisaoAberto implements InsereInterface{
	
	
	public int hash(int v, int t) {
		int r;
        if (t % 2 == 0) {
            //vetor par
            r = (v % (t + 1)) % t;
            return r;
        } else {
           //vetor impar
            r = (v % t);
            return r;
        }
    }
	
	public int[] eAberto(int valor, int[] vetor) {
        int pos = hash(valor, vetor.length);
        if (vetor[pos] == 0) {
            vetor[pos] = valor;
            return vetor;
        } else {
            for (int i = pos; i < vetor.length; i++) {
                if (vetor[i] == 0) {
                    vetor[i] = valor;
                    return vetor;
                }

            }
            return null;
        }
    }
	public void insere(int [] vetor) {	
		int [] v;
		v = eAberto(5, vetor);
        if (v == null) {
            System.out.println("Valor nao encontrado!");
        } else {
            vetor = v;
        }

        v = eAberto(7, vetor);
        if (v == null) {
            System.out.println("Valor nao encontrado!");
        } else {
            vetor = v;
        }

        v = eAberto(3, vetor);
        if (v == null) {
            System.out.println("Valor nao encontrado!");
        } else {
            vetor = v;
        }

        v = eAberto(6, vetor);
        if (v == null) {
            System.out.println("Valor nao encontrado!");
        } else {
            vetor = v;
        }

        v = eAberto(83, vetor);
        if (v == null) {
            System.out.println("Valor nao encontrado!");
        } else {
            vetor = v;
        }

        for (int i = 0; i < vetor.length; i++) {
            System.out.println("p: " + i + " v: " + vetor[i]);
        }

		
	}
	
}
