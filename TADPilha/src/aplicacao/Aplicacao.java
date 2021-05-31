package aplicacao;

import java.util.Scanner;
import java.util.Stack;


public class Aplicacao {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean ehValido = true,
                ehPalindromo = true;
        Stack pilha1 = new Stack();
        Stack pilha2 = new Stack();
        char letradaFrase;
        String frase;
        System.out.println("Informe uma frase:");
        frase = in.nextLine();
        System.out.println("Frase informada: " + frase);
        for (int i = 0; i < frase.length(); i++) {
            letradaFrase = frase.charAt(i);
            if (!Character.isLetter(letradaFrase) && !Character.isSpace(letradaFrase)) {
                ehValido = false;
            }
        }
        if (ehValido == false) {
            System.err.println("Frase inválida!");
        } else {
            for (int i = 0; i < frase.length(); i++) {
                letradaFrase = frase.charAt(i);
                if (Character.isLetter(letradaFrase)) {
                    pilha1.push(letradaFrase);
                }
            }
            for (int i = frase.length() - 1; i >= 0; i--) {
                letradaFrase = frase.charAt(i);
                if (Character.isLetter(letradaFrase)) {
                    pilha2.push(letradaFrase);
                }
            }
            while (!pilha1.isEmpty()) {
                if (pilha1.pop() != pilha2.pop()) {
                    ehPalindromo = false;
                }
            }
        }
        
        if (ehPalindromo) {
            System.out.println("A frase é considerada um Palindromo!");
        } else {
            System.err.println("A frase não é um palindromo!");
        }
    }
}
