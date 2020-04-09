package ansi;

/** Documents colors used in changing console text color.
 *
 * Additional colors/context: 
 * https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
 */
public enum Colors {
  ANSI_RED("\u001B[31m"),
  ANSI_GREEN("\u001B[32m"),
  ANSI_BLUE("\u001B[34m"),
  ANSI_RESET("\u001B[0m");
  
  public final String color;
  
  private Colors(String color) {
    this.color = color;
  }
}