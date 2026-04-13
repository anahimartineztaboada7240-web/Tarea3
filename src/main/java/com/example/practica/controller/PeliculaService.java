package com.example.practica.controller;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PeliculaService {

    private List<Pelicula> peliculas = new ArrayList<>(List.of(
            new Pelicula(1L, "Avatar", "James Cameron", 2009, "Ciencia Ficción", 7.8, 162),
            new Pelicula(2L, "Titanic", "James Cameron", 1997, "Romance", 7.9, 194),
            new Pelicula(3L, "El Señor de los Anillos", "Peter Jackson", 2001, "Fantasía", 8.8, 178),
            new Pelicula(4L, "Joker", "Todd Phillips", 2019, "Drama", 8.4, 122),
            new Pelicula(5L, "Spider-Man", "Sam Raimi", 2002, "Acción", 7.4, 121)));

    public List<Pelicula> obtenerTodas() {
        return peliculas;
    }

    public List<Pelicula> obtenerConFiltros(String genero, Integer anio) {
        return peliculas.stream()
                .filter(p -> genero == null || p.getGenero().equalsIgnoreCase(genero))
                .filter(p -> anio == null || p.getAnio() == anio)
                .collect(Collectors.toList());
    }

    public Pelicula agregar(Pelicula pelicula) {
        pelicula.setId((long) (peliculas.size() + 1));
        peliculas.add(pelicula);
        return pelicula;
    }

    public Pelicula actualizar(Long id, Pelicula peliculaActualizada) {
        for (int i = 0; i < peliculas.size(); i++) {
            if (peliculas.get(i).getId().equals(id)) {
                peliculaActualizada.setId(id);
                peliculas.set(i, peliculaActualizada);
                return peliculaActualizada;
            }
        }
        return null;
    }

    public boolean eliminar(Long id) {
        return peliculas.removeIf(p -> p.getId().equals(id));
    }
}