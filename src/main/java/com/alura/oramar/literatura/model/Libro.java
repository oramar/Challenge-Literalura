package com.alura.oramar.literatura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Enumerated(EnumType.STRING)
    private Idioma idioma;

    private Integer numeroDeDescargas;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public Libro() {}

    public Libro(LibroRecord libro) {

        this.titulo = libro.titulo();
        this.numeroDeDescargas = libro.numeroDeDescargas();

        if (!libro.idiomas().isEmpty()) {
            this.idioma = Idioma.stringToEnum(libro.idiomas().get(0));
        }

        if (!libro.autores().isEmpty()) {
            this.autor = new Autor(libro.autores().get(0));
        }
    }

    public Long getId() { return id; }

    public String getTitulo() { return titulo; }

    public Idioma getIdioma() { return idioma; }

    public Integer getNumeroDeDescargas() { return numeroDeDescargas; }

    public Autor getAutor() { return autor; }

    public void setAutor(Autor autor) { this.autor = autor; }

    public void imprimirInformacion() {

        System.out.println("***** Libro *****");
        System.out.println("Título: " + titulo);

        if (autor != null) {
            System.out.println("Autor: " + autor.getNombre());
        }

        System.out.println("Idioma: " + idioma);
        System.out.println("Número de Descargas: " + numeroDeDescargas);
        System.out.println();
    }
}