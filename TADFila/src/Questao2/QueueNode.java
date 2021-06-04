package Questao2;

public class QueueNode<T> {

    private T info;
    private QueueNode<T> prox;

    QueueNode(T valor) {
        info = valor;
    }

    void setInfo(T valor) {
        info = valor;
    }

    void setProx(QueueNode<T> novoProx) {
        prox = novoProx;
    }

    T getInfo() {
        return info;
    }

    QueueNode<T> getProx() {
        return prox;
    }
}

