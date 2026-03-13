package com.alura.oramar.literatura.service;

import com.alura.oramar.literatura.api.PeticionAPI;
import com.alura.oramar.literatura.model.*;
import com.alura.oramar.literatura.util.JsonParser;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MenuService {

    private final PeticionAPI peticionAPI;
    private final Scanner sc = new Scanner(System.in);

    private final LibroService libroService;
    private final AutorService autorService;
    private final JsonParser jsonParser;

    public MenuService(PeticionAPI peticionAPI,
                       LibroService libroService,
                       AutorService autorService,
                       JsonParser jsonParser) {

        this.peticionAPI = peticionAPI;
        this.libroService = libroService;
        this.autorService = autorService;
        this.jsonParser = jsonParser;
    }

    public void guardarLibro() {

        List<LibroRecord> librosObtenidos = obtenerLibrosApi();

        if (librosObtenidos.isEmpty()) {
            System.out.println("No se encontró ningún libro.");
            return;
        }

        System.out.println("Escoja un libro para guardar [0-Cancelar]:");

        for (int i = 0; i < librosObtenidos.size(); i++) {

            LibroRecord l = librosObtenidos.get(i);

            String autor = (!l.autores().isEmpty())
                    ? l.autores().get(0).nombre()
                    : "Desconocido";

            String idioma = (!l.idiomas().isEmpty())
                    ? l.idiomas().get(0)
                    : "N/A";

            System.out.println((i + 1) + " - "
                    + l.titulo()
                    + " | Idioma: " + idioma
                    + " | Autor: " + autor);
        }

        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 0) return;

        if (opcion < 1 || opcion > librosObtenidos.size()) {
            System.out.println("Error: opción no válida.");
            return;
        }

        LibroRecord libroRecord = librosObtenidos.get(opcion - 1);

        if (libroService.obtenerLibroPorNombre(libroRecord.titulo()).isPresent()) {
            System.out.println("Error: este libro ya está registrado.");
            return;
        }

        Libro libro = new Libro(libroRecord);

        if (libro.getAutor() != null) {

            Optional<Autor> autorExistente =
                    autorService.obtenerAutorPorNombre(libro.getAutor().getNombre());

            if (autorExistente.isPresent()) {
                libro.setAutor(autorExistente.get());
            } else {
                autorService.guardarAutor(libro.getAutor());
            }
        }

        libroService.guardarLibro(libro);

        System.out.println("Libro guardado exitosamente.");
    }

    public List<LibroRecord> obtenerLibrosApi() {

        System.out.print("Ingrese el título del libro [0-Cancelar]: ");
        String titulo = sc.nextLine();

        if (titulo.equals("0")) {
            return Collections.emptyList();
        }

        String json = peticionAPI.obtenerDatos(titulo);

        RespuestaApiRecord respuesta =
                jsonParser.convertirDatos(json, RespuestaApiRecord.class);

        if (respuesta == null || respuesta.libros() == null) {
            return Collections.emptyList();
        }

        return respuesta.libros();
    }

    public void listarLibrosRegistrados() {
        libroService.obtenerTodosLosLibros()
                .forEach(Libro::imprimirInformacion);
    }

    public void listarAutoresRegistrados() {
        autorService.obtenerTodosLosAutores()
                .forEach(Autor::imprimirInformacion);
    }

    public void listarAutoresVivosEnAnio() {

        try {

            System.out.print("Ingrese año: ");
            int anio = sc.nextInt();
            sc.nextLine();

            autorService.obtenerAutoresVivosEnAnio(anio)
                    .forEach(Autor::imprimirInformacion);

        } catch (InputMismatchException e) {

            System.out.println("Error: debe ingresar un número válido.");
            sc.nextLine();
        }
    }

    public void listarLibrosPorIdioma() {

        Idioma.listarIdiomas();

        System.out.print("Ingrese el código del idioma [0-Cancelar]: ");
        String idiomaBuscado = sc.nextLine();

        if (!idiomaBuscado.equals("0")) {

            libroService.obtenerLibrosPorIdioma(
                    Idioma.stringToEnum(idiomaBuscado)
            ).forEach(Libro::imprimirInformacion);
        }
    }
}