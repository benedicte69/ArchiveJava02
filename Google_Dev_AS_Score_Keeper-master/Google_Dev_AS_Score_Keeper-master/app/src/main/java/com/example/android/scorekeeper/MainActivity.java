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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the score of the team A
     *
     * @param currentScoreA The current score of team A
     */

    public void displayScoreTeamA(int currentScoreA) {
        TextView scoreView = findViewById(R.id.score_team_a);
        scoreView.setText(String.valueOf(currentScoreA));
    }

    /**
     * Displays the score of the team B
     *
     * @param currentScoreB The current score of the team B
     */

    public void displayScoreTeamB(int currentScoreB) {
        TextView scoreView = findViewById(R.id.score_team_b);
        scoreView.setText(String.valueOf(currentScoreB));
    }

    /**
     * Adds points to the team A
     *
     * @param view The view in which the team A's score is displayed
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
     * Adds points to the team B
     *
     * @param view The view in which the team B's score is displayed
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
     * Resets the points of both teams to 0
     *
     * @param view The view in which the teams' score is displayed
     */

    public void resetScoreKeeper(View view) {
        scoreKeeperTeamA = 0;
        displayScoreTeamA(scoreKeeperTeamA);

        scoreKeeperTeamB = 0;
        displayScoreTeamB(scoreKeeperTeamB);
    }
}
