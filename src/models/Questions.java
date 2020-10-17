package models;
public class Questions {
    public String question[]={
            "hiw are you",
            "what is your name",
            "hhow nmauny children you are planning",
    };
    public String[][] options={
            {"sexy","hot","breilliant","awesome"},
            {"anu","payal","bhavna","mummy"},
            {"10","20","30","40"},
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
