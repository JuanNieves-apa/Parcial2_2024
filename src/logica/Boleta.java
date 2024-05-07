package logica;

public class Boleta {
	private int numero;
	private Cliente cliente;
	private Evento evento;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Boleta(int numero, Cliente cliente, Evento evento) {
		this.numero = numero;
		this.cliente = cliente;
		this.evento = evento;
	}
	
	
	
}
