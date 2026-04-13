package com.example.practica.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping
    public List<Pelicula> obtenerTodas() {
        return peliculaService.obtenerTodas();
    }

    @GetMapping("/filtrar")
    public List<Pelicula> filtrar(
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) Integer anio) {
        return peliculaService.obtenerConFiltros(genero, anio);
    }

    @PostMapping
    public Pelicula agregar(@RequestBody Pelicula pelicula) {
        return peliculaService.agregar(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        return peliculaService.actualizar(id, pelicula);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        boolean eliminado = peliculaService.eliminar(id);
        return eliminado ? "Película eliminada" : "Película no encontrada";
    }
}