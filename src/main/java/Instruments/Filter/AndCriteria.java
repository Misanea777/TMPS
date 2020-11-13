package Instruments.Filter;

import Instruments.StringInstrument;

import java.util.List;

public class AndCriteria implements Criteria {
    private Criteria firstCriteria;
    private Criteria secondCriteria;

    public AndCriteria(Criteria firstCriteria, Criteria secondCriteria) {
        this.firstCriteria = firstCriteria;
        this.secondCriteria = secondCriteria;
    }

    @Override
    public List<StringInstrument> meetCriteria(List<StringInstrument> instruments) {
        List<StringInstrument> firstCriteriaInstruments = firstCriteria.meetCriteria(instruments);
        return secondCriteria.meetCriteria(firstCriteriaInstruments);
    }
}
