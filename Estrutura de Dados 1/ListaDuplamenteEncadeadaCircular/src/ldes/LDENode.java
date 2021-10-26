package ldes;

public class LDENode <T extends Comparable <T>> {

    private T info;
    private LDENode<T> prox;
    private LDENode<T> ant;

    LDENode(T info) { 
        this.info = info;
    }

    void setInfo(T info) {
        this.info = info;
    }

    void setProx(LDENode<T> prox) {
        this.prox = prox;
    }

    T getInfo() {
        return this.info;
    }

    LDENode<T> getProx() {
        return this.prox;
    }

    LDENode<T> getAnt() {
        return this.ant;
    }

    void setAnt(LDENode<T> ant) {
        this.ant = ant;
    }

}
