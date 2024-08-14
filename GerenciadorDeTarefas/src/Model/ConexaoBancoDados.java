package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados { //Singleton
    private static ConexaoBancoDados instancia;
    private Connection conexao;
    private String url = "jdbc:mysql://localhost:3306/taskdb"; // nome do banco de dados
    private String usuario = "root"; // nome de usuário do MySQL
    private String senha = "6556Delta!";  // senha do MySQL

    private ConexaoBancoDados() {
        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            System.out.println("Falha na conexão com o banco de dados.");
            e.printStackTrace();
        }
    }

    public static ConexaoBancoDados getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoBancoDados();
        }
        return instancia;
    }

    public Connection getConexao() {
        return conexao;
    }
}	
/*
	Script:
 
	-- Criar o banco de dados
	CREATE DATABASE IF NOT EXISTS taskdb;

	-- Usar o banco de dados criado
	USE taskdb;

	-- Criar a tabela 'tarefas'
	CREATE TABLE IF NOT EXISTS tarefas (
    	id INT AUTO_INCREMENT PRIMARY KEY,
    	titulo VARCHAR(255) NOT NULL,
    	descricao TEXT,
    	prioridade ENUM('BAIXA', 'MEDIA', 'ALTA') NOT NULL,
    	concluida BOOLEAN NOT NULL DEFAULT FALSE
	);

--------------------------------------------------------------------
Passo a passo pra quem quiser testar aí:
	instalar o MySql, eu coloquei minha senha como "senha".
	Abra o MySQL Workbench 
	Conecte-se ao seu servidor MySQL.
	Copie e cole o script SQL acima na interface de execução de comandos SQL.
	Execute o script.
	
Este script irá criar o banco de dados chamado taskdb e uma tabela tarefas dentro dele, com as colunas necessárias para o seu CRUD de tarefas.
 */
 