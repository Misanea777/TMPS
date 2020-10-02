package Instruments.Builder;

import Instruments.Bass;

public class BassBuilder implements StringInstrumentBuilder {
    private Bass bass;

    public BassBuilder() {
        reset();
    }

    @Override
    public void setName(String name) {
        this.bass.setName(name);
    }

    @Override
    public void setType(String type) {
        this.bass.setType(type);
    }

    @Override
    public void setNumberOfStrings(int stringsNr) {
        this.bass.setNumberOfStrings(stringsNr);
    }

    @Override
    public void setPrice(float price) {
        this.bass.setPrice(price);
    }

    @Override
    public void reset() {
        this.bass = new Bass();
    }

    public Bass getInstrument()
    {
        Bass instrument = this.bass;
        reset();
        return instrument;
    }
}
