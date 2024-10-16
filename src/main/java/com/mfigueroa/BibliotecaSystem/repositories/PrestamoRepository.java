package com.mfigueroa.BibliotecaSystem.repositories;

import com.mfigueroa.BibliotecaSystem.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
}
