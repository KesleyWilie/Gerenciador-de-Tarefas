package Model;

public class TarefaDTO {

	private String acao;
	private int id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private boolean concluida;

    public TarefaDTO(int id, String titulo, String descricao, Prioridade prioridade, boolean concluida) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    public TarefaDTO() {
    }

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

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
}

