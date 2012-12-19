package rent.a.vehicle.converter;

import javax.ejb.Stateless;

import rent.a.vehicle.dto.ManufacturerDto;
import rent.a.vehicle.model.Manufacturer;

@Stateless
public class ManufacturerConverter extends AbstractDefaultConverter<Manufacturer, ManufacturerDto> {

    @Override
    protected ManufacturerDto newTargetInstance() {
        return new ManufacturerDto();
    }

    @Override
    protected void copyProperties(Manufacturer source, ManufacturerDto target) {
        target.setId(source.getId());
        target.setName(source.getName());
    }


}
