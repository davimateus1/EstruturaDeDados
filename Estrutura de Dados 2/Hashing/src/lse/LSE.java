package lse;

public class LSE<T> {
	 private LSENode<T> prim; 
	 private LSENode<T> ult; 
	 private int qtd;
	    
	    
	    
	public void inserirFinalComRepetidos(T info) {
        LSENode<T> novoNode = new LSENode(info); 
        if (qtd == 0) {
            this.prim = novoNode;
            this.ult = novoNode;
            qtd++;
        } else {
            this.ult.setProx(novoNode);
            this.ult = novoNode;
            qtd++;
        }
        
    }
	
	public void exibirLista() {
        if (this.qtd == 0) {
            throw new RuntimeException("Lista vazia!");
        } else {
            LSENode<T> aux;
            aux = this.prim;           
            for (int i = 0; i < this.qtd; i++) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }
            
        }
    }
}
