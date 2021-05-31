package pilha;

public class StackNode<T> {

    private T info;
    private StackNode<T> prox;

    StackNode(T valor) {
        info = valor;
    }

    void setInfo(T valor) {
        info = valor;
    }

    void setProx(StackNode<T> novoProx) {
        prox = novoProx;
    }

    T getInfo() {
        return info;
    }

    StackNode<T> getProx() {
        return prox;
    }
}

