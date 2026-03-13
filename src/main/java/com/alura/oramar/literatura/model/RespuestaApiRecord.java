package com.alura.oramar.literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestaApiRecord(

        @JsonAlias("results")
        List<LibroRecord> libros

) {}