package br.unicap.ed2.pv;



public class ArvorePV  {
    protected NoPV raiz;

    //public ArvorePV() {
    //    this.raiz = null;
    //}

    // @Override
    // public NoPV novoNode(int key) {
    // Altera
    // return new NoPV(key);
    // }
    public boolean ehRaiz(int i) {
        if (raiz == null) {
            return false;
        }
        return raiz.getChave() == i;
    }

    public void inserir(int key) {
        NoPV n = new NoPV(key);
        inserirNoPv(this.raiz, n);
        // Altera
    }

    public void inserirNoPv(NoPV raiz, NoPV chave) {
        if (this.raiz == null) {

            this.raiz = chave;
            this.raiz.setPai(this.raiz);
            primogenito(this.raiz);

        } else if (chave.getChave() < raiz.getChave()) {

            if (raiz.getEsquerda() != null) {
                inserirNoPv(raiz.getEsquerda(), chave);
            } else {

                raiz.setEsquerda(chave);
                raiz.getEsquerda().setPai(raiz);
                primogenito(raiz.getEsquerda());
            }
        } else if (chave.getChave() > raiz.getChave()) {
            if (raiz.getDireita() != null) {
                inserirNoPv(raiz.getDireita(), chave);
            } else {
                raiz.setDireita(chave);
                raiz.getDireita().setPai(raiz);
                primogenito(raiz.getDireita());
            }
        }
    }

    private void primogenito(NoPV raiz) {
        if (raiz == this.raiz) {
            raiz.setCor(false);
        } else {
            segundoCaso(raiz);
        }
    }

    private void segundoCaso(NoPV raiz) {
        if (!(raiz.getPai().getCor())) {
            //Se o pai for preto não faz nada
        } else {
            terceiroCaso(raiz);
        }

    }

    private void terceiroCaso(NoPV raiz) {
        NoPV t = tio(raiz);
        NoPV v = raiz.getPai().getPai(); // famoso veio
        NoPV p = raiz.getPai();
        if (t != null && t.getCor()) { // tio vermelho e diferente de null
            t.setCor(false);
            p.setCor(false);
            v.setCor(true);
            primogenito(v); // Volta para o primeiro caso passando o avô, o qual ficará desbalanceado
        } else {
            quartoCaso(raiz);
        }
    }

    private void quartoCaso(NoPV raiz) {
        NoPV p = raiz.getPai();
        NoPV v = raiz.getPai().getPai();
        if (p.getDireita() == raiz && v.getEsquerda() == p) {
            rotacaoRR(raiz);
        } else if (p.getEsquerda() == raiz && v.getEsquerda() == p) {
            rotacaoLL(raiz);
        }
        quintoCaso(raiz);
    }

    private void quintoCaso(NoPV raiz) {
        NoPV p = raiz.getPai();
        raiz.setCor(false);
        p.setCor(true);

        if (p.getEsquerda() == raiz) {
            if (p.getDireita() != null) {
                p.getDireita().setCor(false);
            }
            rotacaoLL(raiz);
        } else {
            if (p.getEsquerda() != null) {
                p.getEsquerda().setCor(false);

            }
            rotacaoRR(raiz);
        }
    }

    private NoPV tio(NoPV raiz) { // Função para pegar o tio da raiz
        NoPV tio = null;

        if (raiz.getPai().getPai().getEsquerda() != null && raiz.getPai().getPai().getEsquerda() != raiz.getPai()) {
            tio = raiz.getPai().getPai().getEsquerda();
        } else if (raiz.getPai().getPai().getDireita() != null
                && raiz.getPai().getPai().getDireita() != raiz.getPai()) {
            tio = raiz.getPai().getPai().getDireita();
        }

        return tio;
    }

    private void rotacaoRR(NoPV raiz) {
        NoPV p = raiz.getPai();
        NoPV v = raiz.getPai().getPai();
        if (p == v.getEsquerda()) {
            v.setEsquerda(raiz);
        } else {
            v.setDireita(raiz);
        }

        p.setDireita(raiz.getEsquerda());

        if (raiz.getEsquerda() != null) {
            raiz.getEsquerda().setPai(raiz.getPai());
        }
        raiz.setEsquerda(p);
        raiz.setPai(v);
        p.setPai(raiz);
    }

    private void rotacaoLL(NoPV raiz) {
        if(raiz.getPai() ==  raiz.getPai().getPai().getEsquerda()){
            raiz.getPai().getPai().setEsquerda(raiz);
        }
        else{
            raiz.getPai().getPai().setDireita(raiz);
        }
        raiz.getPai().setEsquerda(raiz.getDireita());
        if(raiz.getDireita() != null){
            raiz.getDireita().setPai(raiz.getPai());
        }
        raiz.setDireita(raiz.getPai());
        raiz.setPai(raiz.getPai().getPai());
        raiz.getPai().setPai(raiz);
    }

