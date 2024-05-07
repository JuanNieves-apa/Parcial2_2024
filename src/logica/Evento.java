package logica;

import java.util.Date;

public class Evento {
	private int id;
	private String nombre;
	private Date fecha;
	private Salon salon;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Salon getSalon() {
		return salon;
	}
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	public Evento(int id, String nombre, Date fecha, Salon salon) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha = fecha;
		this.salon = salon;
	}
	
	@Override
	public String toString() {
		return this.id + "\t" + this.nombre + "\t" + this.fecha + "\t" + this.salon;
	}
}
