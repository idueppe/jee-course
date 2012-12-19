package rent.a.vehicle.controller;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import rent.a.vehicle.dto.VehicleDto;
import rent.a.vehicle.utils.RentAVehicleServiceLocator;

public class VehicleControllerIT {
    
    private VehicleController controller;
    
    @Before
    public void setUp() throws NamingException {
        controller = RentAVehicleServiceLocator.lookupStatelessService(VehicleController.class);
    }
    
    @Test
    public void testFindVehicleByManufacturerName() {
        List<VehicleDto> vehicles = controller.findByManufacturerName("Bugatti");
        for (VehicleDto vehicleDto : vehicles) {
            assertEquals("Bugatti", vehicleDto.getManufacturerName());
        }
    }
    
    @Test
    public void testAddVehicleToManufacturer() throws ManufacturerNotFoundException {
        VehicleDto dto = new VehicleDto();
        dto.setModelName("Vyron");
        dto.setManufacturerName("Bugatti");
        dto.setInspectionDate(toDate(2013,1,31));
        dto.setConstructionDate(toDate(2009,1,31));
        controller.addVehicle(dto);
    }

    @Test(expected=ManufacturerNotFoundException.class)
    public void testNotFindingTheGivenManufacturer() throws ManufacturerNotFoundException {
        VehicleDto dto = new VehicleDto();
        dto.setModelName("Vyron");
        dto.setManufacturerName("DOES NOT EXIST");
        dto.setInspectionDate(toDate(2013,1,31));
        dto.setConstructionDate(toDate(2009,1,31));
        controller.addVehicle(dto);
    }
    
    private Date toDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
    
}
