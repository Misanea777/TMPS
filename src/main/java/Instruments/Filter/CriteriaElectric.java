package Instruments.Filter;

import Instruments.StringInstrument;

import java.util.ArrayList;
import java.util.List;

public class CriteriaElectric implements Criteria {
    @Override
    public List<StringInstrument> meetCriteria(List<StringInstrument> instruments) {
        List<StringInstrument> electricInstruments = new ArrayList<StringInstrument>();

        for (StringInstrument instrument : instruments) {
            if(instrument.getType().equalsIgnoreCase("electric")) {
                electricInstruments.add(instrument);
            }
        }
        return electricInstruments;
    }
}
