package Factory;

import Instruments.Builder.*;
import Instruments.StringInstrument;

public class ElectricalFactory implements BaseFactory {
    private static ElectricalFactory instance = new ElectricalFactory();
    private ElectricalFactory(){}
    public static ElectricalFactory getInstance() {
        return instance;
    }

    @Override
    public StringInstrument createInstrument(String type) {
        switch(type) {
            case "guitar":
                GuitarBuilder guitarBuilder = new GuitarBuilder();
                guitarBuilder.setName("guitar");
                guitarBuilder.setNumberOfStrings(6);
                guitarBuilder.setType("electric");
                guitarBuilder.setPrice(120.0f);
                return guitarBuilder.getInstrument();
            case "bass":
                BassBuilder bassBuilder = new BassBuilder();
                bassBuilder.setName("bass");
                bassBuilder.setNumberOfStrings(7);
                bassBuilder.setType("electric");
                bassBuilder.setPrice(1864.0f);
                return bassBuilder.getInstrument();
            case "doubleBass":
                DoubleBassBuilder doubleBassBuilder = new DoubleBassBuilder();
                doubleBassBuilder.setName("double_bass");
                doubleBassBuilder.setNumberOfStrings(3);
                doubleBassBuilder.setType("electric");
                doubleBassBuilder.setPrice(506.32f);
                return doubleBassBuilder.getInstrument();
            case "harp":
                HarpBuilder harpBuilder = new HarpBuilder();
                harpBuilder.setName("harp");
                harpBuilder.setNumberOfStrings(17);
                harpBuilder.setType("acoustic");
                harpBuilder.setPrice(10020.0f);
                return harpBuilder.getInstrument();
            case "violin":
                ViolinBuilder violinBuilder = new ViolinBuilder();
                violinBuilder.setName("violin");
                violinBuilder.setNumberOfStrings(5);
                violinBuilder.setType("electric");
                violinBuilder.setPrice(20234.99f);
                return violinBuilder.getInstrument();
        }
        return null;
    }
}
