package Factory;

import Instruments.Builder.*;
import Instruments.StringInstrument;

public class ClassicFactory implements BaseFactory {

    private static ClassicFactory instance = new ClassicFactory();
    private ClassicFactory(){}
    public static ClassicFactory getInstance() {
        return instance;
    }

    @Override
    public StringInstrument createInstrument(String type) {
        switch(type) {
            case "guitar":
                GuitarBuilder guitarBuilder = new GuitarBuilder();
                guitarBuilder.setName("guitar");
                guitarBuilder.setNumberOfStrings(6);
                guitarBuilder.setType("classic");
                guitarBuilder.setPrice(100.0f);
                return guitarBuilder.getInstrument();
            case "bass":
                BassBuilder bassBuilder = new BassBuilder();
                bassBuilder.setName("bass");
                bassBuilder.setNumberOfStrings(4);
                bassBuilder.setType("classic");
                bassBuilder.setPrice(134.0f);
                return bassBuilder.getInstrument();
            case "doubleBass":
                DoubleBassBuilder doubleBassBuilder = new DoubleBassBuilder();
                doubleBassBuilder.setName("double_bass");
                doubleBassBuilder.setNumberOfStrings(5);
                doubleBassBuilder.setType("classic");
                doubleBassBuilder.setPrice(56.32f);
                return doubleBassBuilder.getInstrument();
            case "harp":
                HarpBuilder harpBuilder = new HarpBuilder();
                harpBuilder.setName("harp");
                harpBuilder.setNumberOfStrings(100);
                harpBuilder.setType("classic");
                harpBuilder.setPrice(1000.0f);
                return harpBuilder.getInstrument();
            case "violin":
                ViolinBuilder violinBuilder = new ViolinBuilder();
                violinBuilder.setName("violin");
                violinBuilder.setNumberOfStrings(4);
                violinBuilder.setType("classic");
                violinBuilder.setPrice(2000.99f);
                return violinBuilder.getInstrument();
        }
        return null;
    }
}
