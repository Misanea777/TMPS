package Instruments;

import Instruments.Locations.Location;

public abstract class StringInstrument {
    public Location location;

    protected String name;
    protected String type;
    protected int nrOfStrings;
    protected float price;

    public StringInstrument() {}

    public StringInstrument(Location location) {
        this.location = location;
    }

    abstract public void setName(String name);
    abstract public void setType(String type);
    abstract public void setNumberOfStrings(int stringsNr);
    abstract public void setPrice(float price);

    abstract public String getName();
    abstract public String getType();
}
