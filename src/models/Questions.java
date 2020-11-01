package models;



public class Questions {
    public String question[]={                                       //array of string having questions for self analysis test
            "Are you having any of the following symptoms?",
            "Have you ever had any of the following?",
            "Which of the following apply to you?",
    };
    public String[][] options={                                         //strings mas=trix having options.
            {"Cough","Fever","Difficulty in breathing","Loss of sense of smell and taste","None"},
            {"Diabetes","Hypertension","Lungs Disease","Heart Disease","None"},
            {"Travelled internationally in last 14 days","Recently interacted with a person who had been tested positive with corona virus","Attended a function with a large gathering","Are you a health care worker","None "},
    };


    static double percentage=0;
    int initscore;
    static int score;
    String str;

    /*Function for calculating score and calculating percentage according to different questions*/
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


    }

    /*
    Function for returning different precautionary messages according to different percentages
    obtained in self analysis test.
     */
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

    /*function for returning the percentage obtained in self analysis test*/
    public double getpercentage()
    {

        return percentage*100;
    }


}
