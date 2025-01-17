package com.consultorlibros.controlador;

import com.consultorlibros.modelo.Libro;
import com.consultorlibros.servicio.LibroServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroControlador {

        @Autowired
        private LibroServicio libroServicio;

        @PostMapping("/ingresar")
        public Libro ingresarLibro(@RequestBody Libro libro) {
                return libroServicio.guardarLibro(libro);
        }

        @GetMapping("/consultar")
        public List<Libro> consultarLibros() {
                return libroServicio.obtenerTodosLosLibros();
        }

        @GetMapping("/autores")
        public List<String> listarAutores() {
                return libroServicio.listarAutores();
        }

        @GetMapping("/autoresVivos/{anio}")
        public List<String> listarAutoresVivos(@PathVariable int anio) {
                return libroServicio.listarAutoresVivos(anio);
        }

        @GetMapping("/idioma/{idioma}")
        public List<Libro> listarLibrosPorIdioma(@PathVariable String idioma) {
                return libroServicio.listarLibrosPorIdioma(idioma);
        }

        @GetMapping("/consultarCompleto")
        public List<Libro> consultarLibrosCompletos() {
                return libroServicio.obtenerLibrosCompletos();
        }
}
