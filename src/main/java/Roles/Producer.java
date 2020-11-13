package Roles;

public class Producer implements BaseRole {
    private final int privLvl = 2;
    @Override
    public int getPrivilegeLvl() {
        return privLvl;
    }
}
