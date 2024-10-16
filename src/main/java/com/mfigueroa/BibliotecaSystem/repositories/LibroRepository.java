package com.mfigueroa.BibliotecaSystem.repositories;

import com.mfigueroa.BibliotecaSystem.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
