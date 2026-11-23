package com.ejemplo.libreria.servicio;

import com.ejemplo.libreria.model.Libros;
import java.util.List;
import java.util.Optional;

public interface IServicioLibro {
    List<Libros> obtenerTodos();
    Optional<Libros> obtenerPorId(long id);
    Libros guardar(Libros libro);
    void eliminarPorId(long id);
    String buscaLibroPorTitulo(String titulo);
}
