package Roles;

public class Customer implements BaseRole {
    private final int privLvl = 1;

    @Override
    public int getPrivilegeLvl() {
        return privLvl;
    }
}
