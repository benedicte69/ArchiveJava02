package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int scoreKeeperTeamA = 0;
    private int scoreKeeperTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // call the super class onCreate to complete the creation of activity like
        // the view hierarchy
        super.onCreate(savedInstanceState);
        // set the user interface layout for this Activity
        // the layout file is defined in the project res/layout/main_activity.xml file
        setContentView(R.layout.activity_main);
    }

    /*@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("teamA",scoreKeeperTeamA );
        outState.putInt("teamB", scoreKeeperTeamB);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreKeeperTeamA  = savedInstanceState.getInt("teamA");
        scoreKeeperTeamB = savedInstanceState.getInt("teamB");
    }*/


    /**
     * Displaying the score of team A
     */

    public void displayScoreTeamA(int score) {
        TextView scoreView = findViewById(R.id.score_team_a);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displaying the score of team B
     */
    public void displayScoreTeamB(int score) {
        TextView scoreView = findViewById(R.id.score_team_b);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adding points to the team A
     */

    public void addThreePointToA(View view) {
        scoreKeeperTeamA = scoreKeeperTeamA + 3;
        displayScoreTeamA(scoreKeeperTeamA);
    }

    public void addSixPointToA(View view) {
        scoreKeeperTeamA = scoreKeeperTeamA + 6;
        displayScoreTeamA(scoreKeeperTeamA);
    }

    public void addOnePointToA(View view) {
        scoreKeeperTeamA = scoreKeeperTeamA + 1;
        displayScoreTeamA(scoreKeeperTeamA);
    }

    public void addTwoPointToA(View view) {
        scoreKeeperTeamA = scoreKeeperTeamA + 2;
        displayScoreTeamA(scoreKeeperTeamA);
    }

    /**
     * Adding points to the team B
     */

    public void addThreePointToB(View view) {
        scoreKeeperTeamB = scoreKeeperTeamB + 3;
        displayScoreTeamB(scoreKeeperTeamB);
    }

    public void addSixPointToB(View view) {
        scoreKeeperTeamB = scoreKeeperTeamB + 6;
        displayScoreTeamB(scoreKeeperTeamB);
    }

    public void addOnePointToB(View view) {
        scoreKeeperTeamB = scoreKeeperTeamB + 1;
        displayScoreTeamB(scoreKeeperTeamB);
    }

    public void addTwoPointToB(View view) {
        scoreKeeperTeamB = scoreKeeperTeamB + 2;
        displayScoreTeamB(scoreKeeperTeamB);
    }

    /**
     * Resetting points to team A and team B to 0
     */

    public void resetScoreKeeper(View view) {
        scoreKeeperTeamA = scoreKeeperTeamA;
        scoreKeeperTeamA = 0;
        displayScoreTeamA(scoreKeeperTeamA);

        scoreKeeperTeamB = scoreKeeperTeamB;
        scoreKeeperTeamB = 0;
        displayScoreTeamB(scoreKeeperTeamB);
    }
}
