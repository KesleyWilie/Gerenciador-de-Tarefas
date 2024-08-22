package View;

import java.awt.Font;

import javax.swing.JLabel;

public class TelaVisualizarTarefa extends TelaGenericaTarefas{

	public TelaVisualizarTarefa(String titulo) {
		super(titulo);
		addVisualizarTarefa();
		//aqui precisar setar os textos -> getTextoTitulo().setText(PARAMETRO); e assim por diante
		getTextoTitulo().setEnabled(false);
		getTextoDescricao().setEnabled(false);
		getPrioridade().setEnabled(false);
	}
	private void addVisualizarTarefa() {
		JLabel jlTarefa = new JLabel("Visualizar Tarefa");
		jlTarefa.setBounds(0,0,500,100);
		jlTarefa.setHorizontalAlignment(JLabel.CENTER);
		jlTarefa.setFont(new Font("Arial",Font.BOLD,30));
		add(jlTarefa);
	}

}
