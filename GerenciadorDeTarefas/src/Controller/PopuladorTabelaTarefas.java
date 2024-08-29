package Controller;

import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Model.TarefaDAO;
import Model.TarefaDTO;

public class PopuladorTabelaTarefas {

    private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane scroll;
	
	private TarefaDAO tarefaDAO = new TarefaDAO();

    public PopuladorTabelaTarefas(JTable tabela, DefaultTableModel modelo, JScrollPane scroll) {
		this.tabela = tabela;
		this.modelo = modelo;
		this.scroll = scroll;
    }

    public void popularTabelaTarefas(String prioridade) {
    	List<TarefaDTO> tarefas = tarefaDAO.listarTarefas();


        for(TarefaDTO tarefa: tarefas){
            adicionarLinhaTabelaTarefas(modelo, tarefa);
        }

        scroll.repaint();

    }

    public void adicionarLinhaTabelaTarefas(DefaultTableModel modelo, TarefaDTO tarefa){

        Object[] linha = new Object[3];
        linha[0] = tarefa.getTitulo();
        linha[1] = tarefa.getPrioridade();
        linha[2] = tarefa.isConcluida();

        modelo.addRow(linha);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < modelo.getColumnCount(); i++) {
	        tabela.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    }
    }


}
