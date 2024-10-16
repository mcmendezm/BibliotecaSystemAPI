package com.mfigueroa.BibliotecaSystem.services;

import com.mfigueroa.BibliotecaSystem.models.Persona;
import com.mfigueroa.BibliotecaSystem.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    public Persona guardarPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    public Optional<Persona> obtenerPersonaPorId(Long id) {
        return personaRepository.findById(id);
    }

    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }

    public ResponseEntity<Persona> actualizarPersona(Long id, Persona personaActualizada) {
        Optional<Persona> persona = personaRepository.findById(id);

        if (persona.isPresent()) {
            Persona personaExistente = persona.get();
            personaExistente.setNombre(personaActualizada.getNombre());
            personaExistente.setApellido(personaActualizada.getApellido());
            personaExistente.setTipo(personaActualizada.getTipo());
            personaRepository.save(personaExistente);
            return ResponseEntity.ok(personaExistente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
