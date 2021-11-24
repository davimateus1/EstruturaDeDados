package metodos.hashing;

import lse.LSE;

public class HComTratamentoColisaoSeparado {
	public void encadeamentoSeparado(int valor, LSE[] v) {
        int pos = hash(valor, v.length);

        if (v[pos] == null) {
            LSE<Integer> novo = new LSE();
            v[pos] = novo;
            v[pos].inserirFinalComRepetidos(valor);
        } else {
            v[pos].inserirFinalComRepetidos(valor);
            
        }

    }
	
	public int hash(int valor, int tam) {
        if (tam % 2 == 0) {
            //vetor par
            return (valor % (tam + 1)) % tam;
        } else {
            //vetor impar
            return (valor % tam);
        }
    }
	
	public void insere(LSE[] v) {
		encadeamentoSeparado(5, v);
        encadeamentoSeparado(30, v);
        encadeamentoSeparado(20, v);
        encadeamentoSeparado(40, v);
        encadeamentoSeparado(10, v);
        encadeamentoSeparado(60, v);
        encadeamentoSeparado(70, v);
        encadeamentoSeparado(80, v);
        encadeamentoSeparado(90, v);
        encadeamentoSeparado(100, v);
        encadeamentoSeparado(55, v);
        exibe(v);
	}
	
	
	public void exibe(LSE[] v) {
		for(int i = 0; i < v.length; i++) {
			if(v[i] != null) {
				System.out.println("p -> " + i);
				v[i].exibirLista();
			}
		}
	}
}
