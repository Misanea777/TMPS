import Factory.BaseFactory;
import Factory.FactoryProducer;
import Instruments.StringInstrument;
import Roles.BaseRole;
import Roles.Producer;
import command.*;

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

        System.out.println("---------------------------------------------");


        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.addCommand(new DeleteIfNotElectricCommand(inst));
        commandExecutor.executeLastCommand();
        System.out.println("Executing delete if not electric command...\n");
        printInstruments(inst);

        commandExecutor.addCommand(new DoubleThePriceAndChangeToAcousticCommand(inst.get(0)));
        commandExecutor.executeLastCommand();
        System.out.println("Executing double the price and change to acoustic command for 1 element...\n");
        printInstruments(inst);

        commandExecutor.addCommand(new RepeatCommand(inst.get(0), 10, new DoubleThePriceCommand(inst.get(0))));
        commandExecutor.executeLastCommand();
        System.out.println("Repeating double the price command for 10 times for first element...\n");
        printInstruments(inst);

        commandExecutor.unexecuteAllCommands();
        System.out.println("Unexecuting all commands in comands history...\n");


        printInstruments(inst);


//        System.out.println("Filtering by electric instruments________   ");
//        printInstruments(new CriteriaElectric().meetCriteria(inst));
//

//        System.out.println("Filtering by electric and guitar instruments________   ");
//        printInstruments(new AndCriteria(new CriteriaElectric(), new CriteriaGuitar()).meetCriteria(inst));
//
//        System.out.println("Filtering by electric or guitar instruments________   ");
//        printInstruments(new OrCriteria(new CriteriaElectric(), new CriteriaGuitar()).meetCriteria(inst));

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
