package rpg;

import java.util.Random;

/** Creates template for all character objects.
 *
 * @author Douglas Luman
 */
public abstract class Character {

  protected String name;
  protected int strength;
  protected int intelligence;
  protected int luck;
  protected int hitPoints;
  protected Random random = new Random();
  
  /** Template for fight.
   *
   * @param character Character to attack
   * @param power Strength of attack
   */
  public void attack(Character character, int power) {
    character.hitPoints -= power;
  }

}