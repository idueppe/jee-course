package rent.a.vehicle;

import static org.junit.Assert.*;

import org.junit.Test;

import rent.a.vehicle.controller.ManufacturerController;
import rent.a.vehicle.dto.ManufacturerDto;
import rent.a.vehicle.utils.RentAVehicleServiceLocator;

public class ManufacturerDaoBeanIT {

    @Test
    public void testManufacturer() throws Exception {
        String beanName = "ManufacturerControllerBean";
        Class<ManufacturerController> viewClass = ManufacturerController.class;
        
        ManufacturerController controller = RentAVehicleServiceLocator.lookupStatelessService(beanName, viewClass);
        
        controller.newManufacturer("Bugatti");
        ManufacturerDto dto = controller.byName("Bugatti");
        
        assertEquals("Bugatti", dto.getName());
        assertNotNull(dto.getId());
        
    }

}
