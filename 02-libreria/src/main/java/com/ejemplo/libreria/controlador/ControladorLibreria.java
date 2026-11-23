package com.ejemplo.libreria.controlador;

import com.ejemplo.libreria.model.Libros;
import com.ejemplo.libreria.servicio.IServicioLibro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class ControladorLibreria {

    private final IServicioLibro iServicio;

    public ControladorLibreria(IServicioLibro iServicio) {
        this.iServicio = iServicio;
    }

    @GetMapping("/todos")
    public List<Libros> listar() {
        return iServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libros> obtenerPorId(@PathVariable long id) {
        Optional<Libros> libro = iServicio.obtenerPorId(id);
        return libro.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/titulo/{titulo}")
    public String buscaPorTitulo(@PathVariable String titulo) {
        return iServicio.buscaLibroPorTitulo(titulo);
    }

    // Demostracion de interfaz Cloneable (Video 24)
    @GetMapping("/clone")
    public String probarClone() {
        Libros original = new Libros(1L, "Miguel de Cervantes", "El Quijote", LocalDate.of(1605, 1, 16));
        Libros copia = original.clone();
        return "Original: " + original.toString() + " | Copia: " + copia.toString();
    }

    @PostMapping
    public ResponseEntity<Libros> crear(@RequestBody Libros libro) {
        iServicio.guardar(libro);
        return ResponseEntity.ok(libro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable long id) {
        iServicio.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
