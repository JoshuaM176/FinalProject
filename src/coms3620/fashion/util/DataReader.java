package coms3620.fashion.util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {

    private BufferedReader File;

    public DataReader(String filepath) throws FileNotFoundException {
        File = new BufferedReader(new FileReader(filepath));
    }

    /**
     * Reads in one line from the csv, returns an array of objects whose type is determine by the elements string, returns null at eof
     * elementTypes string can contain
     * i - integer
     * s - string
     * For example, iss would expect the csv to contain an integer followed by two strings
     * 
     * @author Joshua Morningstar
     * @throws Exception 
     */
    public Object[] getRow(String elementTypes) throws Exception {
        String line = File.readLine();
        if(line == null) { return null; }
        String[] elements = line.split(",");
        if(elements.length != elementTypes.length()) {
            throw new LengthMismatchException("Number of elements doesn't match length of elementTypes");
        }
        Object[] objects = new Object[elements.length];
        for(int i = 0; i < elementTypes.length(); i++) {
            switch(elementTypes.charAt(i)) {
                case 'i':
                    objects[i] = Integer.parseInt(elements[i]);
                    break;
                case 'b':
                    objects[i] = elements[i] == "true";
                case 's':
                    objects[i] = elements[i];
                    break;
                default:
                    throw new Exception("Invalid elementType: " + elementTypes.charAt(i));
            }
            
        }
        return objects;
    }
    
    public void close() throws IOException {
        File.close();
    }

    public class LengthMismatchException extends IOException {
        public LengthMismatchException(String message) {
            super(message);
        }

        public LengthMismatchException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
