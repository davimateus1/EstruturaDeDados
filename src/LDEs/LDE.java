package LDEs;

public class LDE<T extends Comparable<T>> {

    private LDENode<T> prim;
    private LDENode<T> ult;
    private int qtd;

    public boolean isEmpty() {
        if (qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void insereOrdenadoDecrescente(T valor) {
        LDENode<T> novo = new LDENode(valor);
        if (isEmpty() == true) { // lista vazia
            prim = novo;
            ult = novo;
            qtd = 1;
        } else if (valor.compareTo(prim.getInfo()) > 0) { // inserção no inicio 
            prim.setAnt(novo);
            novo.setProx(prim);
            prim = novo;
            qtd++;
        } else if (valor.compareTo(ult.getInfo()) < 0) { // inserção no final
            ult.setProx(novo);
            novo.setAnt(ult);
            ult = novo;
            qtd++;
        }else { // inserção no meio
            LDENode<T> aux = this.prim;
            while (aux != null) {
                if (novo.getInfo().compareTo(aux.getInfo()) == 0) { 
                    System.out.println("Valor repetido!");
                    return;
                } else { // caso o valor não seja repetido
                    if (novo.getInfo().compareTo(aux.getInfo()) > 0) {
                        aux.getAnt().setProx(novo);
                        novo.setAnt(aux.getAnt());
                        novo.setProx(aux);
                        this.qtd++;
                        return;
                    } else {
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    public void removeValor(T valor) {
        if (isEmpty() == true) {// testa se a lista está vazia
            System.out.println("Lista vazia!");
        } else if (qtd == 1) {
            LDENode<T> elemento = new LDENode(valor);
            if (prim.getInfo().compareTo(elemento.getInfo()) == 0) { // verifica se são iguais para remoção
                prim = null;
                ult = null;
                qtd = 0;
                System.out.println("Valor removido, agora a lista está vazia!");
            } else { // se não tiver na lista
                System.out.println("Valor não encontrado!");
            }
        } else { // caso geral, qtd maior que 1
            LDENode<T> novo = buscarValor(valor); // buscando esse novo na lista
            if (novo != null) {
                if (prim.getInfo().compareTo(novo.getInfo()) == 0) { // se for o primeiro da lista
                    prim = prim.getProx();
                    prim.setAnt(null);
                    qtd--;
                } else if (ult.getInfo().compareTo(novo.getInfo()) == 0) { // se for o ultimo
                    ult = ult.getAnt();
                    ult.setProx(null);
                    qtd--;
                } else {
                    novo.getAnt().setProx(novo.getProx());
                    novo.getProx().setAnt(novo.getAnt());
                    qtd--;
                }
                System.out.println("Valor removido!");
            } else {
                System.out.println("Valor não encontrado!");
            }
        }
    }

    private LDENode<T> buscarValor(T valor) {
        LDENode<T> val = new LDENode(valor);
        LDENode<T> aux = this.prim;
        if (isEmpty() == true) {
            return null;
        } else {
            while (aux != null) {
                if (val.getInfo().compareTo(aux.getInfo()) == 0) {
                    return aux;
                } else {
                    aux = aux.getProx();
                }
            }
            return null;
        }
    }

    public void exibeDecrescente() {
        LDENode<T> aux = this.prim;
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    public void exibeCrescente() {
        LDENode<T> aux = this.ult;
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getAnt();
        }
        System.out.println();
    }

    public void exibeInformacoes(T valor) {
        LDENode<T> novo = buscarValor(valor);
        if (novo != null) {
            System.out.println(novo.getInfo());
        } else {
            System.out.println("Valor não encontrado!");
        }
    }

}
