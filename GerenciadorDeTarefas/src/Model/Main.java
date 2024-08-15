package Model;

import View.ObservadorTarefa;

public class Main {//testando
    public static void main(String[] args) {
        TarefaDAO tarefaDAO = new TarefaDAO();
        ObservadorTarefa observadorTarefa = new ObservadorTarefa();

        // Registrando o observador
        tarefaDAO.adicionarObservador(observadorTarefa);

        //Adicionando uma tarefa para testar
       tarefaDAO.adicionarTarefa(new TarefaDTOBuilder()
   			.setId(3)
   			.setTitulo("Tarefa Atualizada")
   			.setDescricao("Testar atualização")
   			.setPrioridade(Prioridade.BAIXA)
   			.setConcluida(false)
   			.build());
       //new TarefaDTO(2, "Tarefa Atualizada", "Testar atualização", Prioridade.BAIXA, true));
        //Atualizando uma tarefa para testar
        //TarefaDTO tarefaExistente = new TarefaDTO(2, "Tarefa Atualizada", "Testar atualização", Prioridade.BAIXA, true);
        //tarefaDAO.atualizarTarefa(tarefaExistente);

        // Deletando uma tarefa para testar
        //tarefaExistente = new TarefaDTO();
        //tarefaExistente.setId(3);
        //tarefaDAO.deletarTarefa(tarefaExistente);
    }
}
