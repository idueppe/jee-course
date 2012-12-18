package rent.a.vehicle.utils;


public class RentAVehicleServiceLocator extends ServiceLocator {
    
    private static String appName = "rent-a-vehicle-ear";
    private static String moduleName = "rent-a-vehicle-ejb";
    
    public static <T> T lookupStatelessService(Class<T> viewClass) throws Exception {
        return lookupStatelessService(viewClass.getSimpleName()+"Bean", viewClass);
    }
    
    public static <T> T lookupStatelessService(String beanName, Class<T> viewClass) throws Exception {
        return lookupStatelessService(appName, moduleName, "", beanName, viewClass);
    }

    public static <T> T lookupStatefulService(String beanName, Class<T> viewClass) throws Exception {
        return lookupStatefulService(appName, moduleName, "", beanName, viewClass);
    }

}
