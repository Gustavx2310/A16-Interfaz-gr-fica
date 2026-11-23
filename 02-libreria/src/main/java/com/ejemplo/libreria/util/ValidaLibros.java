package com.ejemplo.libreria.util;

import com.ejemplo.libreria.model.Libros;
import org.springframework.stereotype.Component;

@Component
public class ValidaLibros {

    public boolean tituloValido(Libros libro) {
        return libro != null && libro.getTitulo() != null && !libro.getTitulo().isBlank();
    }
}
