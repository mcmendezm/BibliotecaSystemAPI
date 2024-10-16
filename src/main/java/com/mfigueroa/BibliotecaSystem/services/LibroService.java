package com.mfigueroa.BibliotecaSystem.services;

import com.mfigueroa.BibliotecaSystem.models.Libro;
import com.mfigueroa.BibliotecaSystem.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> obtenerLibroPorId(Long id) {
        return libroRepository.findById(id);
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public ResponseEntity<Libro> actualizarLibro(Long id, Libro libroActualizado) {
        Optional<Libro> libro = libroRepository.findById(id);

        if (libro.isPresent()) {
            Libro libroExistente = libro.get();
            libroExistente.setTitulo(libroActualizado.getTitulo());
            libroExistente.setAutor(libroActualizado.getAutor());
            libroExistente.setIsbn(libroActualizado.getIsbn());
            libroExistente.setDisponible(libroActualizado.isDisponible());
            libroRepository.save(libroExistente);
            return ResponseEntity.ok(libroExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
