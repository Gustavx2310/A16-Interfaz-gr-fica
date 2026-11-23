package com.ejemplo.libreria.repolibros;

import com.ejemplo.libreria.model.Libros;
import java.util.List;
import java.util.Optional;

public interface IRepoLibros {
    List<Libros> findAll();
    Optional<Libros> findById(long id);
    void save(Libros libro);
    void deleteById(long id);
}
