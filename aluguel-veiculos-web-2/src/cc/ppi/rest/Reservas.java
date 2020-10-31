package cc.ppi.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cc.ppi.jdbc.dao.ReservaDao;
import cc.ppi.jdbc.modelo.ReservaList;

@Path("/reservas")
public class Reservas {
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ReservaList listaDisponiveisJson () {
		ReservaDao dao = new ReservaDao();
		ReservaList reservas = new ReservaList();
		reservas.setReservas(dao.getLista());
		
		return reservas;
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ReservaList listaDisponiveisXml () {
		ReservaDao dao = new ReservaDao();
		ReservaList reservas = new ReservaList();
		reservas.setReservas(dao.getLista());
		
		return reservas;
	}
	
	@GET
	@Path("/{chave}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ReservaList reservaJson (@PathParam("chave") String chave) {
		ReservaDao dao = new ReservaDao();
		ReservaList reservas = new ReservaList();
		reservas.setReservas(dao.getBuscaCodigo(chave));
		
		return reservas;
	}
	
	@GET
	@Path("/{chave}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ReservaList reservaXml (@PathParam("chave") String chave) {
		ReservaDao dao = new ReservaDao();
		ReservaList reservas = new ReservaList();
		reservas.setReservas(dao.getBuscaCodigo(chave));
		
		return reservas;
	}
}
