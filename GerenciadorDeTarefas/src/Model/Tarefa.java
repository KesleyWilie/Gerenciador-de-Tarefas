package Model;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private boolean concluida;

    public Tarefa(int id, String titulo, String descricao, Prioridade prioridade, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    /*public Tarefa(String titulo, String descricao, Prioridade prioridade) {
        this(0, titulo, descricao, prioridade, false);
    }*/

    // Getters e Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Prioridade getPrioridade() { return prioridade; }
    public boolean isConcluida() { return concluida; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
    public void setConcluida(boolean concluida) { this.concluida = concluida; }
}
