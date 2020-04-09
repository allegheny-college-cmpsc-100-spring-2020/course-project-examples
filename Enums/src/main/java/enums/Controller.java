package enumeration;

/** Controller for scenario outcomes.
 *
 * @author Douglas Luman
 */
public class Controller {

  /** Routes user outcomes based on scenario.
   *
   * @param scenario Scenario enum to look up
   */
  public static void route(Scenarios scenario) {
    switch(scenario) {
      case A1:
        Outcomes.A1();
        break;
      default:
        break;
    }
  }
}