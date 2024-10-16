package com.mfigueroa.BibliotecaSystem.repositories;

import com.mfigueroa.BibliotecaSystem.models.Bibliotecario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecarioRepository extends JpaRepository<Bibliotecario, Long> {
}
