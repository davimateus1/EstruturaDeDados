package br.unicap.ed2.avl;



public class NoAVL {
  
	private NoAVL esquerda;
	private NoAVL direita;
	private NoAVL pai;
	private int chave;
	private int balanceamento;

	public NoAVL(int k) {
		setEsquerda(setDireita(setPai(null)));
		setBalanceamento(0);
		setChave(k);
	}
	

	public String toString() {
		return Integer.toString(getChave());
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public int getBalanceamento() {
		return balanceamento;
	}

	public void setBalanceamento(int balanceamento) {
		this.balanceamento = balanceamento;
	}

	public NoAVL getPai() {
		return pai;
	}

	public NoAVL setPai(NoAVL pai) {
		this.pai = pai;
		return pai;
	}

	public NoAVL getDireita() {
		return direita;
	}

	public NoAVL setDireita(NoAVL direita) {
		this.direita = direita;
		return direita;
	}

	public NoAVL getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NoAVL esquerda) {
		this.esquerda = esquerda;
	}
}
