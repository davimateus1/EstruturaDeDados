package lseCirc;

public class LSECircular<T extends Comparable<T>> {

    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;

    public void insereFinal(T valor) {
        LSENode<T> novo;
        novo = new LSENode(valor);
        if (qtd == 0) { // Lista vazia
            prim = novo;
            ult = novo;
            ult.setProx(prim);
            qtd++;
            System.out.println("|-VALOR INSERIDO-|");
        } else {
            ult.setProx(novo);
            ult = novo;
            ult.setProx(prim);
            qtd++;
            System.out.println("|-VALOR INSERIDO-|");
        }
    }

    public void insereInicio(T valor) {
        LSENode<T> novo;
        novo = new LSENode(valor);
        if (qtd == 0) {
            prim = novo;
            ult = novo;
            ult.setProx(prim);
            qtd++;
            System.out.println("|-VALOR INSERIDO-|");
        } else {
            novo.setProx(prim); // O proximo do novo é o primeiro
            prim = novo; // O novo agora é recebe a posição do primeiro
            ult.setProx(prim);
            qtd++;
            System.out.println("|-VALOR INSERIDO-|");
        }
    }

    public void removeInicial() {
        if (qtd == 0) {
            System.err.println("-A LISTA ESTÁ VAZIA-");
        } else {
            prim = prim.getProx();
            ult.setProx(prim);
            qtd--;
            System.out.println("|-VALOR REMOVIDO-|");
        }
    }

    public void removeFinal() {
        LSENode<T> aux = prim;
        if (qtd == 0) {
            System.err.println("-A LISTA ESTÁ VAZIA-");
        } else {
            for (int i = 0; i < qtd - 1; i++) {
                aux = aux.getProx();
            }
            ult = aux;
            ult.setProx(prim);
            qtd--;
            System.out.println("|-VALOR REMOVIDO-|");
        }
    }

    public void exibirLista() {
        LSENode<T> aux;
        if (qtd == 0) {
            System.err.println("|-LISTA VAZIA-|");
        } else {
            aux = prim;
            for (int i = 0; i != qtd; i++) {
                System.out.print(aux.getInfo() + " ");
                aux = aux.getProx();
            }
        }
        System.out.println();
    }

    public void contaValores(T valor) {
        LSENode<T> aux = prim;
        int cont = 0;
        if (qtd == 0) {
            System.out.println("|-LISTA VAZIA-|");
        } else if (qtd == 1) {
            if (prim.getInfo().compareTo(valor) == 0) {
                System.out.println("O valor está presente uma vez na lista");
                return;
            } else {
                System.out.println("|-VALOR NÃO ENCONTRADO-|");
            }

        } else {
            for (int i = 0; i != qtd; i++) {
                if (aux.getInfo().compareTo(valor) == 0) {
                    cont++;
                } else {
                    aux = aux.getProx();
                }
            }
        }
        if (cont == 0) {
            System.out.println("|-VALOR NÃO ENCONTRADO-|");
        } else {
            System.out.println("Esse número foi encontrado " + cont + " vezes na lista.");
        }
    }

}
