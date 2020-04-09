package enumeration;

/** Drives the examples for enumerated types exercise.
 *
 * @author Douglas Luman
 */
public class RunKeys {
 
  /** Entry point.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Player player = new Player("Xorg");
    KeyCard rightKey = new KeyCard(KeyColor.PURPLE);
    KeyCard wrongKey = new KeyCard(KeyColor.RED);
    player.addKey(rightKey);
    if(player.getKeys(rightKey)){
      Controller.route(Scenarios.A1);
    }
  }
}