package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**Necessita criar um método para popular a tabela, 
	 * atráves de um array de tarefas ou outra forma de 
	 * trazer as tarefas do Banco de dados.
	 * */

public class TelaGerenciadorDeTarefas extends JFrame {


	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane painelTabela;


	private JButton botaoAdicionar;
	private JButton botaoRemover;
	private JButton botaoEditar;
	private JButton botaoDetalhar;
	private JButton botaoConcluir;
	private JButton botaoClonar;

	public TelaGerenciadorDeTarefas(String titulo) {
		setTitle(titulo);
		setSize(700,615);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addGerenciador();
		addTabelaTarefas();
		addAdicionar();
		addRemover();
		addEditar();
		addDetalhar();
		addConcluir();
		addClonar();
		setVisible(true);
	}
	
	private void addGerenciador() {
		JLabel jlPerfil = new JLabel("Gerenciador de Tarefas");
		jlPerfil.setBounds(0,0,700,100);
		jlPerfil.setHorizontalAlignment(JLabel.CENTER);
		jlPerfil.setFont(new Font("Arial",Font.PLAIN,30));
		add(jlPerfil);
	}

	private void addTabelaTarefas() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] {"Tarefas, Prioridade, Em andamento/Concluido(a)"});
		tabela = new JTable(modelo);
		tabela.setFont(new Font("Arial", Font.PLAIN, 17));
		painelTabela = new JScrollPane(tabela);
		painelTabela.getViewport().setBackground(Color.decode("#F3F3F3"));
		painelTabela.setBounds(18,100,650,405);
		add(painelTabela);
	}

	private void addAdicionar() {
        botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.setBounds(517, 520, 150, 40);
        add(botaoAdicionar);
	}

	private void addRemover() {
	        botaoRemover = new JButton("Remover");
	        botaoRemover.setBounds(350, 520, 150, 40);
	        add(botaoRemover);
	}

	private void addEditar() {
	        botaoEditar = new JButton("Editar");
	        botaoEditar.setBounds(183, 520, 150, 40);

	        add(botaoEditar);
	}

	private void addDetalhar() {
	        botaoDetalhar = new JButton("Detalhar");
	        botaoDetalhar.setBounds(18, 520, 150, 40);

	        add(botaoDetalhar);
	}

	private void addConcluir() {
		botaoConcluir = new JButton("Concluir");
		//Setar posição na tela:...
		botaoConcluir.setBounds(18, 520, 150, 40);

		add(botaoConcluir);
 	}

	private void addClonar() {
		botaoClonar = new JButton("Clona");
		//Setar posição na tela:...
		botaoClonar.setBounds(18, 520, 150, 40);

		add(botaoClonar);
 	}
	 
	 //ouvinte aqui so para testes, provalvemente vai ter q fazer mais ouvintes 
	 private class OuvinteBotao implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada=tabela.getSelectedRow();
				if(linhaSelecionada==-1)
					JOptionPane.showMessageDialog(null, "Selecione uma tarefa");
				
				else {
					
				}
			}
	 }

}
