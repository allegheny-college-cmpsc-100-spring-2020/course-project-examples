package adventure;

import java.util.Random;

/** Creates a template for Characters.
 *
 * @author Douglas Luman
 */
public abstract class Character {

  protected String name;
  protected int strength;
  protected int agilty;
  protected int intellect;
  protected int endurance;
  protected Weapon weapon;
  protected Job job;
  protected Random random = new Random();
  
}