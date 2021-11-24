package metodos.hashing;

import lse.LSE;

public class HComTratamentoColisaoCoalesivo implements InsereInterface {
	public  int[] enderecamentoAberto(int val, int[] v) {
        int pos = hash(val, v.length);
        if (v[pos] == 0) {
            v[pos] = val;
            return v;
        } else {
            for (int i = pos; i < v.length; i++) {
                if (v[i] == 0) {
                    v[i] = val;
                    return v;
                }

            }
            return null;
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
	
	public void insere(int [] v) {
		int [] vAux;
		vAux = enderecamentoAberto(5, v);
		if(vAux == null) {
			throw new RuntimeException("Não foi possível inserir o novo valor");
		}else {
			v = vAux;
		}
		
		vAux = enderecamentoAberto(15, v);
		if(vAux == null) {
			throw new RuntimeException("Não foi possível inserir o novo valor");
		}else {
			v = vAux;
		}
		
		vAux = enderecamentoAberto(30, v);
		if(vAux == null) {
			throw new RuntimeException("Não foi possível inserir o novo valor");
		}else {
			v = vAux;
		}
		vAux = enderecamentoAberto(50, v);
		if(vAux == null) {
			throw new RuntimeException("Não foi possível inserir o novo valor");
		}else {
			v = vAux;
		}
		vAux = enderecamentoAberto(70, v);
		if(vAux == null) {
			throw new RuntimeException("Não foi possível inserir o novo valor");
		}else {
			v = vAux;
		}
		exibe(v);
	}


	public void exibe(int [] v) {
		for(int i = 0; i < v.length; i++) {
			System.out.println("p -> " + i  +" v -> " + v[i]);
		}
	}
	
}
