package catsurvey;

public class SurveyQuestion {
  
  private String question;
  private double activeRank;
  private double companionRank;
  private double beautyRank;
  private double entertainRank;
  private int userResponse;

  public void setQuestionText(String text) {
    this.question = text;
  }
  
  public void setActiveRank(double value) {
    this.activeRank = value;
  }
  
  public double getActiveRank() {
    return this.activeRank;
  }
  
  public void setCompanionRank(double value) {
    this.companionRank = value;
  }
  
  public double getCompanionRank() {
    return this.companionRank;
  }
  
  public void setBeautyRank(double value) {
    this.beautyRank = value;
  }
  
  public double getBeautyRank() {
    return this.beautyRank;
  }
  
  public void setEntertainRank(double value) {
    this.entertainRank = value;
  }
  
  public double getEntertainRank() {
    return this.entertainRank;
  }
  
  public void setUserResponse(int choice) {
    this.userResponse = choice;
  }
  
  public int getUserResponse() {
    return this.userResponse;
  }
  
  public String toString() {
    return this.question;
  }
}