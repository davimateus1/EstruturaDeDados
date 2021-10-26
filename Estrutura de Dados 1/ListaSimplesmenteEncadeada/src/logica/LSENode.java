package logica;


public class LSENode <T extends Comparable <T>> {
   
    private T info;
    private LSENode<T> prox;

    LSENode(T info) {
        this.info = info;
    }

    void setInfo(T newInfo) {
        this.info = newInfo;
    }

    void setProx(LSENode<T> newProx) {
        this.prox = newProx;
    }

    T getInfo() {
        return this.info;
    }
    
    LSENode<T> getProx() {
        return this.prox;
    }
    
}

