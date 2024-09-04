package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import DAO.TarefaDAO;
import Model.Prioridade;
import Model.TarefaDTO;
import Model.TarefaDTOBuilder;
import View.ObservadorTarefa;
import View.TelaAdicionarTarefas;
import View.TelaGerenciadorDeTarefas;

public class OuvinteTelaAdicionarTarefas implements ActionListener{
    
    private TelaAdicionarTarefas tela;
    
    private TarefaDTO tarefa = null;
    
    private TarefaDAO tarefaDAO = TarefaDAO.getTarefaDAO();
    

    public OuvinteTelaAdicionarTarefas(TelaAdicionarTarefas tela){
        this.tela = tela;
    }

    public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		
		if(componente == tela.getAdicionarButton()) {
			novaTarefa();
			tela.dispose();
        } else if(componente == tela.getBotaoCancelar()){
            tela.dispose();
            new TelaGerenciadorDeTarefas("Tarefas", "");
        }
		
		
	}

    private void novaTarefa(){
    	if(tela.getTextoTitulo().getText().equals("") || tela.getTextoTitulo().getText()==null) {
    		JOptionPane.showMessageDialog(null, "Adicione um título", "ERROR" , JOptionPane.ERROR_MESSAGE);
    	} else {
    		String titulo = tela.getTextoTitulo().getText();
    		String descricao = tela.getTextoDescricao().getText();
    		String prioridade = (String) tela.getPrioridade().getSelectedItem();
    		Prioridade prioridadeEnum = Prioridade.valueOf(prioridade);
    		
    		tarefa = new TarefaDTOBuilder()
    				.setTitulo(titulo)
    				.setPrioridade(prioridadeEnum)
    				.build();
    		
    		if(descricao!=null) {
    			tarefa.setDescricao(descricao);
    		}
    		
    		ObservadorTarefa observador = new ObservadorTarefa(tarefa);
    		tarefaDAO.adicionarObservador("adicionada",observador);
    		tarefaDAO.adicionarTarefa(tarefa);
       	
    		
    	}
        
    }


}
