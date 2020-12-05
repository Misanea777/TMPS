package Instruments;

import Instruments.Locations.Location;
import Instruments.memento.State;
import Instruments.memento.StringInstrumentMemento;

public class Guitar extends StringInstrument {

    public Guitar() {}
    public Guitar(Location location) {
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
        Guitar guitar = new Guitar();
        guitar.setName(this.name);
        guitar.setType(this.type);
        guitar.setPrice(this.price);
        guitar.setNumberOfStrings(this.nrOfStrings);
        return guitar;
    }

    @Override
    public StringInstrumentMemento save() {
        return new StringInstrumentMemento(new State(name, type, nrOfStrings, price));
    }

    @Override
    public void restore(StringInstrumentMemento memento) {
        State state = memento.getState();
        setName(state.getName());
        setType(state.getType());
        setPrice(state.getPrice());
        setNumberOfStrings(state.getNrOfStrings());
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", nrOfStrings=" + nrOfStrings +
                ", price=" + price +
                '}';
    }


}
