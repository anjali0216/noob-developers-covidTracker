package models;

import javafx.scene.text.Font;
import sample.Quiz;

public class Questions {
    public String question[]={
            "Are you having any of the following symptoms",
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
    char ans;
    int index=0;
    static int score;
    int correct_guess=0;
    int total_ques= question.length;
    int result;
    String str;
    public void calucalatescore(int ind,boolean ans1,boolean ans2,boolean ans3,boolean ans4){
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
        }
        else if (ind == 1) {
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
        }
        else if (ind == 2) {
            if (ans1 == true) {
                score += 1;
            }
            if (ans2 == true) {
                score += 2;
            }
            if (ans3 == true) {
                score += 1;
            }
        }
    }

    public double getpercentage(){
        return (score/  45.0*100);
    }


    public String getscore(){
        if(score>=15)
        {
            str="You have high risk of being infected with covid 19."+"\n"+"Please consult to a medical doctor";
        }
        else if(score>=10&&score<15)
        {

            str="You have less risk of being infected with covid 19 "+"\n" +"try to remain in quaratine for few days and check the symptoms.";
        }
        else
        {
            str="Chinta mtkr bhai sb mst h";
        }
        return str;
    }



}
