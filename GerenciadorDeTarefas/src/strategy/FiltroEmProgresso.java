package strategy;

import Model.TarefaDAO;
import Model.TarefaDTO;

import java.util.List;

public class FiltroEmProgresso implements FiltroTarefa {
    @Override
    public List<TarefaDTO> filtrar() {
        TarefaDAO dao = new TarefaDAO();
        return dao.obterTarefasPorEstado("EM_PROGRESSO");
    }
}