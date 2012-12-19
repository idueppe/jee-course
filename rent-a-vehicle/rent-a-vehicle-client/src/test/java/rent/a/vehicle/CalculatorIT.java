package rent.a.vehicle;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import rent.a.vehicle.utils.RentAVehicleServiceLocator;

public class CalculatorIT {

    @Test
    public void testSayHelloTo() throws Exception {
        Calculator calculator = getNewCalculatorInstance();
        
        calculator.set(10.0);
        calculator.add(10.0);
        calculator.sub(5.0);
        calculator.multiply(4.0);
        calculator.divide(6.0);
        assertEquals(10.0, calculator.sum(),0.01);
        
        calculator.close();
    }

    private Calculator getNewCalculatorInstance() throws Exception {
        String beanName = "CalculatorBean";
        Class<Calculator> viewClass = Calculator.class;
        
        Calculator calculator = RentAVehicleServiceLocator.lookupStatefulService(beanName, viewClass);
        return calculator;
    }

}
