package pilha;

public class Stack<T> {

    private StackNode<T> topo;

    public boolean isEmpty() { // está vazia
        if (topo == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {  // está cheia
        return false;
    }

    public void push(T valor) { // empilhar
        StackNode<T> novo = new StackNode(valor);

        if (isEmpty() == true) {
            topo = novo;
        } else {
            novo.setProx(topo);
            topo = novo;
        }
    }

    public T pop() {  // desempilhar
        StackNode<T> aux = topo;
        topo = topo.getProx();
        return aux.getInfo();
    }

    public T top() { // informa o topo
        return topo.getInfo();
    }
}
