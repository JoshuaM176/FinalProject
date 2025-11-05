package coms3620.fashion.util;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {

    private BufferedWriter File;

    public DataWriter(String path) throws IOException {
        File = new BufferedWriter(new FileWriter(path));
    }
    //TODO
}
