package f196698_l182237.ft.unicamp.br.trabalho.alunos;

public class Aluno {
    
    String nome;
    int foto;
    String descricao;

    public Aluno(String nome, int foto, String descricao) {
        this.nome = nome;
        this.foto = foto;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
