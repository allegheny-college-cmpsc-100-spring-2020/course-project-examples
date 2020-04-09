package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

/** Demonstrates exception handling in loops with Scanners.
 *
 * @author Douglas Luman
 */
public class KeepRunning {

  /** Entry point.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    int pos = -1;
    Scanner input = new Scanner(System.in);
    do {
      System.out.print("Enter a number: ");
      try {
        pos = input.nextInt();
      } catch (InputMismatchException | NumberFormatException notInt) {
        input.nextLine();
      }
      if (pos < 1 || pos > 8) {
        System.out.println("Please enter a number between 1 and 8.");
      }
    }
    while (pos < 1 || pos > 8);
  }
}