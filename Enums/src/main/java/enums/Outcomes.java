package enumeration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Documents all possible outcomes.
 *
 * @author Douglas Luman
 */
public class Outcomes {

  /** Outcome A1.
   *
   */
  public static void A1() {
    String outcome = readOutcome("inputs/A1.outcome");
    System.out.println(outcome);
  }
  
  private static String readOutcome(String filePath) {
    String text = new String();
    try{
      File file = new File(filePath);
      Scanner input = new Scanner(file);
      while (input.hasNext()) {
        text += input.nextLine();
      }
    } catch (FileNotFoundException noFile) {
      System.out.println("Error with file!");
    }
    return text;
  }
}