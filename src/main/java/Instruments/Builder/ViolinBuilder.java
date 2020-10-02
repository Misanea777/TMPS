package Instruments.Builder;

import Instruments.Bass;
import Instruments.Violin;

public class ViolinBuilder implements StringInstrumentBuilder {
    private Violin violin;

    public ViolinBuilder() {
        reset();
    }

    @Override
    public void setName(String name) {
        this.violin.setName(name);
    }

    @Override
    public void setType(String type) {
        this.violin.setType(type);
    }

    @Override
    public void setNumberOfStrings(int stringsNr) {
        this.violin.setNumberOfStrings(stringsNr);
    }

    @Override
    public void setPrice(float price) {
        this.violin.setPrice(price);
    }

    @Override
    public void reset() {
        this.violin = new Violin();
    }

    public Violin getInstrument()
    {
        Violin instrument = this.violin;
        reset();
        return  instrument;
    }
}
