# Réplica Fiel — Curso Completo de Java Spring Boot desde Cero (INFORMATICONFIG)

Colección consolidada de los **5 proyectos Maven** construidos a lo largo de los **48 videos** del curso de Spring Boot de INFORMATICONFIG, auditados para garantizar consistencia de paquetes, imports, versiones estables de Spring Boot y empaquetado sin conflictos.

## Mapa de proyectos vs. videos del curso

| Carpeta | Videos | Puerto | Temas principales | Endpoints clave |
| :--- | :---: | :---: | :--- | :--- |
| `01-springboot-app1` | 3 – 18 | `9525` | MVC, Thymeleaf, `@RestController`, `@RequestMapping`, `ClaseDTO`, `@ModelAttribute`, `@RequestParam`, `@PathVariable`, `@PostMapping`, `@Value` | `/detalles_info`, `/api/detalles_info2`, `/api/parametros/detalle`, `/api/variable/pagina1/{mensaje}`, `POST /api/variable/solicitud`, `/api/variable/valores` |
| `02-libreria` | 20 – 26 | `8081` | Inyección de Dependencias (IoC), inmutabilidad, `Cloneable`, interfaces `IRepoLibros` / `IServicioLibro`, `@Component` y `@Autowired` | `/api/libros/todos`, `/api/libros/{id}`, `/api/libros/titulo/{titulo}`, `/api/libros/clone`, `POST /api/libros`, `DELETE /api/libros/{id}` |
| `03-excepciones` | 27 – 30 | `8081` | `@ControllerAdvice`, `@ExceptionHandler` (`ArithmeticException`, `NumberFormatException`, `NullPointerException`) e `IOException` / `RuntimeException` | `/api/divide?numero=2`, `/valornulo`, `/archivo/lectura?ruta=...` |
| `04-interceptores` | 31 | `8081` | `HandlerInterceptor` (`preHandle`, `postHandle`, `afterCompletion`) y registro global con `WebMvcConfigurer` | `/saludos` |
| `05-ferreteria` | 32 – 48 | `8081` | Spring Data JPA + Hibernate + MySQL (`db_ferreteria`), DTO/Mapper, CRUD REST, Frontend **Ferretería Antillana** y **Spring Security 6** con roles en BD | `http://localhost:8081/` (login), `GET/POST /api/articulos`, `GET/PUT/DELETE /api/articulos/{id}` |

## Requisitos previos

- **JDK 25 LTS** (todos los `pom.xml` fijan `<java.version>25</java.version>`, Spring Boot `3.5.7` y Lombok `1.18.42` para soporte nativo en Java 25).
- **IntelliJ IDEA** (o VS Code con Extension Pack for Java / Spring Boot) y **Maven**.
- **MySQL 8 / XAMPP** únicamente para ejecutar `05-ferreteria`.

## Cómo ejecutar cada proyecto

Cada carpeta es un proyecto Maven independiente. Abre el `pom.xml` del módulo que quieras probar en IntelliJ IDEA (*Open as Project*) o ejecuta en CMD desde su carpeta:

```bash
cd 01-springboot-app1
mvn spring-boot:run
```

> **Nota:** Los módulos `02-libreria`, `03-excepciones`, `04-interceptores` y `05-ferreteria` usan el puerto `8081` tal como en el curso; ejecuta solo uno a la vez (o cambia `server.port` en su `application.properties`).

## Puesta en marcha de `05-ferreteria` (JPA + MySQL + Spring Security)

1. Inicia **MySQL** (XAMPP o MySQL Server 8) en el puerto `3306`.
2. Ejecuta el script `05-ferreteria/sql/db_ferreteria.sql` en MySQL Workbench o phpMyAdmin. Esto crea:
   - El esquema `db_ferreteria`.
   - La tabla `articulos` (`BIGINT AUTO_INCREMENT`) con **50 productos de ferretería**.
   - La tabla `usuarios` con el usuario inicial del Video 48:
     - **Usuario:** `user1`
     - **Contraseña:** `admin123` (almacenada como hash BCrypt válido)
     - **Rol:** `ADMIN`
3. Verifica `spring.datasource.username` y `spring.datasource.password` en `05-ferreteria/src/main/resources/application.properties` (por defecto `root` sin contraseña para XAMPP; cámbialo si usas contraseña en MySQL Workbench).
4. Arranca `FerreteriaApplication` y prueba:
   - **Navegador (panel Ferretería Antillana):** `http://localhost:8081/` → inicia sesión con `user1` / `admin123`.
   - **Postman / curl (Basic Auth):**
     ```bash
     curl -u user1:admin123 http://localhost:8081/api/articulos
     ```
5. Si deseas generar nuevos hashes BCrypt, ejecuta la clase independiente `GeneraPass.java` (el `pom.xml` ya fija `<mainClass>com.hibernate.ferreteria.FerreteriaApplication</mainClass>` para que `mvn package` no falle por tener dos métodos `main`).

## Ajustes de auditoría aplicados respecto a los errores del video

1. **Versiones estables:** Se actualizó `spring-boot-starter-parent` a `3.5.7` (con soporte oficial para JDK 25 LTS), `<java.version>` a `25` y Lombok a `1.18.42` en los módulos correspondientes.
2. **Driver MySQL actualizado:** Se sustituyó el obsoleto `com.mysql.jdbc.Driver` por `com.mysql.cj.jdbc.Driver`.
3. **Constructores vacíos para Jackson:** Se añadieron constructores sin argumentos en `Empleados`, `Libros` y `ArticulosDTO` para evitar errores de deserialización en peticiones `POST`/`PUT`.
4. **Doble `main()` en `05-ferreteria`:** Se configuró `<mainClass>` en `spring-boot-maven-plugin` y el procesador de anotaciones de Lombok en `maven-compiler-plugin` para que `mvn clean package` compile sin errores desde consola.
5. **Archivo de prueba en `03-excepciones`:** Se incluyó `03-excepciones/prueba.txt` para probar de inmediato `/archivo/lectura?ruta=...`.
