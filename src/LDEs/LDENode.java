package LDEs;

public class LDENode<T extends Comparable<T>> {

    private LDENode<T> ant;
    private LDENode<T> prox;
    private T info;

    LDENode(T valor) {
        info = valor;
    }

    void setAnt(LDENode<T> novoAnt) {
        ant = novoAnt;
    }

    void setProx(LDENode<T> novoProx) {
        prox = novoProx;
    }

    void setInfo(T info) {
        this.info = info;
    }

    LDENode<T> getAnt() {
        return ant;
    }

    LDENode<T> getProx() {
        return prox;
    }

    T getInfo() {
        return info;
    }
}
