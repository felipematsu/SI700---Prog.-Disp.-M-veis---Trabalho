package f196698_l182237.ft.unicamp.br.trabalho.produtos;

public class Produto {
    String nome;
    String descricao;
    int foto;
    double preco;

    public Produto(String nome, String descricao, int foto, double preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
