package Instruments.Locations;

public class WarehouseLocation implements Location {
    private String loc;
    @Override
    public void setLocation(String locationAdress) {
        loc = "Warehouse-" + locationAdress;
    }

    @Override
    public String getLocation() {
        return loc;
    }
}
