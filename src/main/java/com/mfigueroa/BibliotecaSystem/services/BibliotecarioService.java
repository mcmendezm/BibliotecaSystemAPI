package com.mfigueroa.BibliotecaSystem.services;

import com.mfigueroa.BibliotecaSystem.models.Bibliotecario;
import com.mfigueroa.BibliotecaSystem.repositories.BibliotecarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BibliotecarioService {
    @Autowired
    private BibliotecarioRepository bibliotecarioRepository;

    public Bibliotecario guardarBibliotecario(Bibliotecario bibliotecario) {
        return bibliotecarioRepository.save(bibliotecario);
    }

    public List<Bibliotecario> obtenerTodosLosBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<Bibliotecario> obtenerBibliotecarioPorId(Long id) {
        return bibliotecarioRepository.findById(id);
    }

    public void eliminarBibliotecario(Long id) {
        bibliotecarioRepository.deleteById(id);
    }

    public ResponseEntity<Bibliotecario> actualizarBibliotecario(Long id, Bibliotecario bibliotecarioActualizado) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioRepository.findById(id);

        if (bibliotecario.isPresent()) {
            Bibliotecario bibliotecarioExistente = bibliotecario.get();
            // Suponiendo que solo actualizas los datos relacionados con persona
            bibliotecarioRepository.save(bibliotecarioExistente);
            return ResponseEntity.ok(bibliotecarioExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
