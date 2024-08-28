package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Tarefa;
import View.TelaAdicionarTarefas;
import View.TelaEditarTarefa;
import View.TelaGerenciadorDeTarefas;
import View.TelaVisualizarTarefa;

public class OuvinteTelaGerenciadorDeTarefas implements ActionListener{

    private TelaGerenciadorDeTarefas tela;

    public OuvinteTelaGerenciadorDeTarefas(TelaGerenciadorDeTarefas tela){
        this.tela = tela;
    }

    public void actionPerformed(ActionEvent e) {

        Object componente = e.getSource();

        if(componente == tela.getBotaoAdicionar()){
            new TelaAdicionarTarefas("Nova Tarefa");
            tela.dispose();
        
        } else if(componente == tela.getBotaoRemover()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Implementar a remoção da tarefa
            }
        
        } else if(componente == tela.getBotaoClonar()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Implementar a clonagem da tarefa
            }
        
        } else if(componente == tela.getBotaoDetalhar()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Exemplo
                Tarefa tarefa = RecuperarDoBanco(tela.getTabela().getSelectedRow());
                new TelaVisualizarTarefa("Tarefa", tarefa);
                tela.dispose();
            }
        
        } else if(componente == tela.getBotaoEditar()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Basicamente o mesmo de cima
                new TelaEditarTarefa("Editar", null);
                tela.dispose();
            }
        
        } else if(componente == tela.getBotaoConcluir()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Quando concluir mudar o estado da tarefa, e cor da linha na tabela

                JOptionPane.showMessageDialog(null,
                        "Tarefa concluída!"
                        );
            }
        
        } 
    
    }

}
