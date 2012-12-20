package rent.a.vehicle.web.views;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import rent.a.vehicle.controller.ManufacturerNotFoundException;
import rent.a.vehicle.controller.VehicleController;
import rent.a.vehicle.dto.ManufacturerDto;
import rent.a.vehicle.dto.VehicleDto;

/**
 * @author idueppe
 * @since 1.0
 */
@ManagedBean
@SessionScoped
public class VehiclesView implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private static final Logger LOG = Logger.getLogger(VehiclesView.class.getName());

    @EJB
    private VehicleController vehicleController;
    private ManufacturerDto manufacturer;
    
    private VehicleDto vehicle;

    public List<VehicleDto> getVehicles() {
        if (manufacturer != null) {
            return vehicleController.findByManufacturerName(manufacturer.getName());
        } else {
            return Collections.emptyList();
        }
    }

    public String showVehicles(ManufacturerDto manufacturer) {
        this.manufacturer = manufacturer;
        return "/views/vehicles";
    }

    public String delete(VehicleDto vehicleDto) {
        LOG.info("----------- DELETING VEHICLE...");
        vehicleController.deleteVehicle(vehicleDto);
        // TODO Hier eine Nachricht platzieren, dass das Fahrzeug gelöscht wurde.
        return "/views/vehicles";
    }

    public String addVehicle() {
        
        vehicle.setManufacturerName(manufacturer.getName());
        vehicle.setEningeType("DIESEL");
        
        
        try {
            vehicleController.addVehicle(vehicle);
        } catch (ManufacturerNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        FacesMessage msg = new FacesMessage();
        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
        msg.setSummary("Diese Funktion ist noch nicht implementiert.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "/views/vehicles";
    }

    public String cancelAdding() {
        // TODO Hier eine Nachricht über den Abbruch absetzen.
        return "/views/vehicles";
    }
    
    public String startAddingVehicle() {
        vehicle = new VehicleDto();
        return "/views/addvehicle";
    }

    public String selectForUpdate(VehicleDto vehicle) {
        this.vehicle = vehicle;
        return "/views/addvehicle";
    }


    public ManufacturerDto getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(ManufacturerDto manufacturer) {
        this.manufacturer = manufacturer;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

}
