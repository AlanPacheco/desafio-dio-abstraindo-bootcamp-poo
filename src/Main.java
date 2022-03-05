import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso Js");
        curso2.setDescricao("Descrição curso JS");
        curso2.setCargaHoraria(4);

        Conteudo conteudo = new Curso();
        Conteudo conteudo1 = new Mentoria();

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devAlan = new Dev();
        devAlan.setNome("Alan");
        devAlan.inscreverBootcamp(bootcamp);
        Dev devJoao = new Dev();
        devJoao.setNome("João");
        devJoao.inscreverBootcamp(bootcamp);

        System.out.println();
        System.out.println("### Conteudos Incritos ###");
        System.out.println("Conteudos Inscritos Alan: " +devAlan.getConteudosInscritos());
        System.out.println("Conteudos Inscritos João: " +devJoao.getConteudosInscritos());

        System.out.println();

        System.out.println("### Calcula XP ###");
        System.out.println("XP - Alan: " + devAlan.calcularXp());
        System.out.println("XP - Joao: " + devJoao.calcularXp());

        System.out.println();

        System.out.println("### Conteudos Concluidos ###");
        devAlan.progredir();
        devAlan.progredir();
        devAlan.progredir();
        System.out.println("Conteudos Concluidos Alan: " +devAlan.getConteudosConcluidos());
        devJoao.progredir();
        System.out.println("Conteudos Consluidos João: " +devJoao.getConteudosConcluidos());

        System.out.println();

        System.out.println("### Calcula XP ###");
        System.out.println("XP - Alan: " + devAlan.calcularXp());
        System.out.println("XP - Joao: " + devJoao.calcularXp());

        System.out.println();

        System.out.println("### Conteudos Inscritos ###");
        System.out.println("Conteudos Inscritos Alan: " +devAlan.getConteudosInscritos());
        System.out.println("Conteudos Inscritos João: " +devJoao.getConteudosInscritos());

        System.out.println("###   Imprimir Certificados   ###");

        devAlan.imprimirCertificado(bootcamp);
        devJoao.imprimirCertificado(bootcamp);


    }
}
