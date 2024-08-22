package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.TelaAdicionarTarefas;

public class OuvinteAdicionar implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		new TelaAdicionarTarefas("Adicionar Tarefa");
		
	}

}
