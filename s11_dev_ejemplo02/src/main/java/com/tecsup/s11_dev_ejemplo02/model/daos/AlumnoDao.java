package com.tecsup.s11_dev_ejemplo02.model.daos;

import com.tecsup.s11_dev_ejemplo02.model.documents.Alumno;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AlumnoDao extends ReactiveMongoRepository<Alumno, String> {
}
