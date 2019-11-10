package f196698_l182237.ft.unicamp.br.trabalho.pedidos;

import f196698_l182237.ft.unicamp.br.trabalho.comprador.Comprador;
import f196698_l182237.ft.unicamp.br.trabalho.produtos.Produto;

public class Pedido {
    private Produto produto;
    private int quantidade;
    private double valorTotal;
    private boolean personalizado;
    private String frasePersonalizado = null;
    private String tamanho;
    private Comprador comprador;

    public Pedido(){
    }

    public Pedido(Produto produto, int quantidade, double valorTotal, boolean personalizado, String frasePersonalizado, String tamanho, Comprador comprador) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.personalizado = personalizado;
        this.frasePersonalizado = frasePersonalizado;
        this.tamanho = tamanho;
        this.comprador = comprador;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isPersonalizado() {
        return personalizado;
    }

    public void setPersonalizado(boolean personalizado) {
        this.personalizado = personalizado;
    }

    public String getFrasePersonalizado() {
        return frasePersonalizado;
    }

    public void setFrasePersonalizado(String frasePersonalizado) {
        this.frasePersonalizado = frasePersonalizado;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
}
