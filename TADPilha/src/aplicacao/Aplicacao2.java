package aplicacao;

import java.util.Scanner;
import java.util.Stack;


public class Aplicacao2 {

    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int num;
    int base = 2;
    Stack stack = new Stack();
        System.out.println("Informe um número para ser convertido: ");
        num = in.nextInt();
        converteBase(num, base, stack);
    }

    public static void converteBase(int num, int base, Stack stack) {
        int restoDiv;
        while (true) {
            if (num / base == 0) {
                restoDiv = num % base;
                stack.push(restoDiv);
                break;
            }
            restoDiv = num % base;
            stack.push(restoDiv);
            num = num / base;

        }
        while (!stack.isEmpty()) {
            System.out.print(stack.peek());
            stack.pop();
        }
        System.out.println();
    }
}
