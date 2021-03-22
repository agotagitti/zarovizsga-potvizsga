package hu.nive.ujratervezes.zarovizsga.cleaning;

public class Office implements Cleanable {

    private String address;
    private int nm;
    private int floors;

    public Office(String address, int nm, int floors) {
        this.address = address;
        this.nm = nm;
        this.floors = floors;
    }

    @Override
    public int clean() {
        return nm * floors * 100;
    }

    @Override
    public String getAddress() {
        return address;
    }
}
