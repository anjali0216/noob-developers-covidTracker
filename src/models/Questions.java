package models;

import javafx.scene.text.Font;
import sample.Quiz;

public class Questions {
    public String question[]={
            "Are you having any of the following symptoms?",
            "Have you ever had any of the following?",
            "Which of the following apply to you?",
    };
    public String[][] options={
            {"Cough","Fever","Difficulty in breathing","Loss of sense of smell and taste","None"},
            {"Diabetes","Hypertension","Lungs Disease","Heart Disease","None"},
            {"Travelled internationally in last 14 days","Recently interacted with a person who had been tested positive with corona virus","Attended a function with a large gathering","Are you a health care worker","None "},
    };
    char[] answer={
            'a','b','c'
    };

    char guess;
    static double percentage=0;
    int initscore;
    char ans;
    int index=0;
    static int score;
    int correct_guess=0;
    int total_ques= question.length;
    int result;
    String str;
    public void calculatescore(int ind,boolean ans1,boolean ans2,boolean ans3,boolean ans4){
        if (ind == 0) {
            if (ans1 == true) {
                score += 5;
            }
            if (ans2 == true) {
                score += 10;
            }
            if (ans3 == true) {
                score += 15;
            }
            if (ans4 == true) {
                score += 15;
            }
            percentage=(score/45.0);
        }
        else if (ind == 1) {
            initscore=score;
            if (ans1 == true) {
                score += 1;
            }
            if (ans2 == true) {
                score += 1;
            }
            if (ans3 == true) {
                score += 1;
            }
            if (ans4 == true) {
                score += 1;
            }
            //System.out.println(percentage);
            percentage=percentage+(1-percentage)*(score-initscore)/4.0;
        }
        else if (ind == 2) {
            initscore=score;
            if (ans1 == true) {
                score += 1;
            }
            if (ans2 == true) {
                score += 2;
            }
            if (ans3 == true) {
                score += 1;
            }
            percentage=(percentage+(1-percentage)*(score-initscore)/4.0);

        }
        //System.out.println(percentage);

    }
//
//    public double getpercentage(){
//        return (score/  45.0*100);
//    }


    public String getscore(){
        if(percentage>=0.6)
        {
            str="You have high risk of being infected with covid 19."+"\n"+"Please consult to a medical doctor";
        }
        else if(percentage>=0.3&&percentage<0.6)
        {

            str="You have less risk of being infected with covid 19 "+"\n" +"try to remain in quaratine for few days and check the symptoms.";
        }
        else
        {
            str="Lite lo...all is well :)";
        }
        percentage=0;
        score=0;
        return str;
    }

    
    public double getpercentage()
    {
        double ans=percentage*100;

        return ans;
    }


}
