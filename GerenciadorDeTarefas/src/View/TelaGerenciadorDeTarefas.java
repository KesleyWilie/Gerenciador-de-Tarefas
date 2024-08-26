package View;

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

import Ouvintes.OuvinteAdicionar;

/**Necessita criar um método para popular a tabela, 
	 * atráves de um array de tarefas ou outra forma de 
	 * trazer as tarefas do Banco de dados.
	 * */

public class TelaGerenciadorDeTarefas extends JFrame {

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
		setVisible(true);
	}
	private JTable tabela;
	private void addGerenciador() {
		JLabel jlPerfil = new JLabel("Gerenciador de Tarefas");
		jlPerfil.setBounds(0,0,700,100);
		jlPerfil.setHorizontalAlignment(JLabel.CENTER);
		jlPerfil.setFont(new Font("Arial",Font.BOLD,30));
		add(jlPerfil);
	}

	private void addTabelaTarefas() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Tarefas");		
		modelo.addColumn("Prioridade");
		modelo.addColumn("Em andamento/Concluido(a)");
		tabela = new JTable(modelo);
		JScrollPane painelTabela = new JScrollPane(tabela);
		painelTabela.setBounds(18,100,650,405);
		add(painelTabela);
	}
	private void addAdicionar() {
        JButton botaoAdicionar = new JButton("Adicionar");
        botaoAdicionar.setBounds(517, 520, 150, 40);
        OuvinteAdicionar ouvinte = new OuvinteAdicionar();
        botaoAdicionar.addActionListener(ouvinte);
        add(botaoAdicionar);
	}
	 private void addRemover() {
	        JButton botaoRemover = new JButton("Remover");
	        botaoRemover.setBounds(350, 520, 150, 40);
	        OuvinteBotao ouvinte = new OuvinteBotao();
	        botaoRemover.addActionListener(ouvinte);
	        add(botaoRemover);
	 }
	 private void addEditar() {
	        JButton botaoEditar = new JButton("Editar");
	        botaoEditar.setBounds(183, 520, 150, 40);
	        OuvinteBotao ouvinte = new OuvinteBotao();
	        botaoEditar.addActionListener(ouvinte);
	        add(botaoEditar);
	 }
	 private void addDetalhar() {
	        JButton botaoDetalhar = new JButton("Detalhar");
	        botaoDetalhar.setBounds(18, 520, 150, 40);
	        OuvinteBotao ouvinte = new OuvinteBotao();
	        botaoDetalhar.addActionListener(ouvinte);
	        add(botaoDetalhar);
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
