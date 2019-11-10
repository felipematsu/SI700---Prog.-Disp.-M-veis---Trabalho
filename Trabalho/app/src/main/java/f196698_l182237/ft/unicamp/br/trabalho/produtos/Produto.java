package f196698_l182237.ft.unicamp.br.trabalho.produtos;

import java.util.List;

public class Produto {
    String nome;
    String descricao;
    int foto;
    double preco;
    int id;

    public Produto(){}

    public Produto(String nome, String descricao, int foto, double preco, int id) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
        this.preco = preco;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
