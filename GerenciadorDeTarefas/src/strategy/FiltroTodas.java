package strategy;

import Model.TarefaDAO;
import Model.TarefaDTO;

import java.util.List;

public class FiltroTodas implements FiltroTarefa {
    @Override
    public List<TarefaDTO> filtrar() {
        TarefaDAO dao = new TarefaDAO();
        return dao.listarTarefas();
    }
}
