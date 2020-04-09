package plinko;

import java.util.Random;

/** Demonstrates 1D array of Point objects.
 *
 * @author Douglas Luman
 */
public class DemoPoints {

  /** Entry point.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Random randXY = new Random();
    Point point;
    Point[] points = new Point[21];
    for(int i = 0; i < points.length; i++) {
      int x = randXY.nextInt(15) + 1;
      int y = randXY.nextInt(20) + 1;
      point = new Point(x,y);
      points[i] = point;
    }
    for(int i = 0; i < points.length; i++) {
      System.out.println(points[i].x);
    }
  }
}