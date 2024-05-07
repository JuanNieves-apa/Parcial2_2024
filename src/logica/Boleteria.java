package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Boleteria {
	private HashMap<Integer, Evento> eventos;
	private ArrayList<Salon> salones;
	private HashMap<Integer, Cliente> clientes;
	private ArrayList<Boleta> boletas;
	
	public Boleteria() {
		this.eventos = new HashMap<Integer, Evento>();
		this.salones = new ArrayList<Salon>();
		this.clientes = new HashMap<Integer, Cliente>();
		this.boletas = new ArrayList<Boleta>();
	}
	
	public void crearSalon(String id, int capacidad) throws Exception {
		if(existeSalon(id)) {
			throw new Exception("Ya existe el salon");
		}else {
			Salon nuevoSalon = new Salon(id, capacidad);
			this.salones.add(nuevoSalon);
		}
	}
	
	public boolean existeSalon(String id) {
		for(Salon salon : this.salones) {
			if(salon.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	public Salon buscarSalon(String idSalon) {
		for(Salon salon : this.salones) {
			if(salon.getId().equals(idSalon)) {
				return salon;
			}
		}
		return null;
	}

	public void crearEvento(int id, String nombre, Date fecha, String idSalon) throws Exception {
		if(this.eventos.containsKey(id)) {
			throw new Exception("Id del evento ya existe");
		}else if(!this.existeSalon(idSalon)) {
			throw new Exception("El salon no existe");
		}else {
			Salon salonBuscado = buscarSalon(idSalon);
			Evento nuevoEvento = new Evento(id, nombre, fecha, salonBuscado);
			this.eventos.put(id, nuevoEvento);
		}
	}
	
	public void crearCliente(int id, String nombre, String apellido) throws Exception {
		if(this.clientes.containsKey(id)) {
			throw new Exception("El cliente ya existe");
		}else {
			Cliente nuevoCliente = new Cliente(id, nombre, apellido);
			this.clientes.put(id, nuevoCliente);
		}
	}
	
	public void crearBoleta(int numero, int idEvento, int idCliente) throws Exception {
		if(!this.eventos.containsKey(idEvento)) {
			throw new Exception("Evento no existe");
		}else if(!this.clientes.containsKey(idCliente)) {
			throw new Exception("Cliente no existe");
		}else {
			Boleta nuevaBoleta = new Boleta(numero, this.clientes.get(idCliente), this.eventos.get(idEvento));
			this.boletas.add(nuevaBoleta);
		}
	}
	
	public ArrayList<String> consultarEventos(){
		ArrayList<String> listaEventos = new ArrayList<String>();
		for(Integer idEvento : this.eventos.keySet()) {
			listaEventos.add(this.eventos.get(idEvento).toString());			
		}
		return listaEventos;
	}
	
}
