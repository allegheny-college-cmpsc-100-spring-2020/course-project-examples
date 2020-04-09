package screen;

import java.util.Scanner;

public class CLS {

  public static void main(String[] args) {
    System.out.println("This text is here.");
    System.out.print("Should it go away (Y/N)? ");
    Scanner input = new Scanner(System.in);
    String response;
    do {
      response = input.nextLine();
      if(response.equalsIgnoreCase("Y")) {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        System.out.print("It's gone! Should this go away (Y/N)?");
      } else {
        System.out.println("Alright, then.");
      }
    }
    while(!response.equalsIgnoreCase("N"));
  }
}