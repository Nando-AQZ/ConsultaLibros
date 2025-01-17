package com.consultorlibros.console;

import com.consultorlibros.modelo.Libro;
import com.consultorlibros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component

public class ComandoConsola implements CommandLineRunner{


    @Autowired
    private LibroServicio libroServicio;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpciones:");
            System.out.println("1. Ingresar libro");
            System.out.println("2. Consultar libros");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores vivos en un año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el idioma del libro: ");
                    String idioma = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación: ");
                    int anioPublicacion = scanner.nextInt();
                    scanner.nextLine();  // Consumir el salto de línea
                    System.out.print("Ingrese los autores (separados por coma): ");
                    String autoresInput = scanner.nextLine();
                    List<String> autoresList = List.of(autoresInput.split(","));
                    Libro libro = new Libro();
                    libro.setTitulo(titulo);
                    libro.setIdioma(idioma);
                    libro.setAnioPublicacion(anioPublicacion);
                    libro.setAutores(autoresList);
                    libroServicio.guardarLibro(libro);
                    System.out.println("Libro ingresado con éxito.");
                    break;
                case 2:

                    List<Libro> libros = libroServicio.obtenerTodosLosLibros();

                    libros.forEach(lib -> System.out.println(lib.getTitulo()));
                    break;
                case 3:
                    List<String> listaAutores = libroServicio.listarAutores();
                    System.out.println("********AUTORES**************");
                    listaAutores.forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Ingrese el año para ver los autores vivos: ");
                    int anio = scanner.nextInt();
                    List<String> autoresVivos = libroServicio.listarAutoresVivos(anio);
                    System.out.println("********AUTORES**************");
                    autoresVivos.forEach(System.out::println);
                    break;
                case 5:
                    System.out.print("Ingrese el idioma para listar los libros: ");
                    String idiomaConsulta = scanner.nextLine();
                    List<Libro> librosPorIdioma = libroServicio.listarLibrosPorIdioma(idiomaConsulta);
                    System.out.println("********LIBRO**************");
                    librosPorIdioma.forEach(libroPorIdioma -> System.out.println(libroPorIdioma.getTitulo()));
                    break;
                case 6:
                    System.out.println("¡Hasta pronto!");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
