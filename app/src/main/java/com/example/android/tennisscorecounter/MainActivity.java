package com.example.android.tennisscorecounter;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int scoreOutA = 0;
    int scoreOutB = 0;
    int homeRunA = 0;
    int homeRunB = 0;
    int shortHitTeamA = 0;
    int shortHitTeamB = 0;
    int longHitTeamA = 0;
    int longHitTeamB = 0;
    int advTouchTeamA = 0;
    int advTouchTeamB = 0;
    long currentChronometer;
    String score;
    Chronometer gameTime;
    Button start;
    EditText nameOfTeamA;
    EditText nameOfTeamB;
    TextView textScoreTeamA;
    TextView textScoreTeamB;
    Boolean isNameDisabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameTime = (Chronometer) findViewById(R.id.chronometer);
        start = (Button) findViewById(R.id.startButton);

        nameOfTeamA = (EditText) findViewById(R.id.nameTeamA);
        nameOfTeamB = (EditText) findViewById(R.id.nameTeamB);

        textScoreTeamA = (TextView) findViewById(R.id.scoreTeamA);
        textScoreTeamB = (TextView) findViewById(R.id.scoreTeamB);
    }

    //Next methods Sets Score for Team A
    public void outTeamA(View view) {
        scoreOutA = scoreOutA + 1;
        displayScoreOutA(scoreOutA);
        scoreStatus();
    }

    public void shortHitTeamA(View view) {
        shortHitTeamA = shortHitTeamA + 1;
        displayShortHitA(shortHitTeamA);
        scoreStatus();
    }

    public void longHitTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        longHitTeamA = longHitTeamA + 1;
        displayScoreTeamA(scoreTeamA);
        displayLongHitA(longHitTeamA);
        scoreStatus();
    }

    public void homeRunTeamA(View view) {
        scoreTeamA = scoreTeamA + 2;
        homeRunA = homeRunA + 1;
        displayScoreTeamA(scoreTeamA);
        displayHomeRunA(homeRunA);
        scoreStatus();
    }

    public void advTouchTeamA(View view) {
        scoreTeamA = scoreTeamA + 2;
        advTouchTeamA = advTouchTeamA + 1;
        displayScoreTeamA(scoreTeamA);
        displayTouchAdvA(advTouchTeamA);
        scoreStatus();
    }

//Next methods sets Score for Team B

    public void outTeamB(View view) {
        scoreOutB = scoreOutB + 1;
        displayScoreOutB(scoreOutB);
        scoreStatus();
    }

    public void shortHitTeamB(View view) {
        shortHitTeamB = shortHitTeamB + 1;
        displayShortHitB(shortHitTeamB);
        scoreStatus();
    }

    public void longHitTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        longHitTeamB = longHitTeamB + 1;
        displayScoreTeamB(scoreTeamB);
        displayLongHitB(longHitTeamB);
        scoreStatus();
    }

    public void homeRunTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        homeRunB = homeRunB + 1;
        displayScoreTeamB(scoreTeamB);
        displayHomeRunB(homeRunB);
        scoreStatus();
    }

    public void advTouchTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        advTouchTeamB = advTouchTeamB + 1;
        displayScoreTeamB(scoreTeamB);
        displayTouchAdvB(advTouchTeamB);
        scoreStatus();
    }

    //This method resets the score
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        scoreOutA = 0;
        scoreOutB = 0;
        homeRunA = 0;
        homeRunB = 0;
        shortHitTeamA = 0;
        shortHitTeamB = 0;
        longHitTeamA = 0;
        longHitTeamB = 0;
        advTouchTeamA = 0;
        advTouchTeamB = 0;
        displayScoreTeamA(scoreTeamA);
        displayScoreTeamB(scoreTeamB);
        displayScoreOutA(scoreOutA);
        displayShortHitA(shortHitTeamA);
        displayLongHitA(longHitTeamA);
        displayHomeRunA(homeRunA);
        displayTouchAdvA(advTouchTeamA);
        displayScoreOutB(scoreOutB);
        displayShortHitB(shortHitTeamB);
        displayLongHitB(longHitTeamB);
        displayHomeRunB(homeRunB);
        displayTouchAdvB(advTouchTeamB);
        scoreStatus();

        gameTime.setBase(SystemClock.elapsedRealtime());
        gameTime.stop();

        start.setEnabled(true);

        nameOfTeamA.setEnabled(true);
        nameOfTeamB.setEnabled(true);
    }

    /**
     * This method displays, under the score, a message about the score status
     * Who is leading, if the teams are tied.
     */
    private void scoreStatus() {
        if (scoreTeamA > scoreTeamB) {
            score = "Team A is leading.";
            showScoreStatus(score);
        }
        if (scoreTeamA < scoreTeamB) {
            score = "Team B is leading.";
            showScoreStatus(score);
        }

        if (scoreTeamA == scoreTeamB) {
            score = "The teams are Tied.";
            showScoreStatus(score);
        }
    }

    /**
     * This method displays, under the score, a message about the finl score status
     * Who is the winner or  if the teams are tied.
     */

    private void finalStatus() {
        if (scoreTeamA > scoreTeamB) {
            score = "Team A is the Winner.";
            showScoreStatus(score);
        }
        if (scoreTeamA < scoreTeamB) {
            score = "Team B is the Winner.";
            showScoreStatus(score);
        }

        if (scoreTeamA == scoreTeamB) {
            score = "The teams are Tied.";
            showScoreStatus(score);
        }
    }

    //this method saves current state, in case of screen rotation
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scoreA", scoreTeamA);
        outState.putInt("scoreB", scoreTeamB);
        outState.putInt("outA", scoreOutA);
        outState.putInt("outB", scoreOutB);
        outState.putInt("shortHitA", shortHitTeamA);
        outState.putInt("shortHitB", shortHitTeamB);
        outState.putInt("longHitA", longHitTeamA);
        outState.putInt("longHitB", longHitTeamB);
        outState.putInt("homeRunA", homeRunA);
        outState.putInt("homeRunB", homeRunB);
        outState.putInt("advTchA", advTouchTeamA);
        outState.putInt("advTchB", advTouchTeamB);
