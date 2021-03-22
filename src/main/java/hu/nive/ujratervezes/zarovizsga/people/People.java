package hu.nive.ujratervezes.zarovizsga.people;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {


    public int getNumberOfMales(String path) {
        Path file = Path.of(path);
        int maleCount = 0;
        try (BufferedReader br = Files.newBufferedReader(file)) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] lineData = line.split(",");
                if (lineData[4].equals("Male")) {
                    maleCount++;
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot load resource", ioe);
        }
        return maleCount;
    }

}
