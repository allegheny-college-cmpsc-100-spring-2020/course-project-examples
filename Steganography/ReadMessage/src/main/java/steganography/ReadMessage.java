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

public class ReadMessage {

  public static void main(String[] args) {
    Image image = null;
    FileInputStream fileStream;
    try {
      fileStream = new FileInputStream("inputs/spirited_away.png");
      image = new Image(fileStream);
    } catch (FileNotFoundException noFile) {
      System.out.println("Error reading image!");
    }

    int width = (int)image.getWidth();
    int height = (int)image.getHeight();

    PixelReader reader = image.getPixelReader();

    for(int w = 0; w < width; w++) {
      for (int h = 0; h < height; h++) {
        int argb = reader.getArgb(w,h);
        
        int alpha = (argb >> 24) & 0xFF;
        int red =   (argb >> 16) & 0xFF;
        int green = (argb >>  8) & 0xFF;
        int blue =  (argb      ) & 0xFF;
        
        if (alpha < 255) {
          System.out.print((char)alpha);
        }
      }
    }
  }
}
