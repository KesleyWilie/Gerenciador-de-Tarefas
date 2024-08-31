package Model;

public class TarefaDTO {

	private String acao;
	private int id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private Estado concluida;

    //construtor da TarefaDTO
    public TarefaDTO(TarefaDTOBuilder builder) {
        this.id = builder.getId();
        this.titulo = builder.getTitulo();
        this.descricao = builder.getDescricao();
        this.prioridade = builder.getPrioridade();
        this.concluida = builder.isConcluida();
    }
    
    // Getters e Setters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Prioridade getPrioridade() { return prioridade; }
    public Estado isConcluida() { return concluida; }

    public void setId(int id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
    public void setConcluida(Estado concluida) { this.concluida = concluida; }

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}
}

