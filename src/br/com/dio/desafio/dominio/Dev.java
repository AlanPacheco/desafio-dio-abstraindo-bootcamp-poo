package br.com.dio.desafio.dominio;

import java.util.*;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }

    }

    public double calcularXp() {
        return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }

    private int totalHoras(Bootcamp bootcamp) {
        return this.conteudosConcluidos
                .stream()
                .mapToInt(conteudo -> conteudo.cargaHoraria())
                .sum();
    }

    public void imprimirCertificado(Bootcamp bootcamp) {
        int totalHoras;
        if (conteudosInscritos.isEmpty()) {
            totalHoras = totalHoras(bootcamp);
            System.out.println("Certificamos que o desenvolvedor " + this.nome
                    + " concluíu o Bootcamp " + bootcamp.getNome()
                    + " com carga horária de " + totalHoras
            + " horas.");
            return;
        }
        System.out.println("Bootcamp em andamento. Por favor, finalize os conteúdos!!!");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }

    @Override
    public String toString() {
        return "Dev{" +
                "nome='" + nome + '\'' +
                ", conteudosInscritos=" + conteudosInscritos +
                ", conteudosConcluidos=" + conteudosConcluidos +
                '}';
    }
}
