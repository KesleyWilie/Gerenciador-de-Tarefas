package Observer;

import Model.TarefaDTO;

public interface Observador {
    void atualizar(TarefaDTO tarefa);
}
