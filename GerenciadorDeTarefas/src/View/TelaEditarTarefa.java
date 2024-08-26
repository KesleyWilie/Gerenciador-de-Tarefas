package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.TarefaDTO;
import Ouvintes.OuvinteSalvar;

/**
 * Criar ouvinte para implementar a lógica de editar a tarefa selecionada.
 */

public class TelaEditarTarefa extends JFrame{

	private TarefaDTO tarefa;
	
	private JTextField textoTitulo;
	private JTextArea textoDescricao;
	private String[] ArrayPrio = new String[3];
	private JComboBox<String> prioridade;
	private JLabel jlTarefa;
	private JButton botaoSalvar;

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
        OuvinteSalvar ouvinte = new OuvinteSalvar(this);
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
        JButton botaoCancelar = new JButton("Cancelar");
        botaoCancelar.setBounds(205, 395, 120, 40);
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
		String tarefaPrioridade = tarefa.getPrioridade().toString();
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

		ArrayPrio[0]="ALTA";
		ArrayPrio[1]="MEDIA";
		ArrayPrio[2]="BAIXA";
		prioridade = new JComboBox<String>(ArrayPrio);
		prioridade.setSelectedIndex(indice);
		prioridade.setBounds(130, 300,330,30);
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
	
	

}
