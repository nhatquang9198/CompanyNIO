package io;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CSVReader extends FileReader {

    @Override
    protected Path getPathToFile(String stringPath) {
        return Paths.get(stringPath);
    }

}
