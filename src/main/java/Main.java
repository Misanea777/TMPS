import Factory.BaseFactory;

public class Main {
    public static void main(String[] args){
        BaseFactory classicFactory = FactoryProducer.getFactory("classic");
        BaseFactory acousticFactory = FactoryProducer.getFactory("accustic");
        BaseFactory electicFactory = FactoryProducer.getFactory("electric");

        createAndPrintAllInstrumentsFromFactory(classicFactory);
        createAndPrintAllInstrumentsFromFactory(acousticFactory);
        createAndPrintAllInstrumentsFromFactory(electicFactory);
    }

    public static void createAndPrintAllInstrumentsFromFactory(BaseFactory factory) {
        System.out.println(factory.createInstrument("guitar"));
        System.out.println(factory.createInstrument("bass"));
        System.out.println(factory.createInstrument("doubleBass"));
        System.out.println(factory.createInstrument("harp"));
        System.out.println(factory.createInstrument("violin"));
        System.out.println();
    }


}
