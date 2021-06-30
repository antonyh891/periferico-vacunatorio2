package webService;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Manejador.ManejadorVacunatoriosLocal;

@RequestScoped
@Path("/vacunatorio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class VacunatorioRest {
	
	@EJB
	private ManejadorVacunatoriosLocal manejador;
	
	public VacunatorioRest() throws NamingException {		

	}
	
	@POST
	@Path("/asignarVacunadores")
	public Response asignarVacunadores(List<Integer> cedulas)  {
		
		Boolean valor = manejador.asignarVacunadores(cedulas);
			
		return Response
          		 .status(Response.Status.OK)
          		 .entity(valor)
          		 .build();
	}
	
	@GET
	@Path("/obtenerPuesto")
	public Response consultarVacunadorPuestoXFecha (@QueryParam("cedula") int cedula ) {
		Integer puesto = manejador.consultarVacunadorPuesto(cedula);
		return Response
         		 .status(Response.Status.OK)
         		 .entity(puesto)
         		 .build();
	}
}
