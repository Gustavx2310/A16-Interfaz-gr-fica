package com.informaticonfig.spring.app1.controllers;

import com.informaticonfig.spring.app1.models.dto.ClaseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EjemploRestController {

    @GetMapping(path = "/detalles_info2")
    public ClaseDTO claseDto() {
        ClaseDTO usuario1 = new ClaseDTO();
        usuario1.setTitulo("Administrador");
        usuario1.setUsuario("Informaticonfig");
        return usuario1;
    }
}
