package adventure;

/** Creates a weapon object.
 *
 * @author Douglas Luman
 */
public class Weapon {

  private int strength;
  private int agility;
  private int intellect;
  private int endurance;
  private String name;
  
  /** Constructor.
   *
   */
  public Weapon() {
   
  }
  
  /** Sets name of weapon.
   *
   * @param name Name of weapon
   */
  public void setName(String name) {
    this.name = name;
  }
  
  /** Sets strength of weapon.
   *
   * @param stat Strength of weapon as integer
   */
  public void setStrength(int stat) {
    this.strength = stat;
  }
  
  /** Creates string representation of weapon.
   *
   */
  public String toString() {
    return this.name + " (Strength: " + this.strength + ")";
  }
}