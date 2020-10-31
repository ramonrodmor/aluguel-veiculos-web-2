package cc.ppi.rest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cc.ppi.jdbc.dao.ClienteDao;
import cc.ppi.jdbc.modelo.ClienteList;

@Path("/clientes")
public class Clientes {
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteList listaDisponiveisJson () {
		ClienteDao dao = new ClienteDao();
		ClienteList clientes = new ClienteList();
		clientes.setClientes(dao.getLista());
		
		return clientes;
	}
	
	@GET
	@Path("/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ClienteList listaDisponiveisXml () {
		ClienteDao dao = new ClienteDao();
		ClienteList clientes = new ClienteList();
		clientes.setClientes(dao.getLista());
		
		return clientes;
	}
	
	@GET
	@Path("/{chave}/json")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteList clienteJson (@PathParam("chave") String chave) {
		ClienteDao dao = new ClienteDao();
		ClienteList clientes = new ClienteList();
		clientes.setClientes(dao.getBusca(chave));
		
		return clientes;
	}
	
	@GET
	@Path("/{chave}/xml")
	@Produces(MediaType.APPLICATION_XML)
	public ClienteList clienteXml (@PathParam("chave") String chave) {
		ClienteDao dao = new ClienteDao();
		ClienteList clientes = new ClienteList();
		clientes.setClientes(dao.getBusca(chave));
		
		return clientes;
	}
}
