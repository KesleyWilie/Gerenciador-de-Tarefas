package Model;

import java.util.List;

import DAO.TarefaDAO;

public class FiltroPrioridadeBaixa implements FiltroTarefa {
    @Override
    public List<TarefaDTO> filtrar() {
        TarefaDAO dao = new TarefaDAO();
        return dao.obterTarefasPorPrioridade("BAIXA");
    }
}