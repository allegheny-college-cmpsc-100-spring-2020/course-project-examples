package adventuretimetoo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/** Creates a standing version of the Narrative.
 *
 * @author Douglas Luman
 */
public class Narrative {
  
  private static ArrayList<Scene> story;
  
  /** Loads all scenes from file.
   *
   * @param filePath path to file
   */
  public static ArrayList<Scene> load(String filePath) {
    File file = null;
    Scanner input = null;
    try {
      file = new File(filePath);
      input = new Scanner(file);
    } catch (FileNotFoundException noFile) {
      System.out.println("Error loading file!");
      System.exit(0);
    }
    
    int column = 1;
    Scanner line = null;
    Scene scene = null;
    ArrayList<Scene> scenes = new ArrayList<Scene>();
    
    while (input.hasNext()) {
      line = new Scanner(input.nextLine());
      line.useDelimiter("\t");
      scene = new Scene();
      while (line.hasNext()) {
        switch (column) {
          case 1:
            scene.addID(line.next());
            break;
          case 2:
            scene.addText(line.next());
            break;
          case 3:
            scene.addPrompt(line.next());
            break;
          default:
            scene.addBranch(line.next());
            break;
        }
        column++;
      }
      scenes.add(scene);
      column = 1;
    }
    story = scenes;
    return scenes;
  }
  
  /** Retrieves scene based on user choice, correctly routes story.
   *
   * @param choice Text-based choice made by user
   */
  public static int getSceneIndex(String choice) {
    int index = -1;
    
    Scene scene;
    Branch branch;
    
    int difficulty = 0;
    boolean test = false;
    String outcome = new String();
    
    for (int i = 0; i < story.size(); i++) {
      scene = story.get(i);
      for (int j = 0; j < scene.getBranches().size(); j++) {
        branch = scene.getBranches().get(j);
        if (branch.getChoice().equals(choice)) {
          outcome = branch.getOutcome();
          difficulty = branch.getDifficulty();
          if (testDifficulty(difficulty) || difficulty < 1) {
            break;
          } else {
            choice = scene.getBranches().get(j+1).getChoice();
          }
        }
      }
      if (scene.getID().equals(outcome)) {
        index = story.indexOf(scene);
      }
    }
    return index;
  }
  
  /** Tests difficulty, if present.
   *
   * @param difficulty Level of difficulty from file
   */
  private static boolean testDifficulty(int difficulty) {
    Random random = new Random();
    if (random.nextInt(20) + 1 > difficulty) {
      return true;
    }
    return false;
  }
}