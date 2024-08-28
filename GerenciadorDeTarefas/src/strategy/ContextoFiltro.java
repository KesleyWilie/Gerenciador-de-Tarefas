package strategy;

import Model.TarefaDTO;

import java.util.List;

public class ContextoFiltro {
    private FiltroTarefa filtro;

    public void setFiltro(FiltroTarefa filtro) {
        this.filtro = filtro;
    }
    public List<TarefaDTO> filtrar() {
        return filtro.filtrar();
    }
}
