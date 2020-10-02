import Factory.AcousticFactory;
import Factory.BaseFactory;
import Factory.ClassicFactory;
import Factory.ElectricalFactory;

public class FactoryProducer {
    public static BaseFactory getFactory(String type) {
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
}
