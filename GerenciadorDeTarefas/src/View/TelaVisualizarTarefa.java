package View;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controller.OuvinteTelaVisualizarTarefa;
import Model.Prioridade;
import Model.TarefaDTO;

public class TelaVisualizarTarefa extends JFrame{

	private TarefaDTO tarefa;

	private JTextField textoTitulo;
	private JTextArea textoDescricao;
	private JComboBox<String> prioridade;
	private JButton botaoVoltar; 
	private JButton botaoConcluir;
	private JButton botaoClonar;

	public TelaVisualizarTarefa(String titulo, TarefaDTO tarefa) {
		this.tarefa = tarefa;
		setTitle(titulo);
		setSize(500,500);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addVisualizarTarefa();
		addTituloTarefa();
		addDescricao();
		addTextoTitulo();
		addTextoDescricao();
		addPrioridade();
		addComboPrioridade();
		addVoltar();
		addConcluir();
		addClonar();
		textoTitulo.setText(tarefa.getTitulo());
		textoTitulo.setEditable(false);
		textoDescricao.setText(tarefa.getDescricao());
		textoDescricao.setEditable(false);
		prioridade.setSelectedItem(tarefa.getPrioridade());
		prioridade.setEditable(false);
		setVisible(true);
		
	}
	private void addVisualizarTarefa() {
		JLabel jlTarefa = new JLabel("Visualizar Tarefa");
		jlTarefa.setBounds(0,0,500,100);
		jlTarefa.setHorizontalAlignment(JLabel.CENTER);
		jlTarefa.setFont(new Font("Arial",Font.BOLD,30));
		add(jlTarefa);
	}

	private void addTituloTarefa() {
		JLabel titulo = new JLabel("Titulo da tarefa: ");
        titulo.setBounds(30, 120, 100, 30);
        titulo.setHorizontalAlignment(JLabel.LEFT);
        add(titulo);
    }

	private void addDescricao() {
        JLabel descricao = new JLabel("Descrição: ");
        descricao.setBounds(30, 180, 80, 30);
        descricao.setHorizontalAlignment(JLabel.LEFT);
        add(descricao);
    }

	private void addTextoTitulo() {
        textoTitulo = new JTextField();
        textoTitulo.setBounds(130, 120, 330, 30);
        add(textoTitulo);
    }

	private void addTextoDescricao() {		
        textoDescricao = new JTextArea();
        JScrollPane painelDesc = new JScrollPane(textoDescricao);
        textoDescricao.setLineWrap(true);
        textoDescricao.setWrapStyleWord(true);
        painelDesc.setBounds(130, 180, 330, 90);
        add(painelDesc);
    }
	
	private void addConcluir() {
		botaoConcluir = new JButton("Concluir");
		//Setar posição na tela:...
		botaoConcluir.setBounds(350, 395, 120, 40);
		
		botaoConcluir.setForeground(Color.WHITE);
		botaoConcluir.setBackground(Cores.SHAPPHIRE);
		botaoConcluir.setOpaque(true);
		botaoConcluir.setBorder(null);
		botaoConcluir.setFocusable(false);
		
		OuvinteTelaVisualizarTarefa ouvinte = new OuvinteTelaVisualizarTarefa(this);
		botaoConcluir.addActionListener(ouvinte);
		
		add(botaoConcluir);
 	}

	private void addClonar() {
		botaoClonar = new JButton("Clonar");
		//Setar posição na tela:...
		botaoClonar.setBounds(60, 395, 120, 40);

		botaoClonar.setForeground(Color.WHITE);
		botaoClonar.setBackground(Cores.SHAPPHIRE);
		botaoClonar.setOpaque(true);
		botaoClonar.setBorder(null);
		botaoClonar.setFocusable(false);
		
		OuvinteTelaVisualizarTarefa ouvinte = new OuvinteTelaVisualizarTarefa(this);
		botaoClonar.addActionListener(ouvinte);

		add(botaoClonar);
 	}
	
	private void addVoltar() {
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(205, 395, 120, 40);
        botaoVoltar.setForeground(Color.WHITE);
        botaoVoltar.setBackground(Cores.SHAPPHIRE);
        botaoVoltar.setOpaque(true);
        botaoVoltar.setBorder(null);
        botaoVoltar.setFocusable(false);
        
		OuvinteTelaVisualizarTarefa ouvinte = new OuvinteTelaVisualizarTarefa(this);
		botaoVoltar.addActionListener(ouvinte);
        add(botaoVoltar);
	}

	private void addPrioridade() {
		JLabel prioridade = new JLabel("Prioridade: ");
        prioridade.setBounds(30, 300, 80, 30);
        prioridade.setHorizontalAlignment(JLabel.LEFT);
        add(prioridade);
	}

	private void addComboPrioridade() {
		prioridade = new JComboBox<>(new String[] {Prioridade.ALTA.name(), Prioridade.MEDIA.name(), Prioridade.BAIXA.name()});
		prioridade.setBounds(130, 300,330,30);
		prioridade.setBackground(Cores.CINZA_CLARO_2);
		prioridade.setForeground(Cores.CINZA_ESCURO_2);
		prioridade.setFont(new Font("Arial", Font.PLAIN, 26));
		prioridade.setOpaque(true);
		prioridade.setBorder(null);
		add(prioridade);
	}

	


	
	public TarefaDTO getTarefa() {
		return tarefa;
	}
	
	

	public JButton getBotaoVoltar() {
		return botaoVoltar;
	}
	public JTextField getTextoTitulo() {
		return textoTitulo;
	}
	public JTextArea getTextoDescricao() {
		return textoDescricao;
	}
	public JComboBox<String> getPrioridade() {
		return prioridade;
	}
	
	public JButton getBotaoConcluir() {
		return botaoConcluir;
	}

	public JButton getBotaoClonar() {
		return botaoClonar;
	}

}
