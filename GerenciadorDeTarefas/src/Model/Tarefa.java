package Model;

public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private Prioridade prioridade;
    private boolean concluida;
    
    public Tarefa(TarefaDTO tarefa) {
    	this.id = tarefa.getId();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.prioridade = tarefa.getPrioridade();
        this.concluida = tarefa.isConcluida();
    }

    //Usariamos esse construtor se o padrao Builder fosse aplicado na classe Tarefa.
    /*private Tarefa(TarefaBuilder builder) {
        this.id = builder.id;
        this.titulo = builder.titulo;
        this.descricao = builder.descricao;
        this.prioridade = builder.prioridade;
        this.concluida = builder.concluida;
    }*/

    /*public Tarefa(String titulo, String descricao, Prioridade prioridade) {
        this(0, titulo, descricao, prioridade, false);
    }*/

    // Getters e Setters Tarefa
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
    
    //Padrao builder na Tarefa
    /*public static class TarefaBuilder {
    	
    	private int id;
        private String titulo;
        private String descricao;
        private Prioridade prioridade;
        private boolean concluida;
        
        //Métoddos builder para definir as propriedades da Tarefa
        
        public TarefaBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public TarefaBuilder setTitulo(String titulo) {
            this.titulo = titulo;
            return this;
        }

        public TarefaBuilder setDescricao(String descricao) {
            this.descricao = descricao;
            return this;
        }

        public TarefaBuilder setPrioridade(Prioridade prioridade) {
            this.prioridade = prioridade;
            return this;
        }

        public TarefaBuilder setConcluida(boolean concluida) {
            this.concluida = concluida;
            return this;
        }

        // Método build para criar a instância de Tarefa
        public Tarefa build() {
            return new Tarefa(this);
        }

    }*/

    
}
