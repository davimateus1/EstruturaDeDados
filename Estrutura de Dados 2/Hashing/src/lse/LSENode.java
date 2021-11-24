package lse;

class LSENode<T> {
	private T info; 
    private LSENode<T> prox; 
    
    LSENode (T valor){ 
        this.info = valor;
    }
    
    void setInfo(T valor) {
        this.info = valor;
    }
    
    void setProx(LSENode<T> prox) { 
        this.prox = prox;
    }
    
    T getInfo() { 
        return this.info;
    }
    
    LSENode<T> getProx() { 
        return this.prox;
    }
    @Override
    public String toString() {
        return "valor -> " + info;
    }
}
