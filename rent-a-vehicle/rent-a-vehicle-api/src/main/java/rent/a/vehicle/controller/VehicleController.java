package rent.a.vehicle.controller;

import java.util.List;

import rent.a.vehicle.dto.VehicleDto;

public interface VehicleController {

    public List<VehicleDto> findByManufacturerName(String name);

    public VehicleDto addVehicle(VehicleDto vehicle);

    public void deleteVehicle(VehicleDto vehicle);

}
