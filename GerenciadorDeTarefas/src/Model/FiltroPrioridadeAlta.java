package Model;

import java.util.List;

import DAO.TarefaDAO;

public class FiltroPrioridadeAlta implements FiltroTarefa {
    @Override
    public List<TarefaDTO> filtrar() {
        TarefaDAO dao = new TarefaDAO();
        return dao.obterTarefasPorPrioridade("ALTA");
    }
}