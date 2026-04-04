package com.example.tarea1.controller;

import com.example.tarea1.model.Pelicula;
import com.example.tarea1.service.PeliculaService;
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


    //ejemplo de endpoint con parametros ---> http://localhost:8080/peliculas/filtrar?titulo=Inception&anio=2010
    @GetMapping("/{id}")
    public Pelicula obtenerPorId(@PathVariable Long id) {
        return peliculaService.buscarPorId(id);
    }
    @GetMapping("/filtrar")
    public List<Pelicula> filtrar(
        @RequestParam(required = false) String genero,
        @RequestParam(required = false) Integer anio
    ) {
        return peliculaService.obtenerConFiltros(genero, anio);
    }

    @PostMapping
    public Pelicula agregar(@RequestBody Pelicula pelicula) {
        return peliculaService.agregar(pelicula);
    }

    @DeleteMapping("/peliculas/{id}")
    public void eliminar(@PathVariable Long id) {
        peliculaService.eliminar(id);
    }
}