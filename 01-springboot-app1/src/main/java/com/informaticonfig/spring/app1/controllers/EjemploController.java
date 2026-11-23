package com.informaticonfig.spring.app1.controllers;

import com.informaticonfig.spring.app1.models.Empleados;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class EjemploController {

    @GetMapping("/detalles_info")
    public String info(Model model) {
        Empleados empleado1 = new Empleados(
                "Juan", "Rodriguez", "Calle primera no. 1", "Gerente",
                35, 123456789, 1
        );
        model.addAttribute("Empleado", empleado1);
        return "detalles_info";
    }

    @ModelAttribute("Empleados")
    public List<Empleados> listaEmpleados() {
        return Arrays.asList(
                new Empleados("María", "Perez", "Calle segunda no. 2", "Secretaria", 20, 123654987, 2),
                new Empleados("Juan", "Rodriguez", "Calle primera no. 1", "Gerente", 35, 123456789, 1),
                new Empleados("Luis", "Martínez", "Calle tercera no. 3", "Contador", 28, 987654321, 3),
                new Empleados("Ana", "Gómez", "Calle cuarta no. 4", "Analista", 25, 456789123, 4),
                new Empleados("Carlos", "López", "Calle quinta no. 5", "Desarrollador", 30, 321654987, 5)
        );
    }
}
