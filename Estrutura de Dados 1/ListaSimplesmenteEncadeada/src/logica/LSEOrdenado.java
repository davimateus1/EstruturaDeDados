package logica;

public class LSEOrdenado<T extends Comparable<T>> {

    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;

    public void insereOrdDecrescente(T valor) {
        LSENode<T> novo = new LSENode(valor);
        if (isEmpty() == true) { // Lista vazia
            prim = novo;
            ult = novo;
            qtd++;
        } else if (valor.compareTo(prim.getInfo()) > 0) { // Inserção no inicio da lista
            novo.setProx(prim);
            prim = novo;
            qtd++;
        } else if (valor.compareTo(ult.getInfo()) < 0) { // Inserção no final da lista
            ult.setProx(novo);
            ult = novo;
            qtd++;
        } else { // Inserção no meio da lista
            LSENode<T> aux = prim,
                    anterior = prim;
            while (aux != null) {
                if (novo.getInfo().compareTo(aux.getInfo()) == 0) { // Se o valor for repetido
                    System.err.println("-VALOR REPETIDO-");
                    return;
                } else { // Caso o valor não seja repetido
                    if (novo.getInfo().compareTo(aux.getInfo()) > 0) {
                        anterior.setProx(novo);
                        novo.setProx(aux);
                        aux = novo;
                        qtd++;
                        return;
                    } else {
                        anterior = aux;
                        aux = aux.getProx();
                    }
                }
            }
        }
    }

    public boolean isEmpty() {
        if (qtd == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void exibeDecrescente() {
        LSENode<T> aux = this.prim;
        while (aux != null) {
            System.out.print(aux.getInfo() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    public void exibeValores() {
        if (qtd == 0) {
            System.err.println("A lista está vazia!");
        } else {
            LSENode<T> auxiliar = this.prim;
            for (int i = 0; i < qtd; i++) {
                System.out.print(auxiliar.getInfo() + " ");
                auxiliar = auxiliar.getProx();
            }
            System.out.println();
        }
    }

    public void removeValor(T valor) {
        if (this.qtd == 0) {
            System.out.println("A lista está vazia!");
        } else {
            int menorQP = valor.compareTo(this.prim.getInfo());
            int maiorQP = valor.compareTo(this.ult.getInfo());
            if (menorQP < 0 || maiorQP > 0) {
                System.out.println("O valor não foi encontrado!");
                return;
            }
            int quantAnt = this.qtd;
            int valoresRemovidos;
            LSENode<T> atual, anterior;
            int valorCompPrim = valor.compareTo(this.prim.getInfo());
            int valorCompUlt = valor.compareTo(this.ult.getInfo());
            if (this.qtd == 1 || (valorCompPrim == 0 && valorCompUlt == 0)) {// comparação se os valores de toda lista são iguais, se verdadeiro, a lista se torna vazia!
                this.prim = null;
                this.ult = null;
                this.qtd = 0;
                valoresRemovidos = quantAnt - this.qtd;
                System.out.println("O valor foi removido, a lista está vazia!");
                System.out.println("Foram removidos " + valoresRemovidos + " valores.");
            } else {
                atual = this.prim;
                anterior = this.prim;
                while (atual != null) {
                    if (valor.compareTo(atual.getProx().getInfo()) == 0) {
                        int quantidadeRemocao = 1;
                        while (valor.compareTo(atual.getProx().getInfo()) == 0) { // verifica se os valores são repetidos e implementa a qtd de valores a serem removidos.
                            atual = atual.getProx();
                            quantidadeRemocao++;
                            if (atual == this.ult) { // condição da variavel atual ser igual a ultima
                                break;
                            }
                        }
                        if (atual.getInfo().compareTo(this.ult.getInfo()) == 0) { // valor de remoção igual ao ultimo.
                            anterior.setProx(null);
                            this.ult = anterior;
                            this.qtd = this.qtd - quantidadeRemocao;
                        } else if (atual.getInfo().compareTo(this.prim.getInfo()) == 0) { // valor de remoção igual ao primeiro.
                            this.ult = anterior;
                            this.qtd = this.qtd - quantidadeRemocao;
                        } else { // remoção do valor no meio da lista.
                            anterior.setProx(atual.getProx());
                            this.qtd = quantAnt - quantidadeRemocao;
                        }
                        valoresRemovidos = quantAnt - this.qtd;
                        System.out.println("O valor foi removido!");
                        System.out.println("Foram removidos " + valoresRemovidos + "valores.");
                        return;
                    } else {
                        anterior = atual;
                        atual = atual.getProx();
                    }

                }
            }

        }
    }

}
