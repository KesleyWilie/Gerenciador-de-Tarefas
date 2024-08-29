package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Observer.Observador;
import Observer.Sujeito;

public class TarefaDAO implements Sujeito {
    private Connection conexao;
    private List<Observador> observadores;
    
    private static TarefaDAO tarefaDAO = new TarefaDAO();

    public TarefaDAO() {
        this.conexao = ConexaoBancoDados.getInstancia().getConexao();
        this.observadores = new ArrayList<>();
    }
    // IMPLEMENTAÇÃO DO PADRÃO OBSERVER
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
    	
    	//Se usarmos o padrao Builder na classe Tarefa ficaria desse modo:
    	/*Tarefa tarefa = new Tarefa.TarefaBuilder()
    			.setId(tarefaDTO.getId())
    			.setTitulo(tarefaDTO.getTitulo())
    			.setDescricao(tarefaDTO.getDescricao())
    			.setPrioridade(tarefaDTO.getPrioridade())
    			.setConcluida(tarefaDTO.isConcluida())
    			.build();*/
    	
    	Tarefa tarefa = new Tarefa(tarefaDTO);
    	
    	String sql = "INSERT INTO tarefas (titulo, descricao, prioridade, concluida) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {//evitar ataques de SQL injection, valores substituem ?
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getPrioridade().name());
            stmt.setString(4, tarefa.isConcluida().name());
            stmt.executeUpdate();
            tarefaDTO.setAcao("adicionada");
            notificarObservadores(tarefaDTO); //.
        } catch (SQLException e) {
            System.out.println("Falha ao adicionar a tarefa.");
            e.printStackTrace();
        }
    }

    // Método para atualizar tarefa
    public void atualizarTarefa(TarefaDTO tarefaDTO) {
    	
    	//Se usarmos o padrao Builder na classe Tarefa ficaria desse modo:
    	/*Tarefa tarefa = new Tarefa.TarefaBuilder()
    			.setId(tarefaDTO.getId())
    			.setTitulo(tarefaDTO.getTitulo())
    			.setDescricao(tarefaDTO.getDescricao())
    			.setPrioridade(tarefaDTO.getPrioridade())
    			.setConcluida(tarefaDTO.isConcluida())
    			.build();*/
    	
    	Tarefa tarefa = new Tarefa(tarefaDTO);
    	
        String sql = "UPDATE tarefas SET titulo = ?, descricao = ?, prioridade = ?, concluida = ? WHERE id = ?";
        //utilizada para atualizar os dados de uma tarefa existente, identificada por seu id.
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) { //definir os novos valores da tarefa
            stmt.setString(1, tarefa.getTitulo());
            stmt.setString(2, tarefa.getDescricao());
            stmt.setString(3, tarefa.getPrioridade().name());
            stmt.setString(4, tarefa.isConcluida().name());
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
            //System.out.println("Tarefa deletada com sucesso!");
            tarefaDTO.setAcao("deletada");
            notificarObservadores(tarefaDTO);
        } catch (SQLException e) {
            System.out.println("Falha ao deletar a tarefa.");
            e.printStackTrace();
        }
    }
    public List<TarefaDTO> listarTarefas() {
        List<TarefaDTO> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TarefaDTO tarefaDTO = new TarefaDTOBuilder()
                        .setId(rs.getInt("id"))
                        .setTitulo(rs.getString("titulo"))
                        .setDescricao(rs.getString("descricao"))
                        .setPrioridade(Prioridade.valueOf(rs.getString("prioridade")))
                        .setConcluida(Estado.valueOf(rs.getString("concluida")))
                        .build();
                tarefas.add(tarefaDTO);
            }
        } catch (SQLException e) {
            System.out.println("Falha ao listar as tarefas.");
            e.printStackTrace();
        }
        return tarefas;
    }
    
    public void alterarEstadoDaTarefa(TarefaDTO tarefaDTO) {
    	Tarefa tarefa = recuperarTarefa(tarefaDTO);
    	if(tarefa!=null) {
	    	
	    	tarefa.mudarEstado();
	    	
	        String sql = "UPDATE tarefas SET titulo = ?, descricao = ?, prioridade = ?, concluida = ? WHERE id = ?";
	        //utilizada para atualizar os dados de uma tarefa existente, identificada por seu id.
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) { //definir os novos valores da tarefa
	            stmt.setString(1, tarefa.getTitulo());
	            stmt.setString(2, tarefa.getDescricao());
	            stmt.setString(3, tarefa.getPrioridade().name());
	            stmt.setString(4, tarefa.isConcluida().name());
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
	}
    
    public void clonarTarefa(TarefaDTO tarefaDTO) {
    	Tarefa originalTarefa = recuperarTarefa(tarefaDTO);
    	if(originalTarefa!=null) {
	    	Tarefa tarefaClone = (Tarefa) originalTarefa.clonar(tarefaDTO);
	    	
	    	String sql = "INSERT INTO tarefas (titulo, descricao, prioridade, concluida) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {//evitar ataques de SQL injection, valores substituem ?
	            stmt.setString(1, tarefaClone.getTitulo());
	            stmt.setString(2, tarefaClone.getDescricao());
	            stmt.setString(3, tarefaClone.getPrioridade().name());
	            stmt.setString(4, tarefaClone.isConcluida().name());
	            stmt.executeUpdate();
	            System.out.println("Tarefa adicionada com sucesso!");
	            tarefaDTO.setAcao("adicionada");
	            notificarObservadores(tarefaDTO); //.
	        } catch (SQLException e) {
	            System.out.println("Falha ao adicionar a tarefa.");
	            e.printStackTrace();
	        }
    	}
    	
    	
	}
    
    public Tarefa recuperarTarefa(TarefaDTO tarefa) {
    	//Falta recuperar a tarefa no banco de dados
        String sql = "SELECT * FROM tarefas";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                TarefaDTO tarefaDTO = new TarefaDTOBuilder()
                        .setId(rs.getInt("id"))
                        .setTitulo(rs.getString("titulo"))
                        .setDescricao(rs.getString("descricao"))
                        .setPrioridade(Prioridade.valueOf(rs.getString("prioridade")))
                        .setConcluida(Estado.valueOf(rs.getString("concluida")))
                        .build();
                if(tarefaDTO.getId()==tarefa.getId()) {
                	return new Tarefa(tarefaDTO);
                }
            }
        } catch (SQLException e) {
            System.out.println("Falha ao listar as tarefas.");
            e.printStackTrace();
        }
    	return null;
    }
    /*recuperar uma unica tarefa:
     *  public Tarefa recuperarTarefa(TarefaDTO tarefa) {
        String sql = "SELECT * FROM tarefas WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, tarefa.getId());
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    TarefaDTO tarefaDTO = new TarefaDTOBuilder()
                            .setId(rs.getInt("id"))
                            .setTitulo(rs.getString("titulo"))
                            .setDescricao(rs.getString("descricao"))
                            .setPrioridade(Prioridade.valueOf(rs.getString("prioridade")))
                            .setConcluida(Estado.valueOf(rs.getString("concluida")))
                            .build();
                    return new Tarefa(tarefaDTO);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null
     
     */
    
    
    
    public List<TarefaDTO> obterTarefasPorPrioridade(String prioridade) {
        List<TarefaDTO> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas WHERE prioridade = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, prioridade);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TarefaDTO tarefaDTO = new TarefaDTOBuilder()
                            .setId(rs.getInt("id"))
                            .setTitulo(rs.getString("titulo"))
                            .setDescricao(rs.getString("descricao"))
                            .setPrioridade(Prioridade.valueOf(rs.getString("prioridade")))
                            .setConcluida(Estado.valueOf(rs.getString("concluida")))
                            .build();
                    tarefas.add(tarefaDTO);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefas;
    }

    public List<TarefaDTO> obterTarefasPorEstado(String estado) {
        List<TarefaDTO> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM tarefas WHERE concluida = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, estado);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    TarefaDTO tarefaDTO = new TarefaDTOBuilder()
                            .setId(rs.getInt("id"))
                            .setTitulo(rs.getString("titulo"))
                            .setDescricao(rs.getString("descricao"))
                            .setPrioridade(Prioridade.valueOf(rs.getString("prioridade")))
                            .setConcluida(Estado.valueOf(rs.getString("concluida")))
                            .build();
                    tarefas.add(tarefaDTO);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tarefas;
    }
	public static TarefaDAO getTarefaDAO() {
		return tarefaDAO;
	}
    
    /*public void adicionarClone(Tarefa tarefa) {
    	adicionarTarefa(new TarefaDTOBuilder()
   			.setId(tarefa.getId())
   			.setTitulo(tarefa.getTitulo())
   			.setDescricao(tarefa.getDescricao())
   			.setPrioridade(tarefa.getPrioridade())
   			.setConcluida(tarefa.isConcluida())
   			.build());
	}*/
    
    
    
}


/*
  Responsabilidade: A TarefaDAO lida com todas as operações de acesso aos dados das tarefas no banco de dados. 
  Ela encapsula a lógica de interação com o banco e notifica outros componentes da aplicação sobre mudanças nos dados.
  
  Integração com o Observer: Ao implementar o padrão Observer, a TarefaDAO garante que outros componentes da aplicação 
  (por exemplo, a interface gráfica) sejam atualizados automaticamente sempre que uma tarefa é criada, atualizada ou excluída.
*/





