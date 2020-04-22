package catsurvey;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunSurvey {

  public static void main(String[] args) {
    File file = null;
    Scanner input = null;
    try {
      file = new File("inputs/survey.csv");
      input = new Scanner(file);
    } catch (FileNotFoundException noFile) {
      System.exit(0);
    }
    
    Survey survey = new Survey();
    
    Scanner line;
    int column = 1;
    String question;
    SurveyQuestion surveyQuestion;
    
    while (input.hasNextLine()) {
      line = new Scanner(input.nextLine());
      line.useDelimiter("\t");
      surveyQuestion = new SurveyQuestion();
      while (line.hasNext()) {
        switch (column) {
          case 1:
            surveyQuestion.setQuestionText(line.next());
            break;
          case 2:
            surveyQuestion.setActiveRank(line.nextDouble());
            break;
          case 3:
            surveyQuestion.setCompanionRank(line.nextDouble());
            break;
          case 4:
            surveyQuestion.setBeautyRank(line.nextDouble());
            break;
          case 5:
            surveyQuestion.setEntertainRank(line.nextDouble());
            break;
          default:
            break;
        }
        column++;
      }
      survey.addQuestion(surveyQuestion);
      column = 1;
    }
    
    Scanner keyInput = new Scanner(System.in);
    int choice;
    
    ArrayList<SurveyQuestion> questions = survey.getSurveyQuestions();
    
    for (int i = 0; i < questions.size(); i++) {
      surveyQuestion = questions.get(i);
      do {
        System.out.print(surveyQuestion + " ");
        choice = keyInput.nextInt();
      }
      while
      (choice > 5 || choice < 1);
      surveyQuestion.setUserResponse(choice);
      questions.set(i, surveyQuestion);
    }
    
    survey.score();
    
    System.out.println();
    System.out.print(survey);
  }
}