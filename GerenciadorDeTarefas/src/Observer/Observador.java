package Observer;

import Model.TarefaDTO;

public interface Observador {
    void atualizar();
    public TarefaDTO getTarefa();
}
