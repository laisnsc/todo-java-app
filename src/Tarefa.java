import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate dataEntrega;
    private boolean concluida;

    public Tarefa(String titulo, String descricao, LocalDate dataEntrega) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEntrega = dataEntrega;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    public static Tarefa buscarPorTitulo(List<Tarefa> tarefas, String titulo){
        for (Tarefa t : tarefas){
            if (t.getTitulo().equalsIgnoreCase(titulo)) {
                return t;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataEntrega=" + dataEntrega +
                ", concluida=" + concluida +
                '}';
    }
}
