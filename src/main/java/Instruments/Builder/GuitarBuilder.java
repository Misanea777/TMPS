package Instruments.Builder;

import Instruments.Guitar;

public class GuitarBuilder implements StringInstrumentBuilder {
    private Guitar guitar;

    public GuitarBuilder() {
        reset();
    }

    @Override
    public void setName(String name) {
        this.guitar.setName(name);
    }

    @Override
    public void setType(String type) {
        this.guitar.setType(type);
    }

    @Override
    public void setNumberOfStrings(int stringsNr) {
        this.guitar.setNumberOfStrings(stringsNr);
    }

    @Override
    public void setPrice(float price) {
        this.guitar.setPrice(price);
    }

    @Override
    public void reset() {
        this.guitar = new Guitar();
    }

    public Guitar getInstrument()
    {
        Guitar instrument = this.guitar;
        reset();
        return instrument;
    }
}
