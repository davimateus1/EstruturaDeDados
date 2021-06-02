package atividadeavaliativa.questao1;

public class Queue<T> {

    private QueueNode<T> inicio;
    private QueueNode<T> fim;
    private int limite;
    private int qtd;

    public Queue(int limite) {
        this.limite = limite;
    }

    public boolean isEmpty() { // está vazia
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() { // está cheia
        if (qtd == limite ) {
            return true;
        }else{
            return false;
        }
    }

    public T head() { //
        return inicio.getInfo(); 
    }

    public void enqueue(T valor) { // insere no final
        QueueNode<T> novo = new QueueNode(valor);
        if (isEmpty() == true) {
            inicio = novo;
            fim = novo;
            qtd++;
        } else {
            fim.setProx(novo);
            fim = novo;
            qtd++;
        }
    }

    public T dequeue() { // remove o primeiro
        QueueNode<T> aux = inicio;
        if (inicio == fim) {
            inicio = null;
            fim = null;
            qtd--;
        } else {
            inicio = inicio.getProx();
            qtd--;
        }
        return aux.getInfo();
    }
}
