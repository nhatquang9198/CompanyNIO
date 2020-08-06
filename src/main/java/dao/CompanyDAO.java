package dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CompanyDAO {

    public CompanyDAO() {
    }

    public BufferedReader readFile(Path path) {
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while (reader.readLine() != null) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
