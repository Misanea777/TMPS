package Factory;

import Instruments.Builder.*;
import Instruments.StringInstrument;

public class AcousticFactory implements BaseFactory {

    private static AcousticFactory instance = new AcousticFactory();
    private AcousticFactory(){}
    public static AcousticFactory getInstance() {
        return instance;
    }

    @Override
    public StringInstrument createInstrument(String type) {
        switch(type) {
            case "guitar":
                GuitarBuilder guitarBuilder = new GuitarBuilder();
                guitarBuilder.setName("guitar");
                guitarBuilder.setNumberOfStrings(6);
                guitarBuilder.setType("acoustic");
                guitarBuilder.setPrice(170.0f);
                return guitarBuilder.getInstrument();
            case "bass":
                BassBuilder bassBuilder = new BassBuilder();
                bassBuilder.setName("bass");
                bassBuilder.setNumberOfStrings(5);
                bassBuilder.setType("acoustic");
                bassBuilder.setPrice(1364.0f);
                return bassBuilder.getInstrument();
            case "doubleBass":
                DoubleBassBuilder doubleBassBuilder = new DoubleBassBuilder();
                doubleBassBuilder.setName("double_bass");
                doubleBassBuilder.setNumberOfStrings(5);
                doubleBassBuilder.setType("acoustic");
                doubleBassBuilder.setPrice(506.32f);
                return doubleBassBuilder.getInstrument();
            case "harp":
                HarpBuilder harpBuilder = new HarpBuilder();
                harpBuilder.setName("harp");
                harpBuilder.setNumberOfStrings(10);
                harpBuilder.setType("acoustic");
                harpBuilder.setPrice(10000.0f);
                return harpBuilder.getInstrument();
            case "violin":
                ViolinBuilder violinBuilder = new ViolinBuilder();
                violinBuilder.setName("violin");
                violinBuilder.setNumberOfStrings(4);
                violinBuilder.setType("acoustic");
                violinBuilder.setPrice(20230.99f);
                return violinBuilder.getInstrument();
        }
        return null;
    }
}
