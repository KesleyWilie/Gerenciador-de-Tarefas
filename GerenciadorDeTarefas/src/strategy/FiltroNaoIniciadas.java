package strategy;

import java.util.List;

import Model.TarefaDAO;
import Model.TarefaDTO;

public class FiltroNaoIniciadas implements FiltroTarefa {
    @Override
    public List<TarefaDTO> filtrar() {
        TarefaDAO dao = new TarefaDAO();
        return dao.obterTarefasPorEstado("NAO_INICIADA");
    }
}