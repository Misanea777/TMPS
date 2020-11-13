import Factory.*;
import Roles.BaseRole;

import javax.management.relation.Role;

public class FactoryProducer {

    private static BaseFactory getRawFactory(String type) {
        switch (type){
            case "accustic":
                return AcousticFactory.getInstance();
            case "classic":
                return ClassicFactory.getInstance();
            case "electric":
                return ElectricalFactory.getInstance();
        }
        return null;
    }


    public static BaseFactory getFactory(String type, BaseRole role) {
        return new FactoryProxy(role, getRawFactory(type));
    }
}
