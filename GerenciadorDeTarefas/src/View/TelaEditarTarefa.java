package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import Ouvintes.OuvinteSalvar;

public class TelaEditarTarefa extends TelaGenericaTarefas{

	public TelaEditarTarefa(String titulo) {
		super(titulo);
		//aqui precisar setar os textos -> getTextoTitulo().setText(PARAMETRO); e assim por diante
		addEditarTarefa();
		addSalvar();
	}
	private void addEditarTarefa() {
		JLabel jlTarefa = new JLabel("Editar Tarefa");
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
