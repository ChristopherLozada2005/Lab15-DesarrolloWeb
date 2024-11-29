package com.tecsup.s11_dev_ejemplo02.controllers;

import com.tecsup.s11_dev_ejemplo02.model.documents.Alumno;
import com.tecsup.s11_dev_ejemplo02.model.daos.AlumnoDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class AlumnoController {

    @Autowired
    private AlumnoDao alumnoDao;

    private static final Logger log = LoggerFactory.getLogger(AlumnoController.class);

    @GetMapping({"/listaralumno", "/" })
    public String listarAlumno(Model model) {

        Flux<Alumno> alumnos = alumnoDao.findAll().map(alumno -> {
            alumno.nombre().toUpperCase();
            return alumno;
        });

        alumnos.subscribe(alumno -> log.info(alumno.nombre()));

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("titulo", "Listar Alumnos");
        return "listarAlumno";
    }

    @GetMapping("/listaralumno-datadriver")
    public String listarAlumnoDatadriver(Model model) {
        Flux<Alumno> alumnos = alumnoDao.findAll().map(alumno -> {
            alumno.nombre().toUpperCase();
            return alumno;
        }).delayElements(Duration.ofSeconds(2));

        alumnos.subscribe(alumno -> log.info(alumno.nombre()));

        model.addAttribute("alumnos", new ReactiveDataDriverContextVariable(alumnos,2));
        model.addAttribute("titulo", "Listado de Alumnos");
        return "listarAlumno";
    }

    @GetMapping("/listaralumno-full")
    public String listarAlumnoFull(Model model) {
        Flux<Alumno> alumnos = alumnoDao.findAll().map(alumno -> {

           alumno.nombre().toUpperCase();
           return alumno;
        }).repeat(5000);

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("titulo", "Listado de Alumnos");
        return "listarAlumno";
    }

    @GetMapping("/listaralumno-chunked")
    public String listarAlumnoChunked(Model model) {
        Flux<Alumno> alumnos = alumnoDao.findAll().map(alumno -> {
            alumno.nombre().toUpperCase();
            return alumno;
        }).repeat(5000);

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("titulo", "Listado de Alumnos");
        return "listaralumno-chunked";
    }
}
