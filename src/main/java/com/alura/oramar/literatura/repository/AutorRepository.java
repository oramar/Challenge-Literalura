package com.alura.oramar.literatura.repository;

import com.alura.oramar.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    @Query("SELECT a FROM Autor a WHERE LOWER(a.nombre) = LOWER(:nombre)")
    Optional<Autor> obtenerAutorPorNombre(String nombre);

    @Query("""
            SELECT a FROM Autor a
            WHERE :anio >= a.fechaNacimiento
            AND (a.fechaFallecimiento IS NULL OR :anio <= a.fechaFallecimiento)
            """)
    List<Autor> obtenerAutoresVivosEnAnio(int anio);
}