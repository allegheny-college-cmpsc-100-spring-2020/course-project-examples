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

public class WriteMessage {

  public static void main(String[] args) {
    Image image = null;
    FileInputStream fileStream;
    try {
      fileStream = new FileInputStream("inputs/spirited_away.jpg");
      image = new Image(fileStream);
    } catch (FileNotFoundException noFile) {
      System.out.println("Error reading image!");
    }
    
    String message = "This is from Spirited Away, a Hayao Miyazaki film!";
    ArrayList<Character> msg = new ArrayList<Character>();
    for (char c: message.toCharArray()) {
      msg.add(c);
    }

    int width = (int)image.getWidth();
    int height = (int)image.getHeight();

    PixelReader reader = image.getPixelReader();
    
    WritableImage writable = new WritableImage(width,height);
   
    PixelWriter writer = writable.getPixelWriter();
    
    Random choice = new Random();

    for(int w = 0; w < width; w++) {
      for (int h = 0; h < height; h++) {
        int argb = reader.getArgb(w,h);
        
        int alpha = (argb >> 24) & 0xFF;
        int red = (argb >> 16) & 0xFF;
        int green = (argb >> 8) & 0xFF;
        int blue = (argb) & 0xFF;
        
        if (msg.size() > 0) {
          int charShift = (char)msg.get(0);
          charShift &=0xFF;
          msg.remove(0);
          argb = (charShift << 24) + (red << 16) + (green << 8) + (blue);
        }
        
        writer.setArgb(w,h,argb);
        
      }
    }
    
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
