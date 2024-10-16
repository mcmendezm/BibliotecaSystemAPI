package com.mfigueroa.BibliotecaSystem.controllers;

import com.mfigueroa.BibliotecaSystem.models.Prestamo;
import com.mfigueroa.BibliotecaSystem.services.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {
    @Autowired
    private PrestamoService prestamoService;

    @PostMapping
    public Prestamo crearPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.guardarPrestamo(prestamo);
    }

    @GetMapping
    public List<Prestamo> obtenerPrestamos() {
        return prestamoService.obtenerTodosLosPrestamos();
    }

    // GET por ID
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtenerPrestamoPorId(@PathVariable Long id) {
        Optional<Prestamo> prestamo = prestamoService.obtenerPrestamoPorId(id);
        return prestamo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminarPrestamo(@PathVariable Long id) {
        prestamoService.eliminarPrestamo(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizarPrestamo(@PathVariable Long id, @RequestBody Prestamo prestamoActualizado) {
        return prestamoService.actualizarPrestamo(id, prestamoActualizado);
    }
}
