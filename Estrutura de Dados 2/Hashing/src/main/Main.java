package main;

import java.util.Scanner;

import lse.LSE;
import metodos.hashing.InsereInterface;
import metodos.hashing.HComTratamentoColisaoAberto;
import metodos.hashing.HComTratamentoColisaoCoalesivo;
import metodos.hashing.HComTratamentoColisaoSeparado;
import metodos.hashing.HSemTratamentoColisao;

/*
    1. Hashing pelo resto da divis�o usando n�meros primos (sem tratamento de colis�o)
	2. Hashing pelo resto da divis�o com tratamento de colis�o por endere�amento ABERTO.
	3. Hashing pelo resto da divis�o com tratamento de colis�o por encadeamento (separado)
	4. Hashing pelo resto da divis�o com tratamento de colis�o por encadeamento (coalesivo) com por�o (por�o de tamanho)

 */

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int [] v1 = new int [100];
		LSE [] v2 = new LSE[100];
		InsereInterface h = new HSemTratamentoColisao();
		InsereInterface h2 = new HComTratamentoColisaoAberto();
		HComTratamentoColisaoSeparado h3 = new HComTratamentoColisaoSeparado();
		InsereInterface h4 = new HComTratamentoColisaoCoalesivo();
		int op;
		do {
			menu();
			op = in.nextInt();
			switch(op) {
			case 1:
				h.insere(v1);
				break;
			case 2:
				h2.insere(v1);
				break;
			case 3:
				h3.insere(v2);
				break;
			case 4:
				h4.insere(v1);
				break;
			case 0:
				System.out.println("Encerrando...");
				break;			
			}
		}while (op != 0);			
	}
	
	public static void menu() {
		System.out.println("----------------------------TESTES------------------------------------------------");
		System.out.println("1. Hashing pelo resto da divisão usando números primos (sem tratamento de colisão)");
		System.out.println("2. Hashing pelo resto da divisão com tratamento de colisão por endereçamento ABERTO.");
		System.out.println("3. Hashing pelo resto da divisão com tratamento de colisão por encadeamento (separado)");
		System.out.println("4. Hashing pelo resto da divisão com tratamento de colisão por encadeamento (coalesivo)");
		System.out.println("0. Encerrar");
	}

}
