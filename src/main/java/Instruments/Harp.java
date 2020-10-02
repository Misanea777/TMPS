package Instruments;

public class Harp implements StringInstrument {
    private String name;
    private String type;
    private int nrOfStrings;
    private float price;

    @Override
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setNumberOfStrings(int stringsNr) {
        this.nrOfStrings = stringsNr;
    }

    @Override
    public void setPrice(float price) {
        this.price = price;
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
