package rent.a.vehicle.controller.impl;

import java.util.List;

import rent.a.vehicle.controller.VehicleController;
import rent.a.vehicle.dto.VehicleDto;

@Stateless

public class VehicleControllerBean implements VehicleController {
    
    @Override
    public List<VehicleDto> findByManufacturerName(String name) {
        return null;
    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicle) {
        return null;
    }

    @Override
    public void deleteVehicle(VehicleDto vehicle) {

    }

}
