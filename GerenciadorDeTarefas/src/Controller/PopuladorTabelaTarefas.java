package Controller;

import java.util.List;

import javax.swing.table.DefaultTableCellRenderer;

import DAO.TarefaDAO;
import Model.ContextoFiltro;
import Model.FiltroConcluidas;
import Model.FiltroEmProgresso;
import Model.FiltroNaoIniciadas;
import Model.FiltroPrioridadeAlta;
import Model.FiltroPrioridadeBaixa;
import Model.FiltroPrioridadeMedia;
import Model.FiltroTodas;
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
    	ContextoFiltro filtro = new ContextoFiltro();
    	
    	if (prioridade.equals("ALTA")) {
    		filtro.setFiltro(new FiltroPrioridadeAlta());
        } else if (prioridade.equals("MEDIA")) {
        	filtro.setFiltro(new FiltroPrioridadeMedia());
        } else if (prioridade.equals("BAIXA")) {
        	filtro.setFiltro(new FiltroPrioridadeBaixa());
        } else if (prioridade.equals("Concluida")) {
        	filtro.setFiltro(new FiltroConcluidas());
        } else if (prioridade.equals("Em_Andamento")) {
        	filtro.setFiltro(new FiltroEmProgresso());
        } else {
        	filtro.setFiltro(new FiltroTodas());
        }

    	tarefasAtuais = filtro.filtrar();

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
