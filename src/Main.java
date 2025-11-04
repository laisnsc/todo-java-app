import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
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
                    System.out.println(tarefa);
                    yield true;
                }
                case 2 -> {
                    System.out.println("Listar tarefas pendentes");
                    yield true;
                }
                case 3 -> {
                    System.out.println("Buscar tarefa por título");
                    yield true;
                }
                case 4 -> {
                    System.out.println("Marcar tarefa como concluída");
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