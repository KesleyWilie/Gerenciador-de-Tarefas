package View;

import javax.swing.JOptionPane;

import Model.TarefaDTO;
import Observer.Observador;

public class ObservadorTarefa implements Observador {
	
	private TarefaDTO tarefa;
	
	public ObservadorTarefa(TarefaDTO tarefa) {
		this.tarefa = tarefa;
	}

    @Override
    public void atualizar() {
        switch (this.tarefa.getAcao()) {
            case "adicionada":
            	JOptionPane.showMessageDialog(null, "Nova tarefa adicionada!: " + this.tarefa.getTitulo(), "ALERTA", JOptionPane.INFORMATION_MESSAGE);
                new TelaGerenciadorDeTarefas("Tarefas", "");
                
                break;
            case "atualizada":
            	JOptionPane.showMessageDialog(null, "Tarefa atualizada!: " + this.tarefa.getTitulo(), "ALERTA", JOptionPane.INFORMATION_MESSAGE);
            	new TelaGerenciadorDeTarefas("Tarefas", "");
            	
                break;
            case "deletada":
            	JOptionPane.showMessageDialog(null, "Tarefa deletada!: " + this.tarefa.getTitulo(), "ALERTA", JOptionPane.INFORMATION_MESSAGE);
            	new TelaGerenciadorDeTarefas("Tarefas", "");
            	
                break;
            case "clonada":
            	JOptionPane.showMessageDialog(null, "Tarefa clonada!: " + this.tarefa.getTitulo(), "ALERTA", JOptionPane.INFORMATION_MESSAGE);
            	new TelaGerenciadorDeTarefas("Tarefas", "");
            	
                break;
            default:
                break;
        }
    }

	public TarefaDTO getTarefa() {
		return tarefa;
	}
    
    
}

