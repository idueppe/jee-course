package rent.a.vehicle.dao;

import java.util.List;

import rent.a.vehicle.model.Identifiable;

public interface EntityDao<T extends Identifiable> {
    
    public List<T> findAll();
    
    public void create(T entity);
    
    public T read(Long id);
    
    public T update(T entity);
    
    public void delete(T entity);
    
}
