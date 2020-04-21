package adventuretimetoo;

/** Creates an object representing a "branch" of a scene.
 *
 * @author Douglas Luman
 */
public class Branch {
  
  private String choice;
  private String outcome;
  private int difficulty;
  
  /** Constructor.
   *
   * @param Branch string in {CHOICE}:{OUTCOME}:{DIFFICULTY} format
   */
  public Branch(String branch) {
    String[] parts = branch.split(":");
    int index = 0;
    do {
      switch(index) {
        case 0:
          this.choice = parts[index];
          break;
        case 1:
          this.outcome = parts[index];
          break;
        case 2:
          this.difficulty = Integer.parseInt(parts[index]);
          break;
        default:
          break;
      }
      index++;
    }
    while (index < parts.length);
  }
  
  /** Retrieves a branch's choice value.
   *
   */
  public String getChoice() {
    return this.choice;
  }
  
  /** Retrieves the scene to proceed to.
   *
   */
  public String getOutcome() {
    return this.outcome;
  }
  
  /** Retrieves any difficulty associated with the choice.
   *
   */
  public int getDifficulty() {
    return this.difficulty;
  }
}