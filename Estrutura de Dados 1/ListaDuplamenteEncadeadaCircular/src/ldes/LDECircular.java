package ldes;

public class LDECircular<T extends Comparable<T>> {

    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;

    public void insereValorFinal(T valor) { //
        LDENode<T> novo;
        novo = new LDENode(valor);
        if (isEmpty() == true) {
            prim = novo;
            prim.setAnt(ult);
            ult = novo;
            ult.setProx(prim);
            qtd++;
        } else {
            ult.setProx(novo);
            novo.setAnt(ult);
            ult = novo;
            ult.setProx(prim);
            prim.setAnt(ult);
            qtd++;
        }
    }

    public void concatenarListas(LDECircular<T> lista) {
        while (lista.qtd != 0) {
            insereValorFinal(lista.prim.getInfo());
            lista.removeP();
        }
    }

    public LDECircular divideListas() {
        LDECircular lista = new LDECircular();
        int divide;
        divide = (qtd / 2) + (qtd % 2);
        LDENode<T> aux = prim, aux2 = prim;
        for (int i = 0; i < qtd; i++) { // buscando onde a lista será dividida
            if (i == divide) {
                aux2 = aux.getProx();
                aux.setProx(prim);
                ult = aux;
                prim.setAnt(ult);
                qtd = divide;
                break;
            } else {
                aux = aux.getProx();
            }
        }
        do {
            lista.insereValorFinal(aux2.getInfo());
            aux2 = aux2.getProx();
        } while (aux.getProx() != aux2);
        return lista;
    }
    
    public void exibe(){
        LDENode<T> aux = prim;
        if (isEmpty() == true) {
            System.out.println("Lista vazia!");
        }else{
            do{
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            }while(aux != prim);
            System.out.println();
        }
    }

    public void removeP() {
        if (isEmpty() == true) {
            System.out.println("Lista vazia!");
        } else if (qtd == 1) {
            prim = null;
            ult = null;
            qtd = 0;
        } else {
            prim = prim.getProx();
            ult.setProx(prim);
            prim.setProx(ult);
            qtd--;
        }
    }

    public boolean isEmpty() {
        if (qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

}
