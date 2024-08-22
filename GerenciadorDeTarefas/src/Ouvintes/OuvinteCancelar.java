package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.TelaGenericaTarefas;

public class OuvinteCancelar implements ActionListener {

	private TelaGenericaTarefas tela;
	
	public OuvinteCancelar(TelaGenericaTarefas tela) {
		this.tela=tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent clique) {
		tela.dispose();
	}

}
