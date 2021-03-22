package hu.nive.ujratervezes.zarovizsga.words;

public class Words {

    private final String digits = "0123456789";


    public boolean hasMoreDigits(String s) {
        if (s == null || s.isBlank()) {
            return false;
        }
        int digitCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (digits.contains(Character.toString(s.charAt(i)))) {
                digitCount++;
            }
        }
        return digitCount > s.length() / 2;
    }
}
