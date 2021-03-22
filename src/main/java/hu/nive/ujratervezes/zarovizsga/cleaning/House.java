package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    private String address;
    private int nm;

    public House(String address, int nm) {
        this.address = address;
        this.nm = nm;
    }

    @Override
    public int clean() {
        return nm * 80;
    }

    @Override
    public String getAddress() {
        return address;
    }

}
