package rent.a.vehicle;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

@Stateful
@Remote(Calculator.class)
public class CalculatorBean implements Calculator, Serializable{
    
    private static final Logger log = Logger.getLogger(CalculatorBean.class.getName());
    
    private static final long serialVersionUID = 1L;

    private double sum;
    
    @Override
    public void add(double value) {
        sum += value;
    }
    
    @Override
    public void sub(double value) {
        sum -= value;
    }
    
    @Override
    public void multiply(double value) {
        sum *= value;
    }
    
    @Override
    public void divide(double value) {
        sum = sum / value;
    }
    
    @Override
    public void set(double value) {
        sum = value;
    }
    
    @Override
    public double sum() {
        log.info("sum is "+sum);
        return sum;
    }
    
    @Override
    @Remove
    public void close() {
        log.info("closing calculator");
    }
    
    @PostConstruct
    public void setup() {
        log.info("post construct");
    }
    
    @PreDestroy
    public void tearDown() {
        log.info("pre destroy");
    }
    
    @PrePassivate
    public void prePassived() {
        log.info("Passivating with sum "+sum);
    }
    
    @PostActivate
    public void postActivate() {
        log.info("activated with sum"+sum);
    }

}
