package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.PopuladorTabelaTarefas;
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
		PopuladorTabelaTarefas populador = new PopuladorTabelaTarefas(tabela, modelo, painelTabela);
		populador.popularTabelaTarefas();
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
        botaoAdicionar.setForeground(Color.WHITE);
		botaoAdicionar.setBackground(Cores.SHAPPHIRE);
		botaoAdicionar.setOpaque(true);
		botaoAdicionar.setBorder(null);
		botaoAdicionar.setFocusable(false);
		add(botaoAdicionar);
	}

	private void addRemover() {
	        botaoRemover = new JButton("Remover");
	        botaoRemover.setBounds(350, 520, 150, 40);
	        botaoRemover.setForeground(Color.WHITE);
			botaoRemover.setBackground(Cores.SHAPPHIRE);
			botaoRemover.setOpaque(true);
			botaoRemover.setBorder(null);
			botaoRemover.setFocusable(false);
			
			add(botaoRemover);
	}

	private void addEditar() {
	        botaoEditar = new JButton("Editar");
	        botaoEditar.setBounds(183, 520, 150, 40);
			botaoEditar.setForeground(Color.WHITE);
			botaoEditar.setBackground(Cores.SHAPPHIRE);
			botaoEditar.setOpaque(true);
			botaoEditar.setBorder(null);
			botaoEditar.setFocusable(false);


	        add(botaoEditar);
	}

	private void addDetalhar() {
	        botaoDetalhar = new JButton("Detalhar");
	        botaoDetalhar.setBounds(18, 520, 150, 40);
			botaoDetalhar.setForeground(Color.WHITE);
			botaoDetalhar.setBackground(Cores.SHAPPHIRE);
			botaoDetalhar.setOpaque(true);
			botaoDetalhar.setBorder(null);
			botaoDetalhar.setFocusable(false);


	        add(botaoDetalhar);
	}

	private void addConcluir() {
		botaoConcluir = new JButton("Concluir");
		//Setar posição na tela:...
		botaoConcluir.setBounds(18, 520, 150, 40);
		
		botaoConcluir.setForeground(Color.WHITE);
		botaoConcluir.setBackground(Cores.SHAPPHIRE);
		botaoConcluir.setOpaque(true);
		botaoConcluir.setBorder(null);
		botaoConcluir.setFocusable(false);

		

		add(botaoConcluir);
 	}

	private void addClonar() {
		botaoClonar = new JButton("Clona");
		//Setar posição na tela:...
		botaoClonar.setBounds(18, 520, 150, 40);

		botaoClonar.setForeground(Color.WHITE);
		botaoClonar.setBackground(Cores.SHAPPHIRE);
		botaoClonar.setOpaque(true);
		botaoClonar.setBorder(null);
		botaoClonar.setFocusable(false);

		add(botaoClonar);
 	}

	public JTable getTabela() {
		return tabela;
	}

	public DefaultTableModel getModelo() {
		return modelo;
	}

	public JScrollPane getPainelTabela() {
		return painelTabela;
	}

	public JButton getBotaoAdicionar() {
		return botaoAdicionar;
	}

	public JButton getBotaoRemover() {
		return botaoRemover;
	}

	public JButton getBotaoEditar() {
		return botaoEditar;
	}

	public JButton getBotaoDetalhar() {
		return botaoDetalhar;
	}

	public JButton getBotaoConcluir() {
		return botaoConcluir;
	}

	public JButton getBotaoClonar() {
		return botaoClonar;
	}

	
}
