package com.alura.oramar.literatura;

import com.alura.oramar.literatura.service.MenuService;
import com.alura.oramar.literatura.ui.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private final MenuService menuService;

	public Application(MenuService menuService) {
		this.menuService = menuService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) {

		EnvLoader.loadEnv();

		Menu menu = new Menu();
		Scanner teclado = new Scanner(System.in);

		System.out.println(menu.getBienvenida());

		int opcion;

		do {

			try {

				System.out.print(menu.getMenu());
				opcion = teclado.nextInt();
				teclado.nextLine();

				switch (opcion) {

					case 1 -> menuService.guardarLibro();

					case 2 -> menuService.listarLibrosRegistrados();

					case 3 -> menuService.listarAutoresRegistrados();

					case 4 -> menuService.listarAutoresVivosEnAnio();

					case 5 -> menuService.listarLibrosPorIdioma();

					case 0 -> System.out.println("Saliendo de LiterAlura...");

					default -> System.out.println("Opción inválida");
				}

			} catch (InputMismatchException e) {

				System.out.println("Error: ingrese un número válido.");
				opcion = -1;
				teclado.nextLine();
			}

		} while (opcion != 0);

		teclado.close();
	}
}