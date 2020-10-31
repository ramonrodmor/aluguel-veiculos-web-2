package cc.ppi.jdbc.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReservaList {

	private List<Reserva> reservas;

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> list) {
		this.reservas = list;
	}

}
