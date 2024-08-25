package Model;

import java.util.Scanner;

import View.ObservadorTarefa;
import View.TelaAdicionarTarefas;

public class Main {//testando
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
       TarefaDAO tarefaDAO = new TarefaDAO();
       ObservadorTarefa observadorTarefa = new ObservadorTarefa();

        // Registrando o observador
       tarefaDAO.adicionarObservador(observadorTarefa);
       
       //Entrada para o controle das ações
       System.out.println("entrada!");
       int entrada = input.nextInt();
       
       //Adicionando uma tarefa para testar
       TarefaDTO tarefaDTO = new TarefaDTOBuilder()
      			.setTitulo("Tarefa teste1")
       			.setDescricao("Testar atualização1")
       			.setPrioridade(Prioridade.BAIXA)
       			.setConcluida(Estado.Andamento)
       			.build();
       
     //Entrada para o controle das ações
        System.out.println("entrada!");
       tarefaDAO.adicionarTarefa(tarefaDTO);
      
       //Adicionando uma tarefa para testar
       entrada = input.nextInt();
       tarefaDTO = new TarefaDTOBuilder()
    		   	.setTitulo("Tarefa teste2")
    		   	.setDescricao("Testar atualização2")
     			.setPrioridade(Prioridade.BAIXA)
     			.setConcluida(Estado.Concluida)
     			.build();
       
     //Entrada para o controle das ações
       System.out.println("entrada!");
       tarefaDAO.adicionarTarefa(tarefaDTO);
       
       //Adicionando uma tarefa para testar
       entrada = input.nextInt();
       tarefaDTO = new TarefaDTOBuilder()
    		   .setId(3)
    		   .setTitulo("Tarefa teste3")
    			.setDescricao("Testar atualização3")
    			.setPrioridade(Prioridade.ALTA)
    			.setConcluida(Estado.Andamento)
    			.build();
       tarefaDAO.adicionarTarefa(tarefaDTO);
       
     //Entrada para o controle das ações
       System.out.println("entrada!");
       entrada = input.nextInt();
     //Atualizar uma tarefa para testar 
       tarefaDTO = new TarefaDTOBuilder()
    		   .setId(3)
    		   .setTitulo("Tarefa teste3.1")
    			.setDescricao("Testar atualização3.1")
    			.setPrioridade(Prioridade.ALTA)
    			.setConcluida(Estado.Andamento)
    			.build();
       tarefaDAO.atualizarTarefa(tarefaDTO);
       
     //Entrada para o controle das ações
       System.out.println("entrada!");
       entrada = input.nextInt();
     //Alterando o estado de uma tarefa para testar
       tarefaDAO.alterarEstadoDaTarefa(tarefaDTO);
       
     //Entrada para o controle das ações
       System.out.println("entrada!");
       entrada = input.nextInt();
     //Clonando uma tarefa para testar
       tarefaDAO.clonarTarefa(tarefaDTO);
       
     //Entrada para o controle das ações
       System.out.println("entrada!");
       entrada = input.nextInt();
     //Deletando uma tarefa para testar
       tarefaDAO.deletarTarefa(tarefaDTO);
       
       
       //new TarefaDTO(2, "Tarefa Atualizada", "Testar atualização", Prioridade.BAIXA, true));
        //Atualizando uma tarefa para testar
        //TarefaDTO tarefaExistente = new TarefaDTO(2, "Tarefa Atualizada", "Testar atualização", Prioridade.BAIXA, true);
        //tarefaDAO.atualizarTarefa(tarefaExistente);

        // Deletando uma tarefa para testar
        //tarefaExistente = new TarefaDTO();
        //tarefaExistente.setId(3);
        //tarefaDAO.deletarTarefa(tarefaExistente);
    }
}
