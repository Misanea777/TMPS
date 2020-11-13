package Factory;

import Instruments.StringInstrument;
import Roles.BaseRole;

public class FactoryProxy implements BaseFactory {
    private BaseRole role;
    private BaseFactory factory;

    public FactoryProxy(BaseRole role, BaseFactory factory) {
        this.role = role;
        this.factory = factory;
    }

    @Override
    public StringInstrument createInstrument(String type) {
        if(role.getPrivilegeLvl() > 1) {
            return factory.createInstrument(type);
        }
        else {
            System.out.println("Permission denied!");
            return null;
        }
    }
}
