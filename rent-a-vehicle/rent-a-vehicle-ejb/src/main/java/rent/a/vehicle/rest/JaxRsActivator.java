package rent.a.vehicle.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 * Definiert den relativen Pfad (also zur Applikations-URL) der
 * REST-Services.
 * 
 * Also http://{deinhost}:{deinport}/{deineanwendung}/rest
 * 
 * @See VendorRestService
 * 
 * @author marcus
 *
 */
@ApplicationPath("/rest")
public class JaxRsActivator extends Application {

}
