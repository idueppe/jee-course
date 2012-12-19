package rent.a.vehicle.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = { 
    @NamedQuery(name=Vehicle.FIND_ALL, query="SELECT v FROM vehicle") 
    
    }
    
                
)
public class Vehicle implements Identifiable {

    public static final String FIND_ALL = "Vehicle.findAll";
    
    @Id
    @GeneratedValue
    private Long id;
    private String modelName;
    private Date constructionDate;
    private Date inspectionDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Date getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public void setInspectionDate(Date inspectionDate) {
        this.inspectionDate = inspectionDate;
    }

}
