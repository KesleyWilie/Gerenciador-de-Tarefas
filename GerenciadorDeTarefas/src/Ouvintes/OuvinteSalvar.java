package Ouvintes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.TelaGenericaTarefas;

public class OuvinteSalvar implements ActionListener{

	public OuvinteSalvar(TelaGenericaTarefas tela) {
		this.tela=tela;
	}
	private TelaGenericaTarefas tela;
	private String tituloTarefa;
	private String descricaoTarefa;
	private String prioridadeTarefa;
	@Override
	public void actionPerformed(ActionEvent clique) {
		tituloTarefa = tela.getTextoTitulo().getText();
		descricaoTarefa = tela.getTextoDescricao().getText();
		prioridadeTarefa = (String) tela.getPrioridade().getSelectedItem();
		if(tituloTarefa.equals(null) || tituloTarefa.equals("")) {
			JOptionPane.showMessageDialog(null, "Nomeie a tarefa!","Erro",JOptionPane.ERROR_MESSAGE);
		}else {
			//identificar qual a instancia de tela, para saber se é pra editar alguma ja existente ou para adicionar uma nova
			//registrar ou atualizar a tarefa no banco
			
			JOptionPane.showMessageDialog(null, "Tarefa registrada com sucesso!");
			tela.dispose();
		}
		
	}

}
