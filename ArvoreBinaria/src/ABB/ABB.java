package ABB;

public class ABB<T extends Comparable<T>> {

    private ABBNode<T> raiz;

    public boolean isEmpty() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insere(T valor) {
        if (this.isEmpty() == true) {
            raiz = new ABBNode(valor);
        } else {
            raiz.insereNode(valor);
        }
    }

    public void emOrdem() {
        if (this.isEmpty() == true) {
            System.err.println("ÁRVORE VAZIA!");
        } else {
            percorrerEmOrdem(raiz);
        }
    }

    private void percorrerEmOrdem(ABBNode<T> r) {
        if (r != null) {
            percorrerEmOrdem(r.getEsq());
            System.out.println(r.getInfo());
            percorrerEmOrdem(r.getDir());
        }
    }

    public T buscaNo(T valor) {
        if (this.isEmpty()) {
            return null;
        } else {
            ABBNode<T> aux = raiz;
            while (aux != null) {
                if (valor.compareTo(aux.getInfo()) == 0) {
                    return aux.getInfo();
                } else if (valor.compareTo(aux.getInfo()) < 0) {
                    aux = aux.getEsq();
                } else {
                    aux = aux.getDir();
                }
            }
            return null;
        }
    }

    public void remocao(T valor) {
        if (isEmpty()) {
            System.err.println("ÁRVORE VAZIA!");
        } else {
            raiz = removeNode(raiz, valor);
        }
    }

    private ABBNode<T> removeNode(ABBNode<T> r, T valor) {
        if (r != null) {
            if (valor.compareTo(r.getInfo()) == 0) {
                ABBNode<T> pai, filho;
                if (r.getEsq() == null && r.getDir() == null) {
                    r = null;
                } else if (r.getEsq() == null) {
                    r = r.getDir();
                } else if (r.getDir() == null) {
                    r = r.getEsq();
                } else {
                    pai = r;
                    filho = pai.getEsq();
                    while (filho.getEsq() != null) {
                        pai = filho;
                        filho = filho.getDir();
                    }
                    pai.setDir(filho.getEsq());
                    r.setInfo(filho.getInfo());
                }
            } else if (valor.compareTo(r.getInfo()) < 0) {
                r.setEsq(removeNode(r.getEsq(), valor));
            } else {
                r.setDir(removeNode(r.getDir(), valor));
            }
        }
        return r;
    }
}