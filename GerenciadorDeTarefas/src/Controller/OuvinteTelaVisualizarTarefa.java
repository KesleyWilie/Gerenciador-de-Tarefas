package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.TarefaDAO;
import Model.TarefaDTO;
import View.ObservadorTarefa;
import View.TelaGerenciadorDeTarefas;
import View.TelaVisualizarTarefa;

public class OuvinteTelaVisualizarTarefa implements ActionListener {
	
	private TelaVisualizarTarefa tela;
	
	private TarefaDAO tarefaDAO = TarefaDAO.getTarefaDAO();
	
	public OuvinteTelaVisualizarTarefa(TelaVisualizarTarefa tela) {
		this.tela = tela;
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		TarefaDTO tarefaTela = tela.getTarefa();
		ObservadorTarefa observador = new ObservadorTarefa(tarefaTela);
		
		if(componente == tela.getBotaoVoltar()){
			tela.dispose();
			new TelaGerenciadorDeTarefas("Tarefas", "");
		
		} else if(componente == tela.getBotaoClonar()) {
            tarefaDAO.adicionarObservador("clonada",observador);
            tarefaDAO.clonarTarefa(tarefaTela);
			tela.dispose();
		
		} else if(componente == tela.getBotaoConcluir()) {
            tarefaDAO.adicionarObservador("atualizada",observador);
			tarefaDAO.alterarEstadoDaTarefa(tarefaTela);
			tela.dispose();
		}
				
	}
}
