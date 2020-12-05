package Instruments.Locations;

public class NoLocation implements Location{
    @Override
    public void setLocation(String locationAdress) {
        System.out.println("null location cannot be set");
    }

    @Override
    public String getLocation() {
        System.out.println("null location cannot be got");
        return null;
    }
}
