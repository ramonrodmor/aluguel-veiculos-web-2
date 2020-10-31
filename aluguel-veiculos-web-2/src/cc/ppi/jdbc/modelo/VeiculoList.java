package cc.ppi.jdbc.modelo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VeiculoList {

	private List<Veiculo> veiculos;

	public List<Veiculo> getVeiculos() {
		return veiculos;
	}

	public void setVeiculos(List<Veiculo> list) {
		this.veiculos = list;
	}

}
