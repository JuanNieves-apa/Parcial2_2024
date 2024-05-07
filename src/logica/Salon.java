package logica;

public class Salon {
	private String id;
	private int capacidad;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public Salon(String id, int capacidad) {
		this.id = id;
		this.capacidad = capacidad;
	}
	
	@Override
	public String toString() {		
		return this.id + "\t" + this.capacidad;
	}
}
