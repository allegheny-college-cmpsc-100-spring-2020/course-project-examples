package plinko;

/** Creates a point object.
 *
 * @author Douglas Luman
 */
public class Point {

  public final int x;
  public final int y;
  
  /** Constructor.
   *
   * @param x Point x value
   * @param y Point y value
   */
  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  /** String representation of points.
   *
   */
  public String toString() {
    String coords = "(" + this.x + ", " + this.y + ")";
    return coords;
  }
}