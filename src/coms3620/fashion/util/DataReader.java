package coms3620.fashion.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataReader {

    private BufferedReader File;

    public DataReader(String filepath) throws FileNotFoundException {
        File = new BufferedReader(new FileReader(filepath));
    }
    //TODO
}
