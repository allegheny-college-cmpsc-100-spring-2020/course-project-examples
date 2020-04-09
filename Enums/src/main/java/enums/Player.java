package enumeration;

import java.util.ArrayList;

/** Creates Player object.
 *
 * @author Douglas Luman
 */
public class Player {

  public final String name;
  private ArrayList<KeyCard> keys;

  /** Constructor.
   *
   * @param name Character name
   */
  public Player(String name) {
    this.name = name;
    this.keys = new ArrayList<KeyCard>();
  }
  
  /** Adds a key to player's inventory.
   *
   * @param key Key to add
   */
  public void addKey(KeyCard key) {
    this.keys.add(key);
  }
  
  /** Searches inventory for player's keys.
   *
   * @param key Key to find.
   */
  public boolean getKeys(KeyCard key) {
    for(int i = 0; i < this.keys.size(); i++) {
      KeyCard k = this.keys.get(i);
      if (k.color == key.color) {
        return true;
      }
    }
    return false;
  }
}