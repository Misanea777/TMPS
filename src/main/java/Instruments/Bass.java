package Instruments;

import Instruments.Locations.Location;

public class Bass extends StringInstrument {

    public Bass(){}

    public Bass(Location location) {
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
        Bass bass = new Bass();
        bass.setName(this.name);
        bass.setType(this.type);
        bass.setPrice(this.price);
        bass.setNumberOfStrings(this.nrOfStrings);
        return bass;
    }

    @Override
    public StringInstrumentMemento save() {
        return new StringInstrumentMemento(this);
    }

    @Override
    public void restore(StringInstrumentMemento memento) {
        StringInstrument bass = memento.getState();
        setName(bass.name);
        setType(bass.type);
        setPrice(bass.price);
        setNumberOfStrings(bass.nrOfStrings);
    }


    @Override
    public String toString() {
        return "Bass{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", nrOfStrings=" + nrOfStrings +
                ", price=" + price +
                '}';
    }


}
