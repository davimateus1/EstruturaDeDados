package metodos.hashing;

public class HSemTratamentoColisao implements InsereInterface {
	public int hash(int v, int t) {
		int r;
        if (t % 2 == 0) {
            System.out.println("Vetor PAR");
            r = (v % (t + 1)) % t;
            return r;
        } else {
            System.out.println("Vetor IMPAR");
            r = (v % t);
            return r;
        }
    }
	public void insere(int [] v) {	
		//v -> vetor sendo passado como parametro
		//p -> posicao em que o valor foi inserido
		int p = hash(1, v.length);
        v[p] = 1;
        System.out.println("p: " + p+ " v: " + v[p]);

        p = hash(3, v.length);
        v[p] = 3;
        System.out.println("p: " + p+ " v: " + v[p]);

        p = hash(5, v.length);
        v[p] = 5;
        System.out.println("p: " + p+ " v: " + v[p]);

        p = hash(20, v.length);
        v[p] = 20;
        System.out.println("p: " + p+ " v: " + v[p]);

        p = hash(9, v.length);
        v[p] = 9;
        System.out.println("p: " + p+ " v: " + v[p]);

        p = hash(0, v.length);
        v[p] = 0;
        System.out.println("p: " + p+ " v: " + v[p]);
	}
	
	
}
