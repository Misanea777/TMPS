import Factory.BaseFactory;
import Instruments.Bass;
import Instruments.Filter.*;
import Instruments.Locations.Location;
import Instruments.Locations.StoreLocation;
import Instruments.StringInstrument;
import Roles.BaseRole;
import Roles.Customer;
import Roles.Producer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        BaseRole role = new Producer();

        BaseFactory classicFactory = FactoryProducer.getFactory("classic", role);
        BaseFactory acousticFactory = FactoryProducer.getFactory("accustic", role);
        BaseFactory electicFactory = FactoryProducer.getFactory("electric", role);

        List<StringInstrument> inst = new ArrayList<StringInstrument>();

        inst.addAll(createAllInstrumentsFromFactory(classicFactory));
        inst.addAll(createAllInstrumentsFromFactory(acousticFactory));
        inst.addAll(createAllInstrumentsFromFactory(electicFactory));

        printInstruments(inst);


        System.out.println("Filtering by electric instruments________   ");
        printInstruments(new CriteriaElectric().meetCriteria(inst));


        System.out.println("Filtering by electric and guitar instruments________   ");
        printInstruments(new AndCriteria(new CriteriaElectric(), new CriteriaGuitar()).meetCriteria(inst));

        System.out.println("Filtering by electric or guitar instruments________   ");
        printInstruments(new OrCriteria(new CriteriaElectric(), new CriteriaGuitar()).meetCriteria(inst));

//        Location das = new StoreLocation();
//        das.setLocation("das");
//        System.out.println(new Bass(das).location.getLocation());
    }

    public static List<StringInstrument> createAllInstrumentsFromFactory(BaseFactory factory) {
        List<StringInstrument> instruments = new ArrayList<StringInstrument>();
        instruments.add(factory.createInstrument("guitar"));
        instruments.add(factory.createInstrument("bass"));
        instruments.add(factory.createInstrument("doubleBass"));
        instruments.add(factory.createInstrument("harp"));
        instruments.add(factory.createInstrument("violin"));

        return instruments;
    }
    
    public static void printInstruments(List<StringInstrument> instruments) {
        instruments.forEach(result -> System.out.println(result));
        System.out.println();
    }




}
