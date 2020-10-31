package cc.ppi.jdbc.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteList {

	private List<Cliente> clientes;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> list) {
		this.clientes = list;
	}

}
