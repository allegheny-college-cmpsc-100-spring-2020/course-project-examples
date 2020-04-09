package adventure;

/** Creates NPCs based on template.
 *
 * @author Douglas Luman
 */
public class NPC extends Character {

  private Armory armory = new Armory();

  /** Constructor.
   *
   * @param name Name of NPC
   */
  public NPC(String name) {
    this.name = name;
    this.weapon = armory.getWeapon();
  }
  
  /** Drops weapon the NPC carries.
   *
   */
  public Weapon dropLoot() {
    return this.weapon;
  }
  
  /** Creates string representation of NPC.
   *
   */
  public String toString() {
    return this.name + " has " + this.weapon;
  }
}