package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public abstract class FileReader {

    protected abstract Path getPathToFile(String stringPath);

    public final Stream<String> getFileStream(String stringPath) throws IOException {
        return Files.lines(getPathToFile(stringPath));
    }

}
