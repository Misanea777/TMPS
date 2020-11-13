package Instruments.Filter;

import Instruments.StringInstrument;

import java.util.ArrayList;
import java.util.List;

public class CriteriaGuitar implements Criteria {
    @Override
    public List<StringInstrument> meetCriteria(List<StringInstrument> instruments) {
        List<StringInstrument> guitarInstruments = new ArrayList<StringInstrument>();

        for (StringInstrument instrument : instruments) {
            if(instrument.getName().equalsIgnoreCase("guitar")) {
                guitarInstruments.add(instrument);
            }
        }
        return guitarInstruments;
    }
}
