package View;

import javax.swing.JOptionPane;

import Model.TarefaDTO;
import Observer.Observador;

public class ObservadorTarefa implements Observador {

    @Override
    public void atualizar(TarefaDTO tarefaDTO) {// pode usar coisas assim pra o strategy tbm
        switch (tarefaDTO.getAcao()) {
            case "adicionada":
            	JOptionPane.showMessageDialog(null, "Nova tarefa adicionada!: " + tarefaDTO.getTitulo(), "ALERTA", JOptionPane.INFORMATION_MESSAGE);
                new TelaGerenciadorDeTarefas("Tarefas");
                // Código para atualizar a interface gráfica com a nova tarefa
                break;
            case "atualizada":
            	JOptionPane.showMessageDialog(null, "Tarefa atualizada!: " + tarefaDTO.getTitulo(), "ALERTA", JOptionPane.INFORMATION_MESSAGE);
            	new TelaGerenciadorDeTarefas("Tarefas");
                // Código para atualizar a interface gráfica com as mudanças na tarefa
                break;
            case "deletada":
            	JOptionPane.showMessageDialog(null, "Tarefa deletada!: " + tarefaDTO.getTitulo(), "ALERTA", JOptionPane.INFORMATION_MESSAGE);
            	new TelaGerenciadorDeTarefas("Tarefas");
                // Código para atualizar a interface gráfica removendo a tarefa
                break;
            default:
                break;
        }
    }
}
