package abbatividade.ABB;

import java.util.Stack;

public class ABB<T extends Comparable<T>> {

    private ABBNode<T> raiz;

    public boolean isEmpty() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void insertNRecursivo(T valor) {
        ABBNode<T> aux, novo = new ABBNode(valor);
        if (this.isEmpty() == true) {
            raiz = new ABBNode(valor);
            System.out.println("INSERÇÃO REALIZADA COM SUCESSO!");
        } else {
            aux = raiz;
            while (true) {
                if (valor.compareTo(aux.getInfo()) == 0) {
                    System.out.println("VALOR REPETIDO!");
                    return;
                } else if (valor.compareTo(aux.getInfo()) < 0) {
                    if (aux.getEsq() != null) {
                    } else {
                        aux.setEsq(novo);
                        System.out.println("INSERÇÃO FEITA A ESQUERDA!");
                        return;
                    }
                } else {
                    if (aux.getDir() != null) {
                        aux = aux.getDir();
                    } else {
                        aux.setDir(novo);
                        System.out.println("INSERÇÃO FEITA A DIREITA!");
                        return;
                    }
                }
            }
        }
    }

    public void insertNRecursivoRepetidos(T valor) {
        ABBNode<T> aux, novo = new ABBNode(valor);
        if (this.isEmpty() == true) {
            raiz = new ABBNode(valor);
            System.out.println("INSERÇÃO REALIZADA COM SUCESSO!");
        } else {
            aux = raiz;
            while (true) {
                if (valor.compareTo(aux.getInfo()) < 0) {
                    if (aux.getEsq() != null) {
                        aux = aux.getEsq();
                    } else {
                        System.out.println("INSERÇÃO FEITA A ESQUERDA!");
                        return;
                    }
                } else {
                    if (aux.getDir() != null) {
                        aux = aux.getDir();
                    } else {
                        aux.setDir(novo);
                        System.out.println("INSERÇÃO FEITA A DIREITA!");
                        return;
                    }
                }
            }
        }
    }

    public void preOrdemNRecursivo() {
        ABBNode<T> aux;
        Stack<ABBNode> pilha = new Stack();
        if (isEmpty() == true) {
             System.err.println("ÁRVORE VAZIA!");
        } else {
            aux = raiz;
            System.out.println(aux.getInfo());
            aux = raiz.getEsq();
            while (pilha.isEmpty() == false || aux != null) {
                if (aux != null) {
                    System.out.println(aux.getInfo());
                    aux = aux.getEsq();
                } else {
                    aux = pilha.pop();
                    aux = aux.getDir();
                }
            }
            aux = raiz.getDir();
            while (pilha.isEmpty() == false || aux != null) {
                if (aux != null) {
                    System.out.println(aux.getInfo());
                    pilha.push(aux);
                    aux = aux.getEsq();
                } else {
                    aux = pilha.pop();
                    aux = aux.getDir();
                }
            }
        }
    }

    public void emOrdemNRecursivo() {
        ABBNode<T> aux;
        Stack<ABBNode> pilha = new Stack();
        if (isEmpty() == true) {
           System.err.println("ÁRVORE VAZIA!");
        } else {
            aux = raiz;
            while (pilha.isEmpty() == false || aux != null) {
                if (aux != null) {
                    pilha.push(aux);
                    aux = aux.getEsq();
                } else {
                    aux = pilha.pop();
                    System.out.println(aux.getInfo());
                    aux = aux.getDir();
                }
            }
        }
    }

    public T busca(T valor) {
        ABBNode<T> aux = raiz;
        if (isEmpty()) {
            return null;
        } else {
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

    public int conta(T valor) {
        int i = 0;
        ABBNode<T> aux;
        Stack<ABBNode<T>> pilha = new Stack<>();
        if (pilha.isEmpty() == false) {
            pilha.push(raiz);
            while (pilha.isEmpty() == false) {
                aux = pilha.pop();
                if (aux.getEsq() != null) {
                    pilha.push(aux.getEsq());
                }
                if (aux.getDir() != null) {
                    pilha.push(aux.getDir());
                }
                if (valor.compareTo(aux.getInfo()) == 0) {
                    i++;
                }
            }
            return i;
        } else {
            return 0;
        }
    }
       
       public void remocao(T valor) {
        if (isEmpty()) {
            System.err.println("ÁRVORE VAZIA!");
        } else {
            raiz = removeNode(raiz, valor);
            System.out.println("VALOR REMOVIDO!");
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
