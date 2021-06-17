package abbatividade.ABB;

class ABBNode<T extends Comparable<T>> {

    private T info;
    private ABBNode<T> esq;
    private ABBNode<T> dir;

    ABBNode(T valor) {
        info = valor;
    }

    void setInfo(T valor) {
        info = valor;
    }

    T getInfo() {
        return info;
    }

    void setEsq(ABBNode<T> novaEsq) {
        esq = novaEsq;
    }

    ABBNode<T> getEsq() {
        return esq;
    }

    void setDir(ABBNode<T> novaDir) {
        dir = novaDir;
    }

    ABBNode<T> getDir() {
        return dir;
    }

    void inserirNode(T value) {
        if (value.compareTo(this.getInfo()) == 0) {
            System.err.println("VALOR REPETIDO!");
        } else if (value.compareTo(this.getInfo()) < 0) {
            if (this.esq == null) {
                this.esq = new ABBNode(value);
            } else {
                this.esq.inserirNode(value);
            }
        } else {
            if (this.dir == null) {
                this.dir = new ABBNode(value);
            } else {
                this.dir.inserirNode(value);
            }
        }
    }
}

