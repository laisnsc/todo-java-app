import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        List<Tarefa> tarefas = new ArrayList<>();
        boolean executando = true;
        System.out.println("TodoList");

        while (executando) {
            System.out.println("====== Menu ======");
            System.out.println("1 - Cadastrar tarefa");
            System.out.println("2 - Listar tarefas pendentes");
            System.out.println("3 - Buscar tarefa por título");
            System.out.println("4 - Marcar tarefa como concluída");
            System.out.println("5 - Remover uma tarefa");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.println("Digite uma opção:");
            Scanner sc = new Scanner(System.in);
            int opcao = sc.nextInt();
            sc.nextLine();

            System.out.println("A opção escolhida foi " + opcao);

            executando = switch (opcao){
                case 1 -> {
                    System.out.println("Digite o título");
                    String titulo = sc.nextLine();
                    System.out.println("Digite a descrição");
                    String descricao = sc.nextLine();
                    System.out.println("Digite a data de entrega (YYYY-MM-dd)");
                    LocalDate dataEntrega = LocalDate.parse(sc.nextLine());
                    Tarefa tarefa = new Tarefa(titulo, descricao, dataEntrega);
                    tarefas.add(tarefa);
                    System.out.println(tarefa);
                    yield true;
                }
                case 2 -> {
                    System.out.println("====== Tarefas Pendentes ======");
                    for (Tarefa t : tarefas) {
                        if (!t.isConcluida()){
                            System.out.println(t);
                        }
                    }
                    yield true;
                }
                case 3 -> {
                    System.out.println("Digite o título da tarefa para buscar");
                    String tituloBusca = sc.nextLine();
                    Tarefa tarefaEncontrada = Tarefa.buscarPorTitulo(tarefas, tituloBusca);
                    if (tarefaEncontrada != null) {
                        System.out.println("Tarefa Encontrada:");
                        System.out.println(tarefaEncontrada);
                    } else {
                        System.out.println("Nenhuma tarefa com esse título encontrada.");
                    }
                    yield true;
                }
                case 4 -> {
                    System.out.println("Marcar tarefa como concluída");
                    System.out.println("Digite o título da tarefa:");
                    String tituloBusca = sc.nextLine();
                    Tarefa tarefaConcluida = Tarefa.buscarPorTitulo(tarefas, tituloBusca);
                    if (tarefaConcluida != null) {
                        tarefaConcluida.setConcluida(true);
                        System.out.println("Tarefa foi marcada como concluída.");
                    } else {
                        System.out.println("Nenhuma tarefa com esse título encontrada.");
                    }
                    yield true;
                }
                case 5 -> {
                    System.out.println("Remover uma tarefa");
                    yield true;
                }
                case 0 -> {
                    System.out.println("Sair");
                    yield false;
                }
                default -> {
                    System.out.println("Opção Inválida");
                    yield true;
                }
            };
        }
    }
}