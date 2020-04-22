package catsurvey;

import java.util.ArrayList;

public class Survey {

  private ArrayList<SurveyQuestion> survey;
  private int activeScore = 0;
  private int companionScore = 0;
  private int beautyScore = 0;
  private int entertainScore = 0;

  public Survey() {
    this.survey = new ArrayList<SurveyQuestion>();
  }
  
  public void addQuestion(SurveyQuestion question) {
    this.survey.add(question);
  }
  
  public void score() {
    SurveyQuestion question;
    for (int i = 0; i < this.survey.size(); i++) {
      question = this.survey.get(i);
      activeScore += question.getActiveRank() * question.getUserResponse();
      companionScore += question.getCompanionRank() * question.getUserResponse();
      beautyScore += question.getBeautyRank() * question.getUserResponse();
      entertainScore += question.getEntertainRank() * question.getUserResponse();
    }
  }
  
  public ArrayList<SurveyQuestion> getSurveyQuestions() {
    return this.survey;
  }
  
  public String toString() {
    return "Active cat score: " + this.activeScore + "\n"
           + "Friendly cat score: "+ this.companionScore + "\n"
           + "Pretty cat score: " + this.beautyScore + "\n"
           + "Entertaining cat score: " + this.entertainScore + "\n";
  }
}