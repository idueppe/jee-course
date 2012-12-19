package rent.a.vehicle.converter;

import javax.ejb.Stateless;

import rent.a.vehicle.dto.VehicleDto;
import rent.a.vehicle.model.Vehicle;

@Stateless
public class VehicleConverter extends AbstractDefaultConverter<Vehicle, VehicleDto> {

    @Override
    protected VehicleDto newTargetInstance() {
        return new VehicleDto();
    }

    @Override
    protected void copyProperties(Vehicle source, VehicleDto target) {
        target.setModelName(source.getModelName());
        target.setConstructionDate(source.getConstructionDate());
        target.setInspectionDate(source.getInspectionDate());
        
        target.setManufacturerName("NOT DEFINED YET IN CONVERTER"); // TODO
    }

}
