package com.tecsup.s11_dev_ejemplo01;

import com.tecsup.s11_dev_ejemplo01.model.Curso;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class S11DevEjemplo01Application implements CommandLineRunner {

    public static void main(String[] args) {

        SpringApplication.run(S11DevEjemplo01Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Flux<String> scursos = Flux.just( "c01 programmer 5",
                "c02 developer 2",
                "c03 architect 5",
                "c04 expert 2");

        Flux<Curso> cursos = scursos.map(curso -> new Curso(curso.split(" ")[0],
                        curso.split(" ")[1],
                        Integer.parseInt(curso.split(" ")[2])))
                .filter(curso -> curso.creditos() >= 3)
                .doOnNext(curso -> {
                    if(curso == null){
                        throw new RuntimeException("Nombres no pueden ser vacios");
                    }
                });

        cursos.subscribe(e -> System.out.println(e.toString()),
                error -> System.out.println(error.getMessage()),
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Ha finalizado la ejecución del observable con éxito");
                    }
                });
    }
}
