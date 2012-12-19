package rent.a.vehicle.controller.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import rent.a.vehicle.controller.ManufacturerNotFoundException;
import rent.a.vehicle.controller.VehicleController;
import rent.a.vehicle.converter.VehicleConverter;
import rent.a.vehicle.dto.VehicleDto;
import rent.a.vehicle.model.Vehicle;
import rent.a.vehicle.services.VehicleService;

@Stateless
@Remote(VehicleController.class)
public class VehicleControllerBean implements VehicleController {
    
    @EJB
    private VehicleService vehicleService;
    
    @EJB
    private VehicleConverter vehicleConverter;
    
    @Override
    public List<VehicleDto> findByManufacturerName(String name) {
        return vehicleConverter.convert(vehicleService.findByManufacturerName(name));
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) throws ManufacturerNotFoundException {
        Vehicle vehicle = new Vehicle();
        vehicle.setModelName(vehicleDto.getModelName());
        vehicle.setInspectionDate(vehicleDto.getInspectionDate());
        vehicle.setConstructionDate(vehicleDto.getConstructionDate());
        
        return vehicleConverter.convert(vehicleService.addVehicle(vehicle, vehicleDto.getManufacturerName()));
    }

    @Override
    public void deleteVehicle(VehicleDto vehicle) {
        // TODO
    }

}
