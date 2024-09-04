package Model;

import java.util.List;

import DAO.TarefaDAO;

public class FiltroConcluidas implements FiltroTarefa {
    @Override
    public List<TarefaDTO> filtrar() {
        TarefaDAO dao = new TarefaDAO();
        return dao.obterTarefasPorEstado("concluida");
    }
}
