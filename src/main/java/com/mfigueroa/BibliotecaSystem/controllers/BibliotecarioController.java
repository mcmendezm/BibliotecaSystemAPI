package com.mfigueroa.BibliotecaSystem.controllers;

import com.mfigueroa.BibliotecaSystem.models.Bibliotecario;
import com.mfigueroa.BibliotecaSystem.services.BibliotecarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {
    @Autowired
    private BibliotecarioService bibliotecarioService;

    @PostMapping
    public Bibliotecario crearBibliotecario(@RequestBody Bibliotecario bibliotecario) {
        return bibliotecarioService.guardarBibliotecario(bibliotecario);
    }

    @GetMapping
    public List<Bibliotecario> obtenerBibliotecarios() {
        return bibliotecarioService.obtenerTodosLosBibliotecarios();
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bibliotecario> obtenerBibliotecarioPorId(@PathVariable Long id) {
        Optional<Bibliotecario> bibliotecario = bibliotecarioService.obtenerBibliotecarioPorId(id);
        return bibliotecario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminarBibliotecario(@PathVariable Long id) {
        bibliotecarioService.eliminarBibliotecario(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bibliotecario> actualizarBibliotecario(@PathVariable Long id, @RequestBody Bibliotecario bibliotecarioActualizado) {
        return bibliotecarioService.actualizarBibliotecario(id, bibliotecarioActualizado);
    }
}