//saves the current Chronometer time
        outState.putLong("currentChronometer", gameTime.getBase() - SystemClock.elapsedRealtime());
        outState.putBoolean("teamNameDisabled", isNameDisabled);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        scoreTeamA = savedInstanceState.getInt("scoreA");
        scoreTeamB = savedInstanceState.getInt("scoreB");
        scoreOutA = savedInstanceState.getInt("outA");
        scoreOutB = savedInstanceState.getInt("outB");
        shortHitTeamA = savedInstanceState.getInt("shortHitA");
        shortHitTeamB = savedInstanceState.getInt("shortHitB");
        longHitTeamA = savedInstanceState.getInt("longHitA");
        longHitTeamB = savedInstanceState.getInt("longHitB");
        homeRunA = savedInstanceState.getInt("homeRunA");
        homeRunB = savedInstanceState.getInt("homeRunB");
        advTouchTeamA = savedInstanceState.getInt("advTchA");
        advTouchTeamB = savedInstanceState.getInt("advTchB");
//resume the chronometer
        currentChronometer = savedInstanceState.getLong("currentChronometer");
        gameTime.setBase(SystemClock.elapsedRealtime() + currentChronometer);
        gameTime.start();

        isNameDisabled = savedInstanceState.getBoolean("teamNameDisabled");

        if (isNameDisabled) {
            nameOfTeamA.setEnabled(false);
            nameOfTeamB.setEnabled(false);
        }

        displayScoreTeamA(scoreTeamA);
        displayScoreTeamB(scoreTeamB);
        displayScoreOutA(scoreOutA);
        displayScoreOutB(scoreOutB);
        displayShortHitA(shortHitTeamA);
        displayShortHitB(shortHitTeamB);
        displayLongHitA(longHitTeamA);
        displayLongHitB(longHitTeamB);
        displayHomeRunA(homeRunA);
        displayHomeRunB(homeRunB);
        displayTouchAdvA(advTouchTeamA);
        displayTouchAdvB(advTouchTeamB);
        scoreStatus();
    }

    //Next methods display score for Team A
    private void displayScoreTeamA(int scoreA) {
        textScoreTeamA.setText(String.valueOf(scoreA));
    }

    private void displayScoreOutA(int scoreOutA) {
        TextView scoreView = (TextView) findViewById(R.id.out_score_A);
        scoreView.setText("Faults ".concat(String.valueOf(scoreOutA)));
    }

    private void displayShortHitA(int shortHitA) {
        TextView scoreView = (TextView) findViewById(R.id.sh_score_A);
        scoreView.setText("Short Hits ".concat(String.valueOf(shortHitA)));
    }

    private void displayLongHitA(int longHitA) {
        TextView scoreView = (TextView) findViewById(R.id.lh_score_A);
        scoreView.setText("Long Hits ".concat(String.valueOf(longHitA)));
    }

    private void displayHomeRunA(int homeRunA) {
        TextView scoreView = (TextView) findViewById(R.id.hr_score_A);
        scoreView.setText("Home Runs ".concat(String.valueOf(homeRunA)));
    }

    private void displayTouchAdvA(int tchAdvA) {
        TextView scoreView = (TextView) findViewById(R.id.tch_score_A);
        scoreView.setText("Adv touch ".concat(String.valueOf(tchAdvA)));
    }

    //Next methods display score for Team B
    private void displayScoreTeamB(int scoreB) {
        textScoreTeamB.setText(String.valueOf(scoreB));
    }

    private void displayScoreOutB(int scoreOutB) {
        TextView scoreView = (TextView) findViewById(R.id.out_score_B);
        scoreView.setText(String.valueOf(scoreOutB).concat(" Faults"));
    }

    private void displayShortHitB(int shortHitB) {
        TextView scoreView = (TextView) findViewById(R.id.sh_score_B);
        scoreView.setText(String.valueOf(shortHitB).concat(" Short Hits"));
    }

    private void displayLongHitB(int longHitB) {
        TextView scoreView = (TextView) findViewById(R.id.lh_score_B);
        scoreView.setText(String.valueOf(longHitB).concat(" Long Hits"));
    }

    private void displayHomeRunB(int homeRunB) {
        TextView scoreView = (TextView) findViewById(R.id.hr_score_B);
        scoreView.setText(String.valueOf(homeRunB).concat(" Home Runs"));
    }

    private void displayTouchAdvB(int tchAdvB) {
        TextView scoreView = (TextView) findViewById(R.id.tch_score_B);
        scoreView.setText(String.valueOf(tchAdvB).concat(" Adv touch"));
    }

    private void showScoreStatus(String score) {
        TextView scoreStatus = (TextView) findViewById(R.id.scoreStatus);
        scoreStatus.setText(score);
    }

    /**
     * starts Chronometer when the START button is pressed
     * sets the two edit views that contains the teams name enable
     */
    public void startGame(View view) {
        gameTime.setBase(SystemClock.elapsedRealtime());
        gameTime.start();

        nameOfTeamA.setEnabled(false);
        nameOfTeamB.setEnabled(false);
        isNameDisabled = true;
    }

    /**
     * stops Chronometer when the END button is pressed
     * displays on status bar the team that won
     * sets the start button inactive
     * sets the score buttons inactive
     */
    public void stopGame(View view) {
        gameTime.stop();
        finalStatus();
        start.setEnabled(false);
    }
}