package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.TarefaDTO;
import View.TelaEditarTarefa;
import View.TelaGerenciadorDeTarefas;

public class OuvinteTelaEditarTarefa implements ActionListener{

	private TelaEditarTarefa tela;


	public OuvinteTelaEditarTarefa(TelaEditarTarefa tela) {
		this.tela=tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent clique) {
		Object componente = clique.getSource();
		if(componente == tela.getBotaoSalvar()){
			String tituloTarefa = tela.getTextoTitulo().getText();
			String descricaoTarefa = tela.getTextoDescricao().getText();
			String prioridadeTarefa = (String) tela.getPrioridade().getSelectedItem();
			if(tituloTarefa.equals(null) || tituloTarefa.equals("")) {
				JOptionPane.showMessageDialog(null, "Nomeie a tarefa!","Erro",JOptionPane.ERROR_MESSAGE);
			}else {
				TarefaDTO tarefa = tela.getTarefa();
				//Atualizar a tarefa no banco
				

				JOptionPane.showMessageDialog(null, "Tarefa registrada com sucesso!");
				tela.dispose();
			}
			
		} else if(componente == tela.getBotaoCancelar()){
			tela.dispose();
			new TelaGerenciadorDeTarefas("Tarefas");
		}
		
		
	}

}
