package atividadeavaliativa.questao2;

public class DequeNode<T> {
    private T info;
    private DequeNode<T> prox;

    DequeNode(T valor) {
        info = valor;
    }

    void setInfo(T valor) {
        info = valor;
    }

    void setProx(DequeNode<T> novoProx) {
        prox = novoProx;
    }

    T getInfo() {
        return info;
    }

    DequeNode<T> getProx() {
        return prox;
    }
}    

