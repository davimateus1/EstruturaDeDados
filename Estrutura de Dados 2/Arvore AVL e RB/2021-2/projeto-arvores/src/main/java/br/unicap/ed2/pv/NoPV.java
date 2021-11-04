package br.unicap.ed2.pv;

import br.unicap.ed2.base.No;

public class NoPV {

    private NoPV esquerda;
    private NoPV direita;
    private NoPV pai;
    private boolean cor; // True = vermelho , False = preto
    private int chave;

    

    public NoPV(int valor) {
        // super(chave);
        // fatorBalanceamento = 0;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
        this.cor = true;
        this.chave = valor;

    }

    // public int getFB() {
    // return fatorBalanceamento;
    // }
    public NoPV getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoPV esquerda) {
        this.esquerda = esquerda;
    }

    public NoPV getDireita() {
        return direita;
    }

    public void setDireita(NoPV direita) {
        this.direita = direita;
    }

    public NoPV getPai() {
        return pai;
    }

    public void setPai(NoPV pai) {
        this.pai = pai;
    }

    public boolean getCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int compareTo(NoPV key) {
        NoPV n = new NoPV(this.chave);
        return n.compareTo(key);
    }

    @Override
    public String toString() {
        return "NoPV [ chave="
                + chave + "]";
    }

    
}
