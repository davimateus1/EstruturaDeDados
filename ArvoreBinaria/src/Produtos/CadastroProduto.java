package Produtos;

import ABB.ABB;
import java.util.Scanner;

public class CadastroProduto {

    private ABB<Produto> arvore;

    public CadastroProduto() {
        arvore = new ABB();
    }
 
    public void cadastroP() {
        Scanner in = new Scanner(System.in);
        String codigo, fornecedor, descricao;
        double preco;
        int quantidade;

        System.out.println("Informe o código do produto:");
        codigo = in.next();
        System.out.println("Informe o fornecedor do produto: ");
        fornecedor = in.next();
        System.out.println("Informe a descrição do produto: ");
        descricao = in.next();
        System.out.println("Informe o preço do produto: ");
        preco = in.nextDouble();
        System.out.println("Informe a quantidade de produtos: ");
        quantidade = in.nextInt();
        Produto p = new Produto(codigo, fornecedor, descricao, preco, quantidade);
        arvore.insere(p);
        System.out.println("Produto cadastrado com sucesso!");
    }

    public void exibeInfoGeral() {
        if (arvore.isEmpty() == true) {
            System.err.println("Ainda não há produtos cadastrados!");
        } else {
            arvore.emOrdem();
        }
    }

    private Produto busca(String codigo) {
        Produto p = new Produto(codigo);
        p = arvore.buscaNo(p);
        return p;
    }

    public void alteraPreco(String codigo) {
        Scanner in = new Scanner(System.in);
        double preco;
        Produto p = busca(codigo);
        if (p == null) {
            System.err.println("Produto inexistente!");
        } else {
            System.out.println("Informe o novo preço do produto: ");
            preco = in.nextDouble();
            p.setPreco(preco);
            System.out.println("Preço alterado!");
        }
    }

    public void alteraEstoque(String codigo) {
        Scanner in = new Scanner(System.in);
        int estoque;
        Produto p = busca(codigo);
        if (p == null) {
            System.err.println("Produto inexistente!");
        } else {
            System.out.println("Informe o novo estoque do produto: ");
            estoque = in.nextInt();
            p.setQuantidade(estoque);
            System.out.println("Estoque atualizado!");
        }
    }
    
    public void exibeInfo(String codigo){
        Produto p = busca(codigo);
        if (p == null) {
            System.err.println("Produto inexistente!");
        } else {
            System.out.println(p);
        }
    }
    
    public void removeProduto(String codigo){
        Produto p = busca(codigo);
         if (p == null) {
            System.err.println("Produto inexistente!");
        } else {
            arvore.remocao(p);
             System.out.println("Produto removido!");
        }
    }
}
