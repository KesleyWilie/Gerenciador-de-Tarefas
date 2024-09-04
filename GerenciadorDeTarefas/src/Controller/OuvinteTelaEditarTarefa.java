package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.TarefaDAO;
import Model.Prioridade;
import Model.TarefaDTO;
import View.ObservadorTarefa;
import View.TelaEditarTarefa;
import View.TelaGerenciadorDeTarefas;

public class OuvinteTelaEditarTarefa implements ActionListener{

	private TelaEditarTarefa tela;
	
	private TarefaDAO tarefaDAO = TarefaDAO.getTarefaDAO();

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
				TarefaDTO tarefaEditada = tela.getTarefa();
				tarefaEditada.setTitulo(tituloTarefa);
				tarefaEditada.setDescricao(descricaoTarefa);
				tarefaEditada.setPrioridade(Prioridade.valueOf(prioridadeTarefa));
				//Atualizar a tarefa no banco
				ObservadorTarefa observador = new ObservadorTarefa(tarefaEditada);
				tarefaDAO.adicionarObservador("atualizada", observador);
				tarefaDAO.atualizarTarefa(tarefaEditada);
				
				
				tela.dispose();
				
				
			}
			
		} else if(componente == tela.getBotaoCancelar()){
			tela.dispose();
			new TelaGerenciadorDeTarefas("Tarefas", "");
		}
		
		
		
		
	}

}
