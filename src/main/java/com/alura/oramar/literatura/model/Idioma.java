package com.alura.oramar.literatura.model;

public enum Idioma {

    es("Español"),
    en("Inglés"),
    fr("Francés"),
    pt("Portugués"),
    nd("No disponible");

    private final String idiomaCompleto;

    Idioma(String idiomaCompleto) {
        this.idiomaCompleto = idiomaCompleto;
    }

    public static Idioma stringToEnum(String texto) {

        if (texto == null) {
            return Idioma.nd;
        }

        for (Idioma idioma : Idioma.values()) {
            if (idioma.name().equalsIgnoreCase(texto)) {
                return idioma;
            }
        }

        return Idioma.nd;
    }

    public static void listarIdiomas() {

        for (Idioma idioma : Idioma.values()) {

            if (idioma != Idioma.nd) {
                System.out.println(idioma.name() + " - " + idioma.getIdiomaCompleto());
            }

        }
    }

    public String getIdiomaCompleto() {
        return idiomaCompleto;
    }
}