package View;

import Observer.Observador;
import Model.TarefaDTO;

public class ObservadorTarefa implements Observador {

    @Override
    public void atualizar(TarefaDTO tarefaDTO) {// pode usar coisas assim pra o strategy tbm
        switch (tarefaDTO.getAcao()) {
            case "adicionada":
                System.out.println("Nova tarefa adicionada: " + tarefaDTO.getTitulo());
                // Código para atualizar a interface gráfica com a nova tarefa
                break;
            case "atualizada":
                System.out.println("Tarefa atualizada: " + tarefaDTO.getTitulo());
                // Código para atualizar a interface gráfica com as mudanças na tarefa
                break;
            case "deletada":
                System.out.println("Tarefa deletada.");
                // Código para atualizar a interface gráfica removendo a tarefa
                break;
            default:
                break;
        }
    }
}
