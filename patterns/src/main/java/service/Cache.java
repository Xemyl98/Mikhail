package service;

import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<Service> services=new ArrayList<>();
    public  Service getService(String serviceName)
    {
        for(Service service:services)
        {
            if(service.getName().equalsIgnoreCase(serviceName))
                return service;
        }
        return null;
    }
    public void addService(Service newService)
    {
        boolean exists=false;
        for(Service service:services)
        {
            if(service.getName().equalsIgnoreCase(newService.getName()))
                exists=true;
        }
        if(!exists)
            services.add(newService);
    }
}
