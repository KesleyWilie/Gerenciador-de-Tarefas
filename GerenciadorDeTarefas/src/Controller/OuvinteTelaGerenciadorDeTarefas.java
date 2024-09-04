package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import DAO.TarefaDAO;
import Model.TarefaDTO;
import View.ObservadorTarefa;
import View.TelaAdicionarTarefas;
import View.TelaEditarTarefa;
import View.TelaGerenciadorDeTarefas;
import View.TelaVisualizarTarefa;

public class OuvinteTelaGerenciadorDeTarefas implements ActionListener, ItemListener{

    private TelaGerenciadorDeTarefas tela;
    private JComboBox<String> prioridade;
    
    private TarefaDAO tarefaDAO = TarefaDAO.getTarefaDAO();
    private List<TarefaDTO> tarefas = TarefaDAO.getTarefaDAO().listarTarefas();

    public OuvinteTelaGerenciadorDeTarefas(TelaGerenciadorDeTarefas tela, JComboBox<String> prioridade){
        this.tela = tela;
        this.prioridade = prioridade;
    }

    public void actionPerformed(ActionEvent e) {

        Object componente = e.getSource();

        if(componente == tela.getBotaoAdicionar()){
        	tela.dispose();
            new TelaAdicionarTarefas("Nova Tarefa");
            
        } else if(componente == tela.getBotaoRemover()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                int index = tela.getTabela().getSelectedRow();
                TarefaDTO tarefaRemover = tarefas.get(index);
                ObservadorTarefa observador = new ObservadorTarefa(tarefaRemover);
                tarefaDAO.adicionarObservador("deletada",observador);
                tarefaDAO.deletarTarefa(tarefaRemover);
                
                tela.dispose();
            }
        
        }else if(componente == tela.getBotaoDetalhar()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                TarefaDTO tarefa = PopuladorTabelaTarefas.getTarefasAtuais().get(tela.getTabela().getSelectedRow());
                new TelaVisualizarTarefa("Tarefa", tarefa);
                tela.dispose();
            }
        
        } else if(componente == tela.getBotaoEditar()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                TarefaDTO tarefa = PopuladorTabelaTarefas.getTarefasAtuais().get(tela.getTabela().getSelectedRow());
                new TelaEditarTarefa("Editar", tarefa);
                tela.dispose();
            }
        
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED){
            String itemSelecionado = (String) prioridade.getSelectedItem();
            tela.dispose();
            new TelaGerenciadorDeTarefas("Tarefas", itemSelecionado);   
        }
    }

}
