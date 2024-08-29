package strategy;

import java.util.List;

import Model.TarefaDTO;

public class ContextoFiltro {
    private FiltroTarefa filtro;

    public void setFiltro(FiltroTarefa filtro) {
        this.filtro = filtro;
    }
    public List<TarefaDTO> filtrar() {
        return filtro.filtrar();
    }
}
