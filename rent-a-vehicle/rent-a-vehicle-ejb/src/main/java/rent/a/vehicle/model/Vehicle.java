package rent.a.vehicle.model;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
//@Table(name="tbl_vehicle")
public class Vehicle extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Vehicle.findAll";
    
    @Transient
    private Map<String, byte[]> data;
    
//    @Column(name="model_name",length=100, nullable=false)
    private String modelName;
    
    @Temporal(TemporalType.DATE)
    private Date constructionDate;
    
    @Temporal(TemporalType.DATE)
    private Date inspectionDate;
    
    @Version
    private long version;

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
//@NamedQueries(value = 
//{ 
// @NamedQuery(name=Vehicle.FIND_ALL, query="SELECT v FROM Vehicle v") 
//}
//)
