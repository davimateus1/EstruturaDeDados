package Produtos;


 class Produto implements Comparable <Produto> {
    
    private String codigo;
    private String fornecedor;
    private String descricao;
    private double preco;
    private int quantidade;

    public Produto(String codigo,String fornecedor, String descricao, double preco, int quantidade) {
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }

    public Produto (String codigo) {
        this.codigo = codigo;
    } 

    public String getCodigo() {
        return codigo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @Override
    public int compareTo(Produto p){
        return this.codigo.compareTo(p.codigo);
    }

    @Override
    public String toString() {
        return "Produto: \n"
               + " Código: " + codigo + "\n"
               + " Fornecedor: " + fornecedor + "\n"
               + " Descrição: " + descricao + "\n"
               + " Preço: " + preco + "\n"
               + " Quandidade: " + quantidade;
    }      
}
