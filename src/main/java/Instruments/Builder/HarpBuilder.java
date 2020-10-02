package Instruments.Builder;

import Instruments.Bass;
import Instruments.Harp;

public class HarpBuilder implements StringInstrumentBuilder {
    private Harp harp;

    public HarpBuilder() {
        reset();
    }

    @Override
    public void setName(String name) {
        this.harp.setName(name);
    }

    @Override
    public void setType(String type) {
        this.harp.setType(type);
    }

    @Override
    public void setNumberOfStrings(int stringsNr) {
        this.harp.setNumberOfStrings(stringsNr);
    }

    @Override
    public void setPrice(float price) {
        this.harp.setPrice(price);
    }

    @Override
    public void reset() {
        this.harp = new Harp();
    }

    public Harp getInstrument()
    {
        Harp instrument = this.harp;
        reset();
        return  instrument;
    }
}
