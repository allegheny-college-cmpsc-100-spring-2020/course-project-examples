package steganography;

import java.awt.image.*;

import javafx.embed.swing.SwingFXUtils;

import javax.imageio.ImageIO;

import javafx.scene.image.*;
import javafx.scene.paint.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/** Hides a message in an image file using the alpha channel.
 *
 * @author Douglas Luman
 */
public class WriteMessage {

  /** Entry point.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    // Point Scanner at file, set up empty Image
    Image image = null;
    FileInputStream fileStream;
    try {
      fileStream = new FileInputStream("inputs/spirited_away.jpg");
      image = new Image(fileStream);
    } catch (FileNotFoundException noFile) {
      System.out.println("Error reading image!");
    }
    
    // Create a character array of the String message
    String message = "This is from Spirited Away, a Hayao Miyazaki film!";
    ArrayList<Character> msg = new ArrayList<Character>();
    // Read as: "for character c in the list of characters in message"
    for (char c: message.toCharArray()) {
      msg.add(c);
    }

    // Retrieve height, width of image
    int width = (int)image.getWidth();
    int height = (int)image.getHeight();

    // Create reader for pixels of loaded image
    PixelReader reader = image.getPixelReader();
    
    // Create a blank image to write to
    WritableImage writable = new WritableImage(width,height);
   
    // Create a device to write pixels to blank image
    PixelWriter writer = writable.getPixelWriter();

    for(int w = 0; w < width; w++) {
      for (int h = 0; h < height; h++) {
        int argb = reader.getArgb(w,h);
        
        // A color is a 32-bit data structure (aka "thing")
        // 24-32           16-23         8-15            0-7
        // <-8 bits alpha-><-8 bits red-><-8 bits green-><-8 bits blue->
        
        int alpha = (argb >> 24) & 0xFF; // 0 - 255 <-- we only care about this; we're hiding stuff here
        int red = (argb >> 16) & 0xFF;   // 0 - 255
        int green = (argb >> 8) & 0xFF;  // 0 - 255
        int blue = (argb) & 0xFF;        // 0 - 255
        
        if (msg.size() > 0) {
          int charShift = (char)msg.get(0);
          charShift &=0xFF;
          msg.remove(0);
          // Bit-wise "re-addition" of colors and new alpha channel
          argb = (charShift << 24) + (red << 16) + (green << 8) + (blue);
        }
        
        // Set a pixel's ARGB value
        writer.setArgb(w,h,argb);
        
      }
    }
    
    // Convert and write image

    BufferedImage buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    SwingFXUtils.fromFXImage((Image)writable, buffer);

    try{
      ImageIO.write(buffer,"png",new File("outputs/spirited_away.png"));
      System.out.println("Write success!");
    } catch (IOException ioExcept) {
      System.out.println("IO Exception!");
      System.out.println(ioExcept);
    }
  }
}
