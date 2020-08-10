package util;

import io.CSVReader;
import io.FileReader;

public class FileReaderFactory {

    private FileReaderFactory() {
    }

    private static class Holder {
        private static final FileReaderFactory INSTANCE = new FileReaderFactory();
    }

    public static FileReaderFactory getInstance() {
        return Holder.INSTANCE;
    }

    public FileReader getCSVReader(){
        return new CSVReader();
    }
}
