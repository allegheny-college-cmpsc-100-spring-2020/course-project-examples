package mkdir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MakeDir {

  public static void main(String[] args) {
    File file = null;
    try {
      if (!new File("key").exists()) {
        new File("key").mkdir();
      }
      file = new File("key/ssk.key");
      FileWriter writer = new FileWriter(file);
      writer.write("THE KEY!");
      writer.close();
    } catch (IOException noFile) {
      System.exit(0);
    }
  }
}