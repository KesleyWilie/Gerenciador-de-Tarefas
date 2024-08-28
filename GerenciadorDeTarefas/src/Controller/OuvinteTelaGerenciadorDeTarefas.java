package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import View.TelaAdicionarTarefas;
import View.TelaGerenciadorDeTarefas;

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
                //Implementar a remoção da tarefa no BD
            }
        
        } else if(componente == tela.getBotaoClonar()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Implementar a remoção da tarefa no BD
            }
        
        } else if(componente == tela.getBotaoDetalhar()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Implementar a remoção da tarefa no BD
            }
        
        } else if(componente == tela.getBotaoEditar()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Implementar a remoção da tarefa no BD
            }
        
        } else if(componente == tela.getBotaoConcluir()){

            if(tela.getTabela().getSelectedRow() == -1){
                JOptionPane.showMessageDialog(null,
                        "Selecione Alguma Tarefa!"
                        );
            } else {
                //Implementar a remoção da tarefa no BD
            }
        
        } 
    
    }

}
