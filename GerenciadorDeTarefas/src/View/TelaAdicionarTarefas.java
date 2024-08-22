package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Ouvintes.OuvinteSalvar;

public class TelaAdicionarTarefas extends TelaGenericaTarefas {

	public TelaAdicionarTarefas(String titulo) {
		super(titulo);
		setSize(500,500);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addNovaTarefa();
		addSalvar();		
		setVisible(true);
	}
	
	private void addNovaTarefa() {
		JLabel jlTarefa = new JLabel("Nova Tarefa");
		jlTarefa.setBounds(0,0,500,100);
		jlTarefa.setHorizontalAlignment(JLabel.CENTER);
		jlTarefa.setFont(new Font("Arial",Font.BOLD,30));
		add(jlTarefa);
	}
	private void addSalvar() {
        JButton botaoSalvar = new JButton("Salvar");
        botaoSalvar.setBounds(340, 395, 120, 40);
        OuvinteSalvar ouvinte = new OuvinteSalvar(this);
        botaoSalvar.addActionListener(ouvinte);
        add(botaoSalvar);
	}

}
