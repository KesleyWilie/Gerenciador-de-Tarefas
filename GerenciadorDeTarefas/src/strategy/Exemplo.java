package strategy;

public class Exemplo {
		/*
		//Exemplo ao selecionar um filtro
		ContextoFiltro contexto = new ContextoFiltro();

		if (comboBox.getSelectedItem().equals("Alta Prioridade")) {
		    contexto.setFiltro(new FiltroPrioridadeAlta());
		} else if (comboBox.getSelectedItem().equals("Concluídas")) {
		    contexto.setFiltro(new FiltroConcluidas());
		} else {
		    contexto.setFiltro(new FiltroTodas());
		}

		List<TarefaDTO> tarefasFiltradas = contexto.filtrar();
		// Atualizar a interface com tarefasFiltradas
	*/

	
	//exemplo na tela:
	/*-----------------------------------------------------------------------------------------------------------------------

		 private JComboBox<String> comboBoxFiltros;
		 private ContextoFiltro contextoFiltro;
		 private void addComboBoxFiltros() {
		        comboBoxFiltros = new JComboBox<>(new String[]{"Todas", "Alta Prioridade", "Média Prioridade", "Baixa Prioridade", "Concluídas", "Em Andamento", "Não Iniciadas"});
		        comboBoxFiltros.setBounds(18, 110, 200, 30);
		        comboBoxFiltros.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                aplicarFiltro();
		            }
		        });
		        add(comboBoxFiltros);
		    }
		 
		 private void aplicarFiltro() {
		        String filtroSelecionado = (String) comboBoxFiltros.getSelectedItem();

		        if (filtroSelecionado.equals("Alta Prioridade")) {
		            contextoFiltro.setFiltro(new FiltroPrioridadeAlta());
		        } else if (filtroSelecionado.equals("Média Prioridade")) {
		            contextoFiltro.setFiltro(new FiltroPrioridadeMedia());
		        } else if (filtroSelecionado.equals("Baixa Prioridade")) {
		            contextoFiltro.setFiltro(new FiltroPrioridadeBaixa());
		        } else if (filtroSelecionado.equals("Concluídas")) {
		            contextoFiltro.setFiltro(new FiltroConcluidas());
		        } else if (filtroSelecionado.equals("Em Andamento")) {
		            contextoFiltro.setFiltro(new FiltroEmAndamento());
		        } else if (filtroSelecionado.equals("Não Iniciadas")) {
		            contextoFiltro.setFiltro(new FiltroNaoIniciadas());
		        } else {
		            contextoFiltro.setFiltro(new FiltroTodas());
		        }

		        atualizarTabela();
		    }
	*/

}
