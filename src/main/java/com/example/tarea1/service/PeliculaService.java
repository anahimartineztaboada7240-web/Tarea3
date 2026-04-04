package com.example.tarea1.service;

import com.example.tarea1.model.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaService {

    private List<Pelicula> peliculas = new ArrayList<>(List.of(
    new Pelicula(1L, "Inception",     "Christopher Nolan",      2010, "Ciencia Ficción", 8.8, 148),
    new Pelicula(2L, "El Padrino",    "Francis Ford Coppola",   1972, "Crimen",          9.2, 175),
    new Pelicula(3L, "Interstellar",  "Christopher Nolan",      2014, "Ciencia Ficción", 8.6, 169),
    new Pelicula(4L, "Parasite",      "Bong Joon-ho",           2019, "Thriller",        8.5, 132),
    new Pelicula(5L, "El Rey León",   "Roger Allers",           1994, "Animación",       8.5, 88)
));

    public List<Pelicula> obtenerTodas() {
        return peliculas;
    }

    public List<Pelicula> obtenerConFiltros(String genero, Integer anio) {
        return peliculas.stream()
            .filter(p -> genero == null || p.getGenero().equalsIgnoreCase(genero))
            .filter(p -> anio == null || p.getAnio() == anio)
            .collect(Collectors.toList());
    }
    public Pelicula buscarPorId(Long id) {
        for (Pelicula p : peliculas) {
            if (p.getId().longValue() == id.longValue()) {
                return p;
            }
        }
        return null;
    }
    public Pelicula agregar(Pelicula pelicula) {
        peliculas.add(pelicula);
        return pelicula;
    }

    public void eliminar(Long id) {
        peliculas.removeIf(p -> p.getId().equals(id));
    }
}