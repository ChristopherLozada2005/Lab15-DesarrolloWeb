package com.tecsup.s11_dev_ejemplo02.model.daos;

import com.tecsup.s11_dev_ejemplo02.model.documents.Curso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CursoDao extends ReactiveMongoRepository<Curso, String> {
}
