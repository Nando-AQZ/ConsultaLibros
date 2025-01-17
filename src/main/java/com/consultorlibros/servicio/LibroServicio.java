package com.consultorlibros.servicio;


import com.consultorlibros.modelo.Libro;
import com.consultorlibros.repositorio.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Autowired
    private RestTemplate restTemplate;

    private static final String URL_API = "http://gutendex.com/books/";

    // Método para guardar un libro
    public Libro guardarLibro(Libro libro) {
        return libroRepositorio.save(libro);
    }

    // Método para obtener todos los libros
    public List<Libro> obtenerTodosLosLibros() {

        return libroRepositorio.findAll();
    }

    // Método modificado para listar autores asegurando que la sesión esté abierta
    @Transactional(readOnly = true)
    public List<String> listarAutores() {
        return libroRepositorio.findAll().stream()
                .flatMap(libro -> libro.getAutores().stream()) // Extrae los autores de todos los libros
                .distinct() // Asegura que no haya autores duplicados
                .map(autor -> "Autor: " + autor) // Agrega el prefijo "Autor: " a cada autor
                .collect(Collectors.toList()); // Recoge los autores modificados en una lista
    }

    // Método para listar autores vivos en un año
    @Transactional(readOnly = true)
    public List<String> listarAutoresVivos(int anio) {
        return libroRepositorio.findAll().stream()
                .filter(libro -> libro.getAnioPublicacion() != null && libro.getAnioPublicacion().equals(anio)) // Filtra los libros por el año
                .flatMap(libro -> libro.getAutores().stream()) // Extrae los autores de los libros filtrados
                .distinct() // Asegura que no haya autores duplicados
                .collect(Collectors.toList()); // Recoge los autores filtrados en una lista
    }

    // Método auxiliar para verificar si un autor está vivo (esto es una simplificación)
    private boolean autorEstaVivo(String autor, int anio) {
        // Lógica simplificada, podrías necesitar una API adicional o una base de datos de autores.
        return true; // Esto es un marcador
    }

    // Método para listar libros por idioma
    @Transactional(readOnly = true)
    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepositorio.findAll().stream()
                .filter(libro -> idioma.equalsIgnoreCase(libro.getIdioma()))
                .collect(Collectors.toList());
    }

    // Método para obtener libros desde una API externa
    public List<Libro> obtenerLibrosDesdeAPI() {
        return restTemplate.getForObject(URL_API, List.class);
    }

    // Método para obtener todos los libros combinando los de la base de datos y la API
    public List<Libro> obtenerLibrosCompletos() {
        List<Libro> librosDeBaseDeDatos = libroRepositorio.findAll();
        List<Libro> librosDeAPI = obtenerLibrosDesdeAPI();
        librosDeBaseDeDatos.addAll(librosDeAPI);
        return librosDeBaseDeDatos;
    }

}
