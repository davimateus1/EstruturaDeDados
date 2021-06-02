package atividadeavaliativa.questao2;

public class Deque<T> {

    private DequeNode<T> inicio;
    private DequeNode<T> fim;

    public void push(T valor) { // empilhar
        DequeNode<T> novo = new DequeNode(valor);

        if (isEmpty() == true) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProx(inicio);
            inicio = novo;
        }
    }

    public T pop() {  // desempilhar
        DequeNode<T> aux = inicio;
        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.getProx();
        }
        return aux.getInfo();
    }
    
    public void inject(T valor){
        DequeNode<T> novo = new DequeNode(valor);
        if (isEmpty() == true) {
            fim = novo;
            inicio = novo;
        }else{
            fim.setProx(novo);
            fim = novo;
        }
    }
    
    public T eject(){
        DequeNode<T> aux = fim;
        DequeNode<T> aux2 = inicio;
        if (inicio == fim) {
            inicio = null;
            fim = null;
        }else{
            while(aux2.getProx() != fim){
                aux2 = aux2.getProx();
            }
            fim = aux2;   
            fim.setProx(null);
        }
        return aux.getInfo();
    }

    public boolean isEmpty() { // está vazia
        if (inicio == null) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFull() {  // está cheia
        return false;
    }
}
