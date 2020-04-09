package adventure;

/** Runs the game proper.
 *
 * @author Douglas Luman
 */
public class RunRPG {

  /** Entry point.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    NPC npc = new NPC("Xorg");
    System.out.println("You defeated " + npc.name + " and they dropped " + npc.dropLoot());
  }
}