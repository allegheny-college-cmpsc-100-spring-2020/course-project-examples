package adventuretimetoo;

import java.util.ArrayList;
import java.util.Scanner;

/** Driver class for the RPG.
 *
 * @author Douglas Luman
 */
public class RunRPG {

  /** Entry point.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Welcome to class.");
    
    ArrayList<String> branches;
    ArrayList<Scene> scenes = Narrative.load("inputs/encounters.dat");
    
    int index = 0;
    Scene currentScene;
    Scanner response = new Scanner(System.in);
    String choice;
    
    while (true) {
      currentScene = scenes.get(index);
      System.out.println(currentScene.getText());
      if (currentScene.getBranches().size() < 1) {
        break;
      }
      System.out.print(currentScene.getPrompt() + " ");
      choice = response.nextLine();
      index = Narrative.getSceneIndex(choice);
    }
  }
}