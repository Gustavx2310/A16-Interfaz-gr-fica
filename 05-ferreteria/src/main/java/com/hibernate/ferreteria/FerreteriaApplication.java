package com.hibernate.ferreteria;

import com.hibernate.ferreteria.entity.Articulos;
import com.hibernate.ferreteria.repositorios.RepoArticulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class FerreteriaApplication implements CommandLineRunner {

    @Autowired
    private RepoArticulos repositorio;

    public static void main(String[] args) {
        SpringApplication.run(FerreteriaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Aplicación iniciada correctamente");
        List<Articulos> articulos = repositorio.findAll();
        articulos.forEach(System.out::println);
    }
}
