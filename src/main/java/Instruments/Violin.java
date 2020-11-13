package Instruments;

import Instruments.Locations.Location;

public class Violin extends StringInstrument {

    public Violin() {}
    public Violin(Location location) {
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
    public String toString() {
        return "Violin{" +
                "type='" + type + '\'' +
                ", nrOfStrings=" + nrOfStrings +
                ", price=" + price +
                '}';
    }
}
