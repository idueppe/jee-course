package rent.a.vehicle.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import rent.a.vehicle.dto.ManufacturerDto;
import rent.a.vehicle.utils.RentAVehicleServiceLocator;

public class ManufacturerControllerIT {
    
    private ManufacturerController manufacturerController;
    
    @Before
    public void setUp() throws NamingException {
        manufacturerController = RentAVehicleServiceLocator.lookupStatelessService(ManufacturerController.class);
    }
    
    @Test
    public void testNewManufacturer() throws ManufacturerAlreadyExistsException {
        manufacturerController.newManufacturer("Bugatti");
        ManufacturerDto manufacturer = manufacturerController.byName("Bugatti");
        assertNotNull(manufacturer);
        assertEquals("Bugatti", manufacturer.getName());
    }
    
    @Test(expected=ManufacturerAlreadyExistsException.class)
    public void testFailureOnCreationExistingManufacturer() throws ManufacturerAlreadyExistsException {
        manufacturerController.newManufacturer("Bugatti");
        manufacturerController.newManufacturer("Bugatti");
    }
    
    @Test
    public void testFindAllShouldNeverReturnNull() {
        List<ManufacturerDto> all = manufacturerController.findAll();
        assertNotNull(all);
    }

}
