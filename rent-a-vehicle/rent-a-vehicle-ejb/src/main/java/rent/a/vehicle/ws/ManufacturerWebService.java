package rent.a.vehicle.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import rent.a.vehicle.dto.ManufacturerDto;

@WebService
public interface ManufacturerWebService {
    
    @WebMethod()
    public List<ManufacturerDto> findAll();
    
    @WebMethod()
    public ManufacturerDto byName(@WebParam(name="manufacturerName") String name);

    @WebMethod()
    public boolean doManufacturerExists(@WebParam(name="manufacturerName") String manufacturerName);

}
