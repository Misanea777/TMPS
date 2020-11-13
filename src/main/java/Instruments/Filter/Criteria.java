package Instruments.Filter;

import Instruments.StringInstrument;

import java.util.List;

public interface Criteria {
    public List<StringInstrument> meetCriteria(List<StringInstrument> instruments);
}
