package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);
    }

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public int cleanAll() {
        int costs = 0;
        for (Iterator<Cleanable> iterator = cleanables.iterator(); iterator.hasNext();) {
            costs += iterator.next().clean();
            iterator.remove();
        }
        return costs;
    }

    public int cleanOnlyOffices() {
        int costs = 0;
        for (Iterator<Cleanable> iterator = cleanables.iterator(); iterator.hasNext();) {
            Cleanable nextCleanable = iterator.next();
            if (nextCleanable instanceof Office) {
                costs += nextCleanable.clean();
                iterator.remove();
            }
        }
        return costs;
    }

    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> foundCleanables = new ArrayList<>();
        for (Cleanable actualCleanable : cleanables) {
            if (actualCleanable.getAddress().contains(address)) {
                foundCleanables.add(actualCleanable);
            }
        }
        return foundCleanables;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();
        for (Cleanable actualCleanable : cleanables) {
            if (!sb.isEmpty()) {
                sb.append(", ");
            }
            sb.append(actualCleanable.getAddress());
        }
        return sb.toString();
    }
}
