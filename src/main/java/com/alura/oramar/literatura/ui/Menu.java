package com.alura.oramar.literatura.ui;

public class Menu {

    private final String menu = """
            1 - Buscar libro por título
            2 - Listar libros registrados
            3 - Listar autores registrados
            4 - Listar autores vivos en un determinado año
            5 - Listar libros por idioma
            0 - Salir
            
            Elija una opción: 
            """;

    private final String bienvenida = "Bienvenido a LiterAlura";

    public String getMenu() {
        return menu;
    }

    public String getBienvenida() {
        return bienvenida;
    }
}