package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.TelaAdicionarTarefas;
import View.TelaGerenciadorDeTarefas;

public class OuvinteTelaAdicionarTarefas implements ActionListener{
    
    private TelaAdicionarTarefas tela;

    public OuvinteTelaAdicionarTarefas(TelaAdicionarTarefas tela){
        this.tela = tela;
    }

    public void actionPerformed(ActionEvent e) {
		Object componente = e.getSource();
		
		if(componente == tela.getAdicionarButton()) {
			novaTarefa();
            new TelaGerenciadorDeTarefas("Tarefas");
            tela.dispose();
            //Exibir mensagem caso a tarefa for criada
        } else if(componente == tela.getBotaoCancelar()){
            tela.dispose();
            new TelaGerenciadorDeTarefas("Tarefas");
        }
		
	}

    public void novaTarefa(){
        //Método para instanciar nova tarefa, atráves do Dto e o builder, e armazenar no BD
    }


}
