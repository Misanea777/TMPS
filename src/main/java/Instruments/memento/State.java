package Instruments.memento;

public class State {
    private String name;
    private String type;
    private int nrOfStrings;
    private float price;

    public State(String name, String type, int nrOfStrings, float price) {
        this.name = name;
        this.type = type;
        this.nrOfStrings = nrOfStrings;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getNrOfStrings() {
        return nrOfStrings;
    }

    public float getPrice() {
        return price;
    }
}
