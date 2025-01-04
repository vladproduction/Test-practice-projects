package com.vladproduction.studentparametersscore;

public class StudentStatScore {

    private int score;

    public void calculateScore(int mathScore, int literacyScore){
        if(mathScore < 0 || mathScore > 100 || literacyScore < 0 || literacyScore > 100){
           score = -1;
        }
        else {
            score = mathScore * literacyScore;
        }
    }

    public int getScore() {
        return score;
    }
}
