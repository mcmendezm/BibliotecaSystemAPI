package com.mfigueroa.BibliotecaSystem.repositories;

import com.mfigueroa.BibliotecaSystem.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
