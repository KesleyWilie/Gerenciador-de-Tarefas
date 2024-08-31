package Model;

public class Tarefa implements EstadoDaTarefa, PrototypeTarefa{
    private int id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private Estado concluida;
    
    //TODO Contrutor da Tarefa
    public Tarefa(TarefaDTO tarefa) {
    	this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.prioridade = tarefa.getPrioridade();
        this.concluida = tarefa.isConcluida();
    }

    // Getters e Setters Tarefa
    public int getId() { return id; }

	public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Prioridade getPrioridade() { return prioridade; }
    public Estado isConcluida() { return concluida; }

    public void setId(int id) {this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setPrioridade(Prioridade prioridade) { this.prioridade = prioridade; }
    public void setConcluida(Estado concluida) { this.concluida = concluida; }

    //TODO Metodo para mudar o estado da tarefa, utilizando do seu estado atual
	@Override
	public void mudarEstado() {
		if(concluida.equals(Estado.Em_Andamento)) {
			this.concluida = Estado.Concluida;
		}
		else {
			this.concluida = Estado.Em_Andamento;
		}
		
	}

	//TODO Implementação do Metodo para clonar uma tarefa
	@Override
	public PrototypeTarefa clonar(TarefaDTO tarefa) {
		return new Tarefa(tarefa);
	}
    
    
}
