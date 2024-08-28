package View;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.TarefaDTO;

public class TelaVisualizarTarefa extends JFrame{

	private TarefaDTO tarefa;

	private JTextField textoTitulo;
	private JTextArea textoDescricao;
	private JComboBox<String> prioridade;
	private JButton botaoVoltar; 

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
		addCancelar();
		textoTitulo.setText(tarefa.getTitulo());
		textoDescricao.setText(tarefa.getDescricao());
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

	private void addPrioridade() {
		JLabel prioridade = new JLabel("Prioridade: ");
        prioridade.setBounds(30, 300, 80, 30);
        prioridade.setHorizontalAlignment(JLabel.LEFT);
        add(prioridade);
	}

	private void addComboPrioridade() {
		prioridade.setBounds(130, 300,330,30);
		add(prioridade);
	}

	private void addCancelar() {
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(205, 395, 120, 40);
		OuvinteBotao ouvinte = new OuvinteBotao();
		botaoVoltar.addActionListener(ouvinte);
        add(botaoVoltar);
	}


	
	public TarefaDTO getTarefa() {
		return tarefa;
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


	private class OuvinteBotao implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == botaoVoltar){
				dispose();
				new TelaGerenciadorDeTarefas("Gerenciador de Tarefas");
			}
				
		}
 }

}
