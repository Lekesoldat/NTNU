package app;

import java.io.File;
import java.io.IOException;

public interface FileManager {
  void readFile(File file) throws IOException;
  void writeFile(File file) throws IOException;
}