    // @Override
    public NoPV procurar(int key) {
        return procurarPV(raiz, key);
    }

    private NoPV procurarPV(NoPV raiz, int chave) {

        if (raiz == null) {
            return null;
        }
        if (chave < raiz.getChave()) {
            return procurarPV(raiz.getEsquerda(), chave);
        } else if (chave > raiz.getChave()) {
            return procurarPV(raiz.getDireita(), chave);
        } else {
           // NoPV node = new NoPV(raiz.getChave());
            return raiz;
        }
    }

    // @Override
    public void deletar(int key) {
        NoPV n = new NoPV(key);
        deletarNoPV(raiz, n);
        // alteracao
    }

    private NoPV deletarNoPV(NoPV raiz2, NoPV chave) {
        if (raiz == null) {

        } else {
            if (chave.getChave() > raiz.getChave()) {
                raiz.setDireita(deletarNoPV(raiz.getDireita(), chave));
            } else if (chave.getChave() < raiz.getChave()) {
                raiz.setEsquerda(deletarNoPV(raiz.getEsquerda(), chave));
            } else {
                NoPV sucessor;
                if (raiz.getChave() < this.raiz.getChave()) {
                    sucessor = sucessor(this.raiz.getEsquerda());
                } else {
                    sucessor = sucessor(this.raiz.getDireita());
                }
                if (raiz.getDireita() == null && raiz.getEsquerda() == null) {
                    return null;
                }

                else if (raiz.getDireita() != null && raiz.getEsquerda() == null) {
                    primeiroCasoDel(raiz, sucessor);
                    raiz = raiz.getDireita();
                }

                else if (raiz.getDireita() == null && raiz.getEsquerda() != null) {
                    primeiroCasoDel(raiz, sucessor);
                    raiz = raiz.getEsquerda();
                }

                else {
                    raiz.setChave(sucessor.getChave());
                    primeiroCasoDel(raiz, sucessor);
                    if (raiz.getChave() < this.raiz.getChave()) {
                        NoPV n = new NoPV(sucessor.getChave());
                        deletarNoPV(raiz.getEsquerda(), n);
                    } else {
                        NoPV n = new NoPV(sucessor.getChave());
                        deletarNoPV(raiz.getDireita(), n);
                    }
                }

            }

        }
        return raiz;

    }

    private NoPV sucessor(NoPV raiz) { // Função para pegar o menor valor a direita da raiz
        while (raiz != null && raiz.getEsquerda() != null) {
            raiz = raiz.getEsquerda();
        }
        return raiz;
    }

    private void primeiroCasoDel(NoPV raiz, NoPV sucessor) {
        if (raiz.getCor() && sucessor.getCor()) {
            // primerio
        } else {
            segundoCasoDel(raiz, sucessor);
        }
    }

    private void segundoCasoDel(NoPV raiz, NoPV sucessor) {
        if (!(raiz.getCor()) && sucessor.getCor()) {
            sucessor.setCor(false);
        } else {
            terceiroCasoDel(raiz, sucessor);
        }

    }

    private void terceiroCasoDel(NoPV raiz, NoPV sucessor) {
        if (!(raiz.getCor()) && !(sucessor.getCor())) {
            NoPV aux = achaFilho(sucessor);
            NoPV w = tio(aux);
            if (w.getCor()) {
                w.setCor(!w.getCor());
                aux.getPai().setCor(!aux.getPai().getCor());
                rotacaoRR(aux.getPai());
            }

            if (!(w.getCor()) && !(w.getDireita().getCor()) && !(w.getEsquerda().getCor())) {
                w.setCor(true);
                aux = aux.getPai();
            }

            if (!(w.getCor()) && w.getEsquerda().getCor() && !(w.getDireita().getCor())) {
                w.setCor(!w.getCor());
                w.getEsquerda().setCor(!w.getEsquerda().getCor());
                rotacaoLL(w);
            }
            if (!(w.getCor()) && w.getDireita().getCor()) {
                rotacaoLL(aux.getPai());
                w.setCor(aux.getPai().getCor());
                aux.setCor(false);
                w.getDireita().setCor(false);
            }
        }

        else {
            quartoCasoDel(raiz, sucessor);
        }
    }

    private void quartoCasoDel(NoPV raiz, NoPV sucessor) {
        if (raiz.getCor() && !(sucessor.getCor())) {
            System.out.println("Quarto caso");
            sucessor.setCor(true);
            terceiroCasoDel(raiz, sucessor);
        }

    }

    private NoPV achaFilho(NoPV raiz) {
        NoPV filho = null;
        if (raiz == null) {
            return null;
        }
        if (raiz.getEsquerda() != null) {
            filho = raiz.getEsquerda();
        } else if (raiz.getDireita() != null) {
            filho = raiz.getDireita();
        }
        return filho;
    }
    
}