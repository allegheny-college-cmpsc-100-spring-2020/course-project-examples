package rpg;

/** Creates non-player character based on template.
 *
 * @author Douglas Luman
 */
public class NPC extends Character {

  /** Constructor.
   *
   * @param name NPC name
   */
  public NPC(String name) {
    this.name = name;
    this.strength = this.random.nextInt(100) + 1;
    this.intelligence = this.random.nextInt(100) + 1;
    this.luck = this.random.nextInt(100) + 1;
    this.hitPoints = 100;
    System.out.println(name);
    System.out.println(this.strength);
    System.out.println(this.intelligence);
    System.out.println(this.luck);
    System.out.println("This is the NPC!");
  }
}