package Model;

import Observer.Observador;
import Observer.Sujeito;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements Sujeito {
    private Connection conexao;// Connexão com o banco de dados
    private List<Observador> observadores;

    public TarefaDAO() {
        this.conexao = ConexaoBancoDados.getInstancia().getConexao();
        this.observadores = new ArrayList<>();
    }
    // IMPLEMENTAÇÃO DO PADRÃO OBSERVER
    // IMPORTANTE!  notificar na GUI
    // Implementação dos métodos da interface Sujeito
    @Override
    public void adicionarObservador(Observador observador) {
        observadores.add(observador); // Adiciona um observador à lista de observadores.
    }

    @Override
    public void removerObservador(Observador observador) {
        observadores.remove(observador); //Remove um observador da lista.
    }

    @Override
    public void notificarObservadores(TarefaDTO tarefaDTO) {
        for (Observador observador : observadores) {
            observador.atualizar(tarefaDTO);
            //Notifica todos os observadores sobre uma ação realizada em uma tarefa.
            //A ação pode ser, por exemplo, "adicionada", "atualizada" ou "deletada".
        }
    }

    // Método para adicionar tarefa
    public void adicionarTarefa(TarefaDTO tarefaDTO) {
    	Tarefa tarefa = new Tarefa(tarefaDTO.getId(), tarefaDTO.getTitulo(), tarefaDTO.getDescricao(), tarefaDTO.getPrioridade(), tarefaDTO.isConcluida());
        String sql = "INSERT INTO tarefas (titulo, descricao, prioridade, concluida) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {//evitar ataques de SQL injection, valores substituem ?
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getPrioridade().name());
            stmt.setBoolean(4, tarefa.isConcluida());
            stmt.executeUpdate();
            System.out.println("Tarefa adicionada com sucesso!");
            tarefaDTO.setAcao("adicionada");
            notificarObservadores(tarefaDTO); //.
        } catch (SQLException e) {
            System.out.println("Falha ao adicionar a tarefa.");
            e.printStackTrace();
        }
    }

    // Método para atualizar tarefa
    public void atualizarTarefa(TarefaDTO tarefaDTO) {
    	Tarefa tarefa = new Tarefa(tarefaDTO.getId(), tarefaDTO.getTitulo(), tarefaDTO.getDescricao(), tarefaDTO.getPrioridade(), tarefaDTO.isConcluida());
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ?, prioridade = ?, concluida = ? WHERE id = ?";
        //utilizada para atualizar os dados de uma tarefa existente, identificada por seu id.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) { //definir os novos valores da tarefa
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getPrioridade().name());
            stmt.setBoolean(4, tarefa.isConcluida());
            stmt.setInt(5, tarefa.getId());
            stmt.executeUpdate();
            System.out.println("Tarefa atualizada com sucesso!");
            tarefaDTO.setAcao("atualizada");
            notificarObservadores(tarefaDTO);
        } catch (SQLException e) {
            System.out.println("Falha ao atualizar a tarefa.");
            e.printStackTrace();
        }
    }

    // Método para deletar tarefa
    public void deletarTarefa(TarefaDTO tarefaDTO) {
    	int idDaTarefa = tarefaDTO.getId();
        String sql = "DELETE FROM tarefas WHERE id = ?";
        //deletar uma tarefa específica usando seu id.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
			stmt.setInt(1, idDaTarefa);  //Configura o id da tarefa que será deletada.
            stmt.executeUpdate();
            System.out.println("Tarefa deletada com sucesso!");
            tarefaDTO.setAcao("deletada");
            notificarObservadores(tarefaDTO);
        } catch (SQLException e) {
            System.out.println("Falha ao deletar a tarefa.");
            e.printStackTrace();
        }
    }
}


/*
  Responsabilidade: A TarefaDAO lida com todas as operações de acesso aos dados das tarefas no banco de dados. 
  Ela encapsula a lógica de interação com o banco e notifica outros componentes da aplicação sobre mudanças nos dados.
  
  Integração com o Observer: Ao implementar o padrão Observer, a TarefaDAO garante que outros componentes da aplicação 
  (por exemplo, a interface gráfica) sejam atualizados automaticamente sempre que uma tarefa é criada, atualizada ou excluída.
*/
