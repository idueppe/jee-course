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
        target.setId(source.getId());
        target.setModelName(source.getModelName());
        target.setConstructionDate(source.getConstructionDate());
        target.setInspectionDate(source.getInspectionDate());
        
        if (source.getManufacturer() != null) {
            target.setManufacturerName(source.getManufacturer().getName());
        } else {
            target.setManufacturerName("N/A");
        }
        
        if (source.getEngine() != null) {
            target.setEningeType(source.getEngine().getEngineType().toString());
        }
    }

}
