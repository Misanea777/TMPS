package Instruments.Builder;

import Instruments.DoubleBass;

public class DoubleBassBuilder implements  StringInstrumentBuilder{
    private DoubleBass doubleBass;

    public DoubleBassBuilder() {
        reset();
    }

    @Override
    public void setName(String name) {
        this.doubleBass.setName(name);
    }

    @Override
    public void setType(String type) {
        this.doubleBass.setType(type);
    }

    @Override
    public void setNumberOfStrings(int stringsNr) {
        this.doubleBass.setNumberOfStrings(stringsNr);
    }

    @Override
    public void setPrice(float price) {
        this.doubleBass.setPrice(price);
    }

    @Override
    public void reset() {
        this.doubleBass = new DoubleBass();
    }

    public DoubleBass getInstrument()
    {
        DoubleBass instrument = this.doubleBass;
        reset();
        return instrument;
    }
}
