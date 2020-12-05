package Instruments;

import Instruments.Locations.Location;
import Instruments.Locations.NoLocation;
import Instruments.memento.StringInstrumentMemento;

public abstract class StringInstrument {
    public Location location;

    protected String name;
    protected String type;
    protected int nrOfStrings;
    protected float price;

    public StringInstrument() {
        this.location = new NoLocation();
    }

    public StringInstrument(Location location) {
        this.location = location;
    }

    abstract public void setName(String name);
    abstract public void setType(String type);
    abstract public void setNumberOfStrings(int stringsNr);
    abstract public void setPrice(float price);

    abstract public String getName();
    abstract public String getType();
    abstract public float getPrice();
    abstract public int getNrOfStrings();

    abstract public StringInstrument clone();

    abstract public StringInstrumentMemento save();
    abstract public void restore(StringInstrumentMemento memento);

}
