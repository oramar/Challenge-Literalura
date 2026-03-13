package com.alura.oramar.literatura.service;

import com.alura.oramar.literatura.model.Autor;
import com.alura.oramar.literatura.repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Optional<Autor> obtenerAutorPorNombre(String nombre){
        return autorRepository.obtenerAutorPorNombre(nombre);
    }

    public void guardarAutor(Autor autor){
        autorRepository.save(autor);
    }

    public List<Autor> obtenerTodosLosAutores(){
        return autorRepository.findAll();
    }

    public List<Autor> obtenerAutoresVivosEnAnio(int anio){
        return autorRepository.obtenerAutoresVivosEnAnio(anio);
    }
}