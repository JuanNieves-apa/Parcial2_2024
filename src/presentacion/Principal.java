package presentacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import logica.Boleteria;

public class Principal {
	private Boleteria boleteria;

	public Principal() {
		this.boleteria = new Boleteria();
		menu();
	}
	
	private void menu() {
		int op = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Digite una opcion");
			System.out.println("0. Salir");
			System.out.println("1. Crear Salon");
			System.out.println("2. Crear Evento");
			System.out.println("3. Crear Cliente");
			System.out.println("4. Crear Boleta");
			System.out.println("5. Consultar Eventos");
			op = sc.nextInt();
			try {
				if(op == 1) {
					crearSalon(sc);
				}else if(op == 2) {
					crearEvento(sc);
				}else if(op == 5) {
					consultarEventos(sc);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} 
			
		}while(op != 0);
		sc.close();
	}

	private void consultarEventos(Scanner sc) {
		for(String textoEvento : this.boleteria.consultarEventos()) {
			System.out.println(textoEvento);
		}
	}

	private void crearEvento(Scanner sc) throws Exception {
		System.out.println("Digite id del evento");
		int id = sc.nextInt();
		System.out.println("Digite nombre del evento");
		String nombre = sc.next();
		System.out.println("Digite fecha del evento");
		String fechaString = sc.next();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date fecha = formatter.parse(fechaString);
		System.out.println("Digite id del salon del evento");
		String idSalon = sc.next();
		this.boleteria.crearEvento(id, nombre, fecha, idSalon);
	}

	private void crearSalon(Scanner sc) throws Exception {
		System.out.println("Digite id del salon");
		String id = sc.next();
		System.out.println("Digite capacidad del salon");
		int capacidad = sc.nextInt();
		this.boleteria.crearSalon(id, capacidad);
	}

	
	public static void main(String[] args) {
		new Principal();
	}
}
