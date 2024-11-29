package com.tecsup.s11_dev_ejemplo02;

import com.tecsup.s11_dev_ejemplo02.model.documents.Alumno;
import com.tecsup.s11_dev_ejemplo02.model.documents.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@SpringBootApplication
public class S11DevEjemplo02Application implements CommandLineRunner {

    @Autowired
    private ReactiveMongoTemplate template;
    public static void main(String[] args) {
        SpringApplication.run(S11DevEjemplo02Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        template.dropCollection("cursos").subscribe();
        template.dropCollection("alumnos").subscribe();

        template.insert(new Curso("C01","Java 17", 4)).subscribe();
        template.insert(new Curso("C02","SPRING BOOT", 5)).subscribe();
        template.insert(new Curso("C03","Jenkins", 3)).subscribe();
        template.insert(new Curso("C04","kubernetes", 4)).subscribe();
        template.insert(new Curso("C05","kafka", 3)).subscribe();
        template.insert(new Curso("C06","microservicios", 4)).subscribe();
        template.insert(new Curso("C07","angular", 5)).subscribe();
        template.insert(new Curso("C08","typescript", 4)).subscribe();
        template.insert(new Curso("C09","html", 4)).subscribe();
        template.insert(new Curso("C10","css 3", 1)).subscribe();

        template.insert(new Alumno("A01","Christopher","Lozada", 4)).subscribe();
        template.insert(new Alumno("A02","Johan","Lopez", 5)).subscribe();
        template.insert(new Alumno("A03","Jeremias","Coronel", 3)).subscribe();
        template.insert(new Alumno("A04","Abigail","Ticalvilca", 4)).subscribe();
        template.insert(new Alumno("A05","Ibrahim","Ramos", 3)).subscribe();
        template.insert(new Alumno("A06","Josue","Rosadio", 4)).subscribe();
        template.insert(new Alumno("A07","Nicolas","Silva", 5)).subscribe();
        template.insert(new Alumno("A08","Darwin","Canales", 4)).subscribe();
        template.insert(new Alumno("A09","Angelo","Vinces", 4)).subscribe();
        template.insert(new Alumno("A10","Juan","Valladares", 1)).subscribe();
    }

}