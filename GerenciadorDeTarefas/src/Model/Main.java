package Model;

import Model.Tarefa;
import Model.TarefaDAO;
import Model.Prioridade;
import View.ObservadorTarefa;

public class Main {//testando
    public static void main(String[] args) {
        TarefaDAO tarefaDAO = new TarefaDAO();
        ObservadorTarefa observadorTarefa = new ObservadorTarefa();

        // Registrando o observador
        tarefaDAO.adicionarObservador(observadorTarefa);

        // Adicionando uma tarefa para testar
        tarefaDAO.adicionarTarefa(new Tarefa("Exemplo de Tarefa 3", "testar conexão", Prioridade.BAIXA));

        // Atualizando uma tarefa para testar
        Tarefa tarefaExistente = new Tarefa(2, "Tarefa Atualizada", "Testar atualização", Prioridade.BAIXA, true);
        tarefaDAO.atualizarTarefa(tarefaExistente);

        // Deletando uma tarefa para testar
        tarefaDAO.deletarTarefa(3);
    }
}
