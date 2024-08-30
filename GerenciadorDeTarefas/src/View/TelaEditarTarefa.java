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

import Controller.OuvinteTelaEditarTarefa;
import Model.Prioridade;
import Model.TarefaDTO;

public class TelaEditarTarefa extends JFrame{

	private TarefaDTO tarefa;
	
	private JTextField textoTitulo;
	private JTextArea textoDescricao;
	private JComboBox<String> prioridade;
	private JLabel jlTarefa;

	private JButton botaoSalvar;
	private JButton botaoCancelar;

	public TelaEditarTarefa(String titulo, TarefaDTO tarefa) {
		this.tarefa = tarefa;
		setTitle(titulo);
		setSize(500,500);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addCancelar();
		addTituloTarefa();
		addDescricao();
		addTextoTitulo();
		addTextoDescricao();
		addPrioridade();
		addComboPrioridade();
		addEditarTarefa();
		addSalvar();
		setVisible(true);
	}

	private void addEditarTarefa() {
		jlTarefa = new JLabel("Editar Tarefa");
		jlTarefa.setBounds(0,0,500,100);
		jlTarefa.setHorizontalAlignment(JLabel.CENTER);
		jlTarefa.setFont(new Font("Arial",Font.BOLD,30));
		add(jlTarefa);
	}
	private void addSalvar() {
        botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(340, 395, 120, 40);
		botaoSalvar.setForeground(Color.WHITE);
		botaoSalvar.setBackground(Cores.SHAPPHIRE);
		botaoSalvar.setOpaque(true);
		botaoSalvar.setBorder(null);
		botaoSalvar.setFocusable(false);

        OuvinteTelaEditarTarefa ouvinte = new OuvinteTelaEditarTarefa(this);
        botaoSalvar.addActionListener(ouvinte);
        add(botaoSalvar);
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
	
	private void addCancelar() {
        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(205, 395, 120, 40);
		botaoCancelar.setForeground(Color.WHITE);
		botaoCancelar.setBackground(Cores.SHAPPHIRE);
		botaoCancelar.setOpaque(true);
		botaoCancelar.setBorder(null);
		botaoCancelar.setFocusable(false);
		
		OuvinteTelaEditarTarefa ouvinte = new OuvinteTelaEditarTarefa(this);
		botaoCancelar.addActionListener(ouvinte);
        add(botaoCancelar);
	}
	private void addTextoTitulo() {
        textoTitulo = new JTextField();
        textoTitulo.setBounds(130, 120, 330, 30);
		textoTitulo.setText(tarefa.getTitulo());
        add(textoTitulo);
    }

	private void addTextoDescricao() {		
        textoDescricao = new JTextArea();
        JScrollPane painelDesc = new JScrollPane(textoDescricao);
        textoDescricao.setLineWrap(true);
        textoDescricao.setWrapStyleWord(true);
        painelDesc.setBounds(130, 180, 330, 90);
		textoDescricao.setText(tarefa.getDescricao());
        add(painelDesc);
    }
	
	private void addPrioridade() {
		JLabel prioridade = new JLabel("Prioridade: ");
        prioridade.setBounds(30, 300, 80, 30);
        prioridade.setHorizontalAlignment(JLabel.LEFT);
        add(prioridade);
	}


	private void addComboPrioridade() {
		String tarefaPrioridade = tarefa.getPrioridade().name();
		int indice = -1;
		switch (tarefaPrioridade) {
			case "ALTA":
				indice = 0;
				break;
			case "MEDIA":
				indice = 1;
				break;
			case "BAIXA":
				indice = 2;
				break;
			default:
				break;
		}

		prioridade = new JComboBox<>(new String[] {Prioridade.ALTA.name(), Prioridade.MEDIA.name(), Prioridade.BAIXA.name()});
		prioridade.setSelectedIndex(indice);
		prioridade.setBounds(130, 300,330,30);
		prioridade.setBackground(Cores.CINZA_CLARO_2);
		prioridade.setForeground(Cores.CINZA_ESCURO_2);
		prioridade.setFont(new Font("Arial", Font.PLAIN, 26));
		prioridade.setOpaque(true);
		prioridade.setBorder(null);
		add(prioridade);
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
	public JButton getBotaoSalvar() {
		return botaoSalvar;
	}

	public JButton getBotaoCancelar() {
		return botaoCancelar;
	}

	public TarefaDTO getTarefa() {
		return tarefa;
	}
	
	
	

}
