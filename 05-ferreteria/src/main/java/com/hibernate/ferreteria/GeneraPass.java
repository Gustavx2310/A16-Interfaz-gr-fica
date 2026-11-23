package com.hibernate.ferreteria;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Utilidad independiente del Video 48 para generar hashes BCrypt
 * e insertarlos en la tabla usuarios de MySQL.
 */
public class GeneraPass {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("admin123"));
    }
}
