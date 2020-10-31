package cc.ppi.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cc.ppi.jdbc.dao.VeiculoDao;
import cc.ppi.jdbc.modelo.Veiculo;
import cc.ppi.jdbc.modelo.VeiculoList;

@Path("/veiculos")
public class Veiculos {

	@GET
	@Path("/disponiveisJson")
	@Produces(MediaType.APPLICATION_JSON)
	public VeiculoList listaDisponiveisJson() {
		VeiculoDao dao = new VeiculoDao();
		VeiculoList veiculos = new VeiculoList();
		veiculos.setVeiculos(dao.getDisponivel());

		return veiculos;
	}

	@GET
	@Path("/disponiveisXml")
	@Produces(MediaType.APPLICATION_XML)
	public VeiculoList listaDisponiveisXml() {
		VeiculoDao dao = new VeiculoDao();
		VeiculoList veiculos = new VeiculoList();
		veiculos.setVeiculos(dao.getDisponivel());

		return veiculos;
	}

	@GET
	@Path("/{chave}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public VeiculoList renavanJson(@PathParam("chave") String chave) {
		VeiculoDao dao = new VeiculoDao();
		VeiculoList veiculos = new VeiculoList();
		veiculos.setVeiculos(dao.getBusca(chave));

		return veiculos;
	}

	@GET
	@Path("/{chave}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public VeiculoList renavanXml(@PathParam("chave") String chave) {
		VeiculoDao dao = new VeiculoDao();
		VeiculoList veiculos = new VeiculoList();

		veiculos.setVeiculos(dao.getBusca(chave));

		return veiculos;
	}

	@GET
	@Path("/tipo/{chave}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public VeiculoList tipoJson(@PathParam("chave") String chave) {
		VeiculoDao dao = new VeiculoDao();
		VeiculoList veiculos = new VeiculoList();
		veiculos.setVeiculos(dao.getBuscaTipo(chave));

		return veiculos;
	}

	@GET
	@Path("/tipo/{chave}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public VeiculoList tipoXml(@PathParam("chave") String chave) {
		VeiculoDao dao = new VeiculoDao();
		VeiculoList veiculos = new VeiculoList();

		veiculos.setVeiculos(dao.getBuscaTipo(chave));

		return veiculos;
	}

	@DELETE
	@Path("/remove/{chave}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public VeiculoList deletarJson(@PathParam("chave") String chave) {
		VeiculoDao dao = new VeiculoDao();
		VeiculoList veiculos = new VeiculoList();
		veiculos.setVeiculos(dao.getBusca(chave));
		Veiculo removido = new Veiculo();
		removido.setRenavan(chave);
		dao.remove(removido);

		return veiculos;
	}

	@DELETE
	@Path("/remove/{chave}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public VeiculoList deletarXml(@PathParam("chave") String chave) {
		VeiculoDao dao = new VeiculoDao();
		VeiculoList veiculos = new VeiculoList();
		veiculos.setVeiculos(dao.getBusca(chave));
		Veiculo removido = new Veiculo();
		removido.setRenavan(chave);
		dao.remove(removido);

		return veiculos;
	}

	@PUT
	@Path("/alteraJson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public VeiculoList alteraJson(Veiculo novo) {
		System.out.println(novo.getNome());
		VeiculoDao dao = new VeiculoDao();
		dao.altera(novo);
		VeiculoList veiculos = new VeiculoList();
		veiculos.setVeiculos(dao.getBusca(novo.getRenavan()));
		return veiculos;
	}

	@PUT
	@Path("/alteraXml")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public VeiculoList alteraXml(Veiculo novo) {
		VeiculoDao dao = new VeiculoDao();
		dao.altera(novo);
		VeiculoList veiculos = new VeiculoList();
		veiculos.setVeiculos(dao.getBusca(novo.getRenavan()));
		return veiculos;
	}
}
