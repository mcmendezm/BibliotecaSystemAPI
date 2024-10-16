package com.mfigueroa.BibliotecaSystem.repositories;

import com.mfigueroa.BibliotecaSystem.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
