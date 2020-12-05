package Instruments.Locations;

public class StoreLocation implements Location {
    private String loc;
    @Override
    public void setLocation(String locationAdress) {
        loc = "Store-" + locationAdress;
    }

    @Override
    public String getLocation() {
        return loc;
    }

}
