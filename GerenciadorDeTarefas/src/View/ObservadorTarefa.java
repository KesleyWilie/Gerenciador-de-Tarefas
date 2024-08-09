package View;

import Observer.Observador;
import Model.Tarefa;

public class ObservadorTarefa implements Observador {

    @Override
    public void atualizar(Tarefa tarefa, String acao) {// pode usar coisas assim pra o strategy tbm
        switch (acao) {
            case "adicionada":
                System.out.println("Nova tarefa adicionada: " + tarefa.getTitulo());
                // Código para atualizar a interface gráfica com a nova tarefa
                break;
            case "atualizada":
                System.out.println("Tarefa atualizada: " + tarefa.getTitulo());
                // Código para atualizar a interface gráfica com as mudanças na tarefa
                break;
            case "deletada":
                System.out.println("Tarefa deletada.");
                // Código para atualizar a interface gráfica removendo a tarefa
                break;
            default:
                break;
        }
    }
}
