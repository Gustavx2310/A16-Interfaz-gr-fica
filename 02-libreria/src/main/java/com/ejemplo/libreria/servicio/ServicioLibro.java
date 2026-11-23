package com.ejemplo.libreria.servicio;

import com.ejemplo.libreria.model.Libros;
import com.ejemplo.libreria.repolibros.IRepoLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioLibro implements IServicioLibro {

    private final IRepoLibros iRepo;

    @Autowired
    public ServicioLibro(IRepoLibros iRepo) {
        this.iRepo = iRepo;
    }

    @Override
    public List<Libros> obtenerTodos() {
        return iRepo.findAll();
    }

    @Override
    public Optional<Libros> obtenerPorId(long id) {
        return iRepo.findById(id);
    }

    @Override
    public Libros guardar(Libros libro) {
        iRepo.save(libro);
        return libro;
    }

    @Override
    public void eliminarPorId(long id) {
        iRepo.deleteById(id);
    }

    @Override
    public String buscaLibroPorTitulo(String titulo) {
        boolean encontrado = iRepo.findAll().stream()
                .anyMatch(l -> l.getTitulo() != null && l.getTitulo().equalsIgnoreCase(titulo));
        return encontrado ? "Libro encontrado" : "Libro no encontrado";
    }
}
