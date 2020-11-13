package Instruments.Filter;

import Instruments.StringInstrument;

import java.util.List;

public class OrCriteria implements Criteria {
    private Criteria firstCriteria;
    private Criteria secondCriteria;

    public OrCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }

    @Override
    public List<StringInstrument> meetCriteria(List<StringInstrument> instruments) {
        List<StringInstrument> firstCriteriaInstruments = firstCriteria.meetCriteria(instruments);
        List<StringInstrument> secondCriteriaInstruments = secondCriteria.meetCriteria(instruments);

        for (StringInstrument instrument : secondCriteriaInstruments) {
            if(!firstCriteriaInstruments.contains(instrument)){
                firstCriteriaInstruments.add(instrument);
            }
        }
        return firstCriteriaInstruments;
    }
}
