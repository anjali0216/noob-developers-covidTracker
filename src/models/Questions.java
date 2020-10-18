package models;
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
    int correct_guess=0;
    int total_ques= question.length;
    int result;


}
