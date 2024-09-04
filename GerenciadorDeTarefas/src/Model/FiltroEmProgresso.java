package Model;

import java.util.List;

import DAO.TarefaDAO;

public class FiltroEmProgresso implements FiltroTarefa {
    @Override
    public List<TarefaDTO> filtrar() {
        TarefaDAO dao = new TarefaDAO();
        return dao.obterTarefasPorEstado("EM_PROGRESSO");
    }
}