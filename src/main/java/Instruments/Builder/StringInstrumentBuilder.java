package Instruments.Builder;

public interface StringInstrumentBuilder {
    void setName(String name);
    void setType(String type);
    void setNumberOfStrings(int stringsNr);
    void setPrice(float price);
    void reset();
}
