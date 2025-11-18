package coms3620.fashion.departments.Product_Development;

import java.io.IOException;
import java.util.List;

public interface Storage {
    void write(String line) throws IOException;
    List<String> readAll() throws IOException;
}
