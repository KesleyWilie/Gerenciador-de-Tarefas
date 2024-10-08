package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Controller.OuvinteTelaGerenciadorDeTarefas;
import Controller.PopuladorTabelaTarefas;
import Model.Estado;
import Model.EstadoDaTarefa;
import Model.Prioridade;

public class TelaGerenciadorDeTarefas extends JFrame {


	private PopuladorTabelaTarefas populador;

	private JTable tabela;
	private DefaultTableModel modelo;
	private JScrollPane painelTabela;

	private JComboBox<String> prioridade;

	private JButton botaoAdicionar;
	private JButton botaoRemover;
	private JButton botaoEditar;
	private JButton botaoDetalhar;
	
	public TelaGerenciadorDeTarefas(String titulo, String prioridade) {
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
		addComboPrioridade();
		populador = new PopuladorTabelaTarefas(this);
		populador.popularTabelaTarefas(prioridade);
		setVisible(true);
	}
	
	private void addGerenciador() {
		JLabel jlPerfil = new JLabel("Gerenciador de Tarefas");
		jlPerfil.setBounds(0,-20,700,100);
		jlPerfil.setHorizontalAlignment(JLabel.CENTER);
		jlPerfil.setFont(new Font("Arial",Font.BOLD,30));
		add(jlPerfil);
	}
	
	private void addComboPrioridade() {
		prioridade = new JComboBox<>(new String[] {"-Selecionar-", "TODOS", Prioridade.ALTA.name(), Prioridade.MEDIA.name(), Prioridade.BAIXA.name(),Estado.Concluida.name(), Estado.Em_Andamento.name()});
		prioridade.setBounds(18, 60,650,30);
		prioridade.setBackground(Cores.CINZA_CLARO_2);
		prioridade.setForeground(Cores.CINZA_ESCURO_2);
		prioridade.setFont(new Font("Arial", Font.PLAIN, 26));
		prioridade.setOpaque(true);
		prioridade.setBorder(null);

		OuvinteTelaGerenciadorDeTarefas ouvinte = new OuvinteTelaGerenciadorDeTarefas(this, prioridade);
		prioridade.addItemListener(ouvinte);

		add(prioridade);
	}

	private void addTabelaTarefas() {
		modelo = new DefaultTableModel();
		modelo.setColumnIdentifiers(new String[] {"Tarefas", "Prioridade", "Em andamento/Concluido(a)"});
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

		OuvinteTelaGerenciadorDeTarefas ouvinte = new OuvinteTelaGerenciadorDeTarefas(this, prioridade);
		botaoAdicionar.addActionListener(ouvinte);
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
			OuvinteTelaGerenciadorDeTarefas ouvinte = new OuvinteTelaGerenciadorDeTarefas(this, prioridade);
			botaoRemover.addActionListener(ouvinte);
			
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
			OuvinteTelaGerenciadorDeTarefas ouvinte = new OuvinteTelaGerenciadorDeTarefas(this, prioridade);
			botaoEditar.addActionListener(ouvinte);

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
			OuvinteTelaGerenciadorDeTarefas ouvinte = new OuvinteTelaGerenciadorDeTarefas(this, prioridade);
			botaoDetalhar.addActionListener(ouvinte);


	        add(botaoDetalhar);
	}
	
	public PopuladorTabelaTarefas getPopulador() {
		return populador;
	}

	public JComboBox<String> getPrioridade() {
		return prioridade;
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
	
}
