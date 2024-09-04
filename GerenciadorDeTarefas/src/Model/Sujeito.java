package Model;

public interface Sujeito {
    void adicionarObservador(String acao, Observador observador);
    void removerObservador(Observador observador);
    void notificarObservadores(TarefaDTO tarefaDTO);
}
