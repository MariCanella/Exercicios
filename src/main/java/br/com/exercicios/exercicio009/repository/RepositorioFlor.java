package br.com.exercicios.exercicio009.repository;

import br.com.exercicios.exercicio009.model.ModeloFlor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFlor extends CrudRepository<ModeloFlor, Long> {
}
