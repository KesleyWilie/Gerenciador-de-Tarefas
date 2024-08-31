package Model;

public class TarefaDTOBuilder {

	
	private String acao;
	private int id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private Estado concluida = Estado.Em_Andamento;
    
    //Metodos gets para as propriedades da TarefaDTO 
    public TarefaDTOBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public TarefaDTOBuilder setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public TarefaDTOBuilder setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public TarefaDTOBuilder setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
        return this;
    }

    public TarefaDTOBuilder setConcluida(Estado concluida) {
        this.concluida = concluida;
        return this;
    }

    // Método build para criar a instância de Tarefa
    public TarefaDTO build() {
        return new TarefaDTO(this);
    }

    //Metodos get para as propriedades da TarefaDTO
	public String getAcao() {
		return acao;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public Estado isConcluida() {
		return concluida;
	}

}
