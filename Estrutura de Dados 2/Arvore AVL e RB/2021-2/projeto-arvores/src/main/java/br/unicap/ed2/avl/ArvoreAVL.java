package br.unicap.ed2.avl;

public class ArvoreAVL {
    protected NoAVL raiz;

    // public NoAVL novoNode(int key) {
    // Altera
    // return new NoAVL(key);
    // }

    public void inserir(int noAVL) {
        NoAVL n = new NoAVL(noAVL);
        inserirNoAVL(this.raiz, n);
    }

    public boolean ehRaiz(int i) {
        if (raiz == null){
            return false;
        }
        return raiz.getChave() == i;
    }

    public void inserirNoAVL(NoAVL a, NoAVL b) {
        if (a == null) {
            raiz = b;
        } else {
            if (b.getChave() < a.getChave()) {
                if (a.getEsquerda() == null) {
                    a.setEsquerda(b);
                    b.setPai(a);
                    balancear(a);
                } else {
                    inserirNoAVL(a.getEsquerda(), b);
                }
            } else if (b.getChave() > a.getChave()) {
                if (a.getDireita() == null) {
                    a.setDireita(b);
                    b.setPai(a);
                    balancear(a);
                } else {
                    inserirNoAVL(a.getDireita(), b);
                }
            } else {
                System.out.println("No existente!");
            }
        }
    }

    public void balancear(NoAVL no) {
        no.setBalanceamento(alturaNo(no.getDireita()) - alturaNo(no.getEsquerda()));
        int balanceamento = no.getBalanceamento();

        if (balanceamento == -2) {
            if (alturaNo(no.getEsquerda().getEsquerda()) >= alturaNo(no.getEsquerda().getDireita())) {
                no = rotacaoDireita(no);
            } else {
                no = rotacaoDuplaEsqDir(no);
            }
        } else if (balanceamento == 2) {
            if (alturaNo(no.getDireita().getDireita()) >= alturaNo(no.getDireita().getEsquerda())) {
                no = rotacaoEsquerda(no);
            } else {
                no = rotacaoDuplaDirEsq(no);
            }
        }
        if (no.getPai() != null) {
            balancear(no.getPai());
        } else {
            this.raiz = no;
        }
    }

    public NoAVL procurar(int key) {
        return procurarComBusca(raiz, key);
    }

    protected NoAVL procurarComBusca(NoAVL p, int el) {
        while (p != null) {
            /* se valor procurad == chave do nó retorna referência ao nó */
            if (el == p.getChave()) {
                return p;
            }
            /* se valor procurado < chave do nó, procurar na sub-árvore esquerda deste nó */
            else if (el < p.getChave()) {
                p = p.getEsquerda();
            }
            /* se valor procurado > chave do nó, procurar na sub-árvore direita deste nó */
            else {
                p = p.getDireita();
            }
        }
        // caso chave não foi achada, retorna null
        return null;
    }

    public void deletar(int key) {
        deletarAVL(raiz, key);
    }

    public void deletarAVL(NoAVL no, int i) {
        if (no != null) {
            if (no.getChave() > i) {
                deletarAVL(no.getEsquerda(), i);
            } else if (no.getChave() < i) {
                deletarAVL(no.getDireita(), i);
            } else if (no.getChave() == i) {
                deletarBusca(no);
            }
        } else {
            return;
        }
    }

    public void deletarBusca(NoAVL remove) {
        NoAVL no;

        if (remove.getEsquerda() == null || remove.getDireita() == null) {
            if (remove.getPai() == null) {
                raiz = null;
                remove = null;
                return;
            }
            no = remove;
        } else {
            no = sucessor(remove);
            remove.setChave(no.getChave());
        }
        NoAVL aux;
        if (no.getEsquerda() != null) {
            aux = no.getEsquerda();
        } else {
            aux = no.getDireita();
        }
        if (aux != null) {
            aux.setPai(no.getPai());
        }

        if (no.getPai() == null) {
            raiz = aux;
        } else {
            if (no == no.getPai().getEsquerda()) {
                no.getPai().setEsquerda(aux);
            } else {
                no.getPai().setDireita(aux);
            }
            balancear(no.getPai());
        }
    }

    public int alturaNo(NoAVL no) {
        if (no == null) {
            return -1;
        }
        if (no.getEsquerda() == null && no.getDireita() == null) {
            return 0;
        } else if (no.getDireita() == null) {
            return 1 + alturaNo(no.getEsquerda());
        } else if (no.getEsquerda() == null) {
            return 1 + alturaNo(no.getDireita());
        } else {
            return 1 + Math.max(alturaNo(no.getEsquerda()), alturaNo(no.getDireita()));
        }

    }

    // metodo destinado a retornar o no sucessor ao instanciado
    public NoAVL sucessor(NoAVL param) {
        if (param.getDireita() != null) {
            NoAVL param2 = param.getDireita();
            while (param2.getEsquerda() != null) {
                param2 = param2.getEsquerda();
            }
            return param2;
        } else {
            NoAVL param3 = param.getPai();
            while (param3 != null && param == param3.getDireita()) {
                param = param3;
                param3 = param.getPai();
            }
            return param3;
        }
    }

    public NoAVL rotacaoEsquerda(NoAVL noInicial) {
        NoAVL dir = noInicial.getDireita();
        dir.setPai(noInicial.getPai());

        noInicial.setDireita(dir.getEsquerda());

        if (noInicial.getDireita() != null) {
            noInicial.getDireita().setPai(noInicial);
        }

        dir.setEsquerda(noInicial);
        noInicial.setPai(dir);

        if (dir.getPai() != null) {

            if (dir.getPai().getDireita() == noInicial) {
                dir.getPai().setDireita(dir);

            } else if (dir.getPai().getEsquerda() == noInicial) {
                dir.getPai().setEsquerda(dir);
            }
        }

        setBalanceamento(noInicial);
        setBalanceamento(dir);

        return dir;
    }

    public NoAVL rotacaoDireita(NoAVL noInicial) {
        NoAVL esq = noInicial.getEsquerda();
        esq.setPai(noInicial.getPai());

        noInicial.setEsquerda(esq.getDireita());

        if (noInicial.getEsquerda() != null) {
            noInicial.getEsquerda().setPai(noInicial);
        }

        esq.setDireita(noInicial);
        noInicial.setPai(esq);

        if (esq.getPai() != null) {

            if (esq.getPai().getDireita() == noInicial) {
                esq.getPai().setDireita(esq);

            } else if (esq.getPai().getEsquerda() == noInicial) {
                esq.getPai().setEsquerda(esq);
            }
        }

        setBalanceamento(noInicial);
        setBalanceamento(esq);

        return esq;
    }

    public NoAVL rotacaoDuplaEsqDir(NoAVL noInicial) {
        noInicial.setEsquerda(rotacaoEsquerda(noInicial.getEsquerda()));
        return rotacaoDireita(noInicial);
    }

    public NoAVL rotacaoDuplaDirEsq(NoAVL noInicial) {
        noInicial.setDireita(rotacaoDireita(noInicial.getDireita()));
        return rotacaoEsquerda(noInicial);
    }

    private void setBalanceamento(NoAVL no) {
        no.setBalanceamento(alturaNo(no.getDireita()) - alturaNo(no.getEsquerda()));
    }

}