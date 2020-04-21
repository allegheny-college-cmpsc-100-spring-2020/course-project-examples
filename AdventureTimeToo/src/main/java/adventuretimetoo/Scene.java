package adventuretimetoo;

import java.util.ArrayList;

/** Creates a scene object.
 *
 * @author Douglas Luman
 */
public class Scene {

  private String id;
  private String text;
  private String prompt;
  private ArrayList<Branch> branches;

  /** Constructor.
   *
   */
  public Scene() {
    branches = new ArrayList<Branch>();
  }
  
  /** Sets a scene's ID value.
   *
   * @param id ID value for scene (from file)
   */
  public void addID(String id) {
    this.id = id;
  }
  
  /** Sets the text to display for scene.
   *
   * @param text Text value for scene (from file)
   */
  public void addText(String text) {
    this.text = text;
  }
  
  /** Sets the prompt text value.
   *
   * @param prompt Prompt text value for scene (from file)
   */
  public void addPrompt(String prompt) {
    this.prompt = prompt;
  }
  
  /** Adds a branch to the scene.
   *
   * @param String 
   */
  public void addBranch(String option) {
    Branch branch = new Branch(option);
    this.branches.add(branch);
  }
  
  /** Retrieves the ID of the scene.
   *
   */
  public String getID() {
    return this.id;
  }
  
  /** Retrieves the screen text of the scene.
   *
   */
  public String getText() {
    return this.text;
  }
  
  /** Retrieves the "prompt" of the scene.
   *
   */
  public String getPrompt() {
    return this.prompt;
  }
  
  /** Retrieves a list of branches in the scene.
   *
   */
  public ArrayList<Branch> getBranches() {
    return this.branches;
  }
}