package Instruments;

import Instruments.Locations.Location;

public class Harp extends StringInstrument {

    public Harp() {}
    public Harp(Location location) {
        super(location);
    }

    @Override
    public void setName(String name) {
        super.name = name;
    }


    @Override
    public void setType(String type) {
        super.type = type;
    }

    @Override
    public void setNumberOfStrings(int stringsNr) {
        super.nrOfStrings = stringsNr;
    }

    @Override
    public void setPrice(float price) {
        super.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public int getNrOfStrings() {
        return nrOfStrings;
    }

    @Override
    public StringInstrument clone() {
        Harp harp = new Harp();
        harp.setName(this.name);
        harp.setType(this.type);
        harp.setPrice(this.price);
        harp.setNumberOfStrings(this.nrOfStrings);
        return harp;
    }

    @Override
    public StringInstrumentMemento save() {
        return new StringInstrumentMemento(this);
    }

    @Override
    public void restore(StringInstrumentMemento memento) {
        StringInstrument harp = memento.getState();
        setName(harp.name);
        setType(harp.type);
        setPrice(harp.price);
        setNumberOfStrings(harp.nrOfStrings);
    }

    @Override
    public String toString() {
        return "Harp{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", nrOfStrings=" + nrOfStrings +
                ", price=" + price +
                '}';
    }


}
