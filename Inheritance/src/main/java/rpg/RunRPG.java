package rpg;

/** Runs the example.
 *
 * @author Douglas Luman
 */
public class RunRPG {
  
  /** Entry point.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args){
    PC pc = new PC("Lex");
    NPC npc = new NPC("Ulysses");
    npc.attack(pc,10);
    System.out.print(pc.hitPoints);
  }
}