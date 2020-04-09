package ansi;

public class PrintColor {

  /** Entry point.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    System.out.println(Colors.ANSI_RED.color + "RED");
    System.out.println(Colors.ANSI_GREEN.color  + "GREEN");
    System.out.println(Colors.ANSI_BLUE.color  + "BLUE");
    System.out.println(Colors.ANSI_RESET.color);
    System.out.println("Back to normal.");
  }
}