package Observer;

import Model.Tarefa;

public interface Sujeito {
    void adicionarObservador(Observador observador);
    void removerObservador(Observador observador);
    void notificarObservadores(Tarefa tarefa, String acao);
}
