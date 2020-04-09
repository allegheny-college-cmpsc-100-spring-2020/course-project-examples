package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/** Creates an armory for all game weapons.
 *
 * @author Douglas Luman
 */
public class Armory {

  public final ArrayList<Weapon> contents;

  /** Constructor.
   *
   */
  public Armory() {
    contents = new ArrayList<Weapon>();
    File file = null;
    Scanner input = null;
    try {
      file = new File("inputs/weapons.csv");
      input = new Scanner(file);
    } catch (FileNotFoundException noFile) {
      System.out.println("No file found.");
    }
    int index = 0;
    Scanner line;
    Weapon weapon;
    while (input.hasNext()) {
      weapon = new Weapon();
      line = new Scanner(input.nextLine());
      line.useDelimiter(",");
      while (line.hasNext()) {
        String data = line.next();
        switch(index) {
          case 0:
            weapon.setName(data);
            break;
          case 1:
            weapon.setStrength(Integer.parseInt(data));
            break;
          default:
            break;
        }
        index++;
      }
      index = 0;
      this.contents.add(weapon);
    }
  }
  
  /** Gets a random weapon from armory.
   *
   */
  public Weapon getWeapon() {
    Random seed = new Random();
    int index = seed.nextInt(this.contents.size()) - 1;
    return this.contents.get(index);
  }
}