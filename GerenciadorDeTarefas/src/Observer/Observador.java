package Observer;

import Model.Tarefa;

public interface Observador {
    void atualizar(Tarefa tarefa, String acao);
}
