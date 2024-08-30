package Controller;

import java.util.List;

import javax.swing.table.DefaultTableCellRenderer;

import Model.TarefaDAO;
import Model.TarefaDTO;
import View.TelaGerenciadorDeTarefas;

public class PopuladorTabelaTarefas {
	
	private TelaGerenciadorDeTarefas tela;

	private TarefaDAO tarefaDAO = TarefaDAO.getTarefaDAO();
	
	private static List<TarefaDTO> tarefasAtuais = null;

    public PopuladorTabelaTarefas(TelaGerenciadorDeTarefas tela) {
    	this.tela = tela;
    }

    public void popularTabelaTarefas(String prioridade) {
    	
    	if(prioridade.equalsIgnoreCase("TODOS") || prioridade.equalsIgnoreCase("")) {
    		tarefasAtuais = tarefaDAO.listarTarefas();
    	} else {
    		tarefasAtuais = tarefaDAO.obterTarefasPorPrioridade(prioridade);
    	}


        for(TarefaDTO tarefa: tarefasAtuais){
            adicionarLinhaTabelaTarefas(tarefa);
        }

        tela.getPainelTabela().repaint();

    }

    public void adicionarLinhaTabelaTarefas(TarefaDTO tarefa){

        Object[] linha = new Object[3];
        linha[0] = tarefa.getTitulo();
        linha[1] = tarefa.getPrioridade();
        linha[2] = tarefa.isConcluida();

        tela.getModelo().addRow(linha);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < tela.getModelo().getColumnCount(); i++) {
	        tela.getTabela().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    }
    }

	public static List<TarefaDTO> getTarefasAtuais() {
		return tarefasAtuais;
	}
    
    


}
