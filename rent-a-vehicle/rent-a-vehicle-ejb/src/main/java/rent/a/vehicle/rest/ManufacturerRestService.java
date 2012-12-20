package rent.a.vehicle.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import rent.a.vehicle.controller.ManufacturerAlreadyExistsException;
import rent.a.vehicle.controller.ManufacturerController;
import rent.a.vehicle.dto.ManufacturerDto;


/**
 * 
 * Rest-Service für die Behandlung von Vendors. Der Service
 * wird relativ zur in JaxRsActivater gesetzten URL eingehangen
 * 
 * Also 
 * 
 * Also http://{deinhost}:{deinport}/{deineanwendung}/rest/vendors
 * 
 * @see JaxRsActivator
 * 
 * @author marcus
 *
 */
@Stateless
@Path("/manufacturers/")
//@RolesAllowed("PowerUser")
//@org.jboss.ejb3.annotation.SecurityDomain(value="ApplicationRealm")
public class ManufacturerRestService {

	@EJB
	private ManufacturerController manufacturerController;

	/* REST-Methoden :
	   
	   		* GET zum laden einer Id oder ohne Id aller Elemente
	   		* POST zum Speichern eines Objekts auf Basis der in @Consumes definierten Transportmedientypen
	   		* PUT zum Updaten eines Objekts 
	   		* DELETE zum Löschen
	   
	   @See RestClient
	   
	*/
	
	@GET
//	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<ManufacturerDto> loadAll() {
		return manufacturerController.findAll();
	}
	
	@Produces({MediaType.APPLICATION_JSON})  // Wir geben den Vendor als JSON aus
	@Path("/{id}") // <-------------------o 
	@GET		   //                     |  relativ zum PATH wird ein Parameter aufgenommen 
				   //                     |  und in die Variable geschrieben
	public ManufacturerDto loadVendor(@PathParam("id") String name) 	{
		return manufacturerController.byName(name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createVendor(String value) { // Die hier vergebene Variable wird per Unmarshal aus der HTTP-Entity gefüllt
	    try {
            manufacturerController.newManufacturer(value);
        } catch (ManufacturerAlreadyExistsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	public void updateVendor(ManufacturerDto m) {
		manufacturerController.update(m);
	}
	
	@DELETE
	@Path("/{id}")
	public void delete(@PathParam("id") Long id) {
//		vendorDao.delete(id);
	}
	
}
