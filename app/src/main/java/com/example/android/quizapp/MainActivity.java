package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int score = 0;
    int numOfCorrectAns = 0;
    int totalScore = 0;
    //Declares answers for radio group options and imageButtons

    final int correctAnsQtnOne = R.id.q1_radio_btn2;
    final int correctAnsQtnTwo = R.id.q2_radio_btn4;
    final int correctAnsQtnThree = R.id.q3_radio_btn1;
    final int correctAnsQtnFour = R.id.q4_radio_btn3;
    final int correctAnsQtnFive = R.id.q5_radio_btn3;
    final int correctAnsQtnSix = R.id.q6_radio_btn1;
    final int correctAnsQtnSeven = R.id.q7_radio_btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * This methods checks if the answers to question 1-7 are correct 
     */
    private boolean checkQtnOne(){
        RadioGroup radiogrp1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        if (radiogrp1.getCheckedRadioButtonId() == correctAnsQtnOne){
            return true;
        }
        return false;
    }

    private boolean checkQtnTwo(){
        RadioGroup radiogrp2 = (RadioGroup) findViewById(R.id.radioGroupQ2);
        if (radiogrp2.getCheckedRadioButtonId() == correctAnsQtnTwo){
            return true;
        }
        return false;
    }
    /*private boolean checkQtnTwo(){
        ImageButton imgBtn1 = (ImageButton) findViewById(R.id.tyler_img_btn);
        if (imgBtn1.callOnClick() == (Integer) correctAnsQtnTwo.Int32){
            return true;
        }
        return false;

    }
     */
    private boolean checkQtnThree(){
        RadioGroup radiogrp3 = (RadioGroup) findViewById(R.id.radioGroupQ3);
        if (radiogrp3.getCheckedRadioButtonId() == correctAnsQtnThree){
            return true;
        }
        return false;
    }
    private boolean checkQtnFour(){
        RadioGroup radiogrp4 = (RadioGroup) findViewById(R.id.radioGroupQ4);
        if (radiogrp4.getCheckedRadioButtonId() == correctAnsQtnFour){
            return true;
        }
        return false;
    }
    private boolean checkQtnFive(){
        RadioGroup radiogrp5 = (RadioGroup) findViewById(R.id.radioGroupQ5);
        if (radiogrp5.getCheckedRadioButtonId() == correctAnsQtnFive){
            return true;
        }
        return false;
    }
    private boolean checkQtnSix(){
        RadioGroup radiogrp6 = (RadioGroup) findViewById(R.id.radioGroupQ6);
        if (radiogrp6.getCheckedRadioButtonId() == correctAnsQtnSix){
            return true;
        }
        return false;
    }
    private boolean checkQtnSeven(){
        RadioGroup radiogrp7 = (RadioGroup) findViewById(R.id.radioGroupQ7);
        if (radiogrp7.getCheckedRadioButtonId() == correctAnsQtnSeven){
            return true;
        }
        return false;
    }
    
    
    
    /**
     * This method is called when the startOver button is clicked.
     */
    public void startOver(View view) {

        //clear check of all button selections
        RadioGroup radiogrp1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        radiogrp1.clearCheck();

        RadioGroup radiogrp2 = (RadioGroup) findViewById(R.id.radioGroupQ2);
        radiogrp2.clearCheck();

        RadioGroup radiogrp3 = (RadioGroup) findViewById(R.id.radioGroupQ3);
        radiogrp3.clearCheck();

        RadioGroup radiogrp4 = (RadioGroup) findViewById(R.id.radioGroupQ4);
        radiogrp4.clearCheck();

        RadioGroup radiogrp5 = (RadioGroup) findViewById(R.id.radioGroupQ5);
        radiogrp5.clearCheck();

        RadioGroup radiogrp6 = (RadioGroup) findViewById(R.id.radioGroupQ6);
        radiogrp6.clearCheck();

        RadioGroup radiogrp7 = (RadioGroup) findViewById(R.id.radioGroupQ7);
        radiogrp7.clearCheck();

        //Scroll to top
        View view1 = (View) findViewById(R.id.quiz_list);
        view1.scrollTo(0, 0);

        //Hide view answers button
        Button viewAnsButton = (Button) findViewById(R.id.show_ans_button);
        viewAnsButton.setVisibility(View.INVISIBLE);


        //set score back to zero
        int numOfCorrectAns = 0;
        score = 0;
        totalScore = 0;


    }


    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAnswers(View view) {
        //Get user input from EditText field
        EditText nameEditText = (EditText) findViewById(R.id.name_text);
        String nameOfUser = nameEditText.getText().toString();

        // Figure out if the users answer to Q1 is correct
        RadioButton q1CorrectRadioButton = (RadioButton) findViewById(R.id.q1_radio_btn2);
        boolean gotQ1 = q1CorrectRadioButton.isChecked();

        // Figure out if the users answer to Q2 is correct
        RadioButton q2CorrectRadioButton = (RadioButton) findViewById(R.id.q5_radio_btn1);
        boolean gotQ2 =  q2CorrectRadioButton.isChecked();

        // Figure out if the users answer to Q3 is correct
        RadioButton q3CorrectRadioButton = (RadioButton) findViewById(R.id.q3_radio_btn3);
        boolean gotQ3 = q3CorrectRadioButton.isChecked();

        // Figure out if the users answer to Q4 is correct
        RadioButton q4CorrectRadioButton = (RadioButton) findViewById(R.id.q4_radio_btn3);
        boolean gotQ4 =  q4CorrectRadioButton.isChecked();

        // Figure out if the users answer to Q5 is correct
        RadioButton q5CorrectRadioButton = (RadioButton) findViewById(R.id.q5_radio_btn3);
        boolean gotQ5 = q5CorrectRadioButton.isChecked();

        // Figure out if the users answer to Q6 is correct
        RadioButton q6CorrectRadioButton = (RadioButton) findViewById(R.id.q6_radio_btn1);
        boolean gotQ6 =  q6CorrectRadioButton.isChecked();

        // Figure out if the users answer to Q7 is correct
        RadioButton q7CorrectRadioButton = (RadioButton) findViewById(R.id.q3_radio_btn4);
        boolean gotQ7 =  q7CorrectRadioButton.isChecked();


        int score = calculateScore();
        String message = createResult(nameOfUser, numOfCorrectAns);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

        Button viewAnsButton = (Button) findViewById(R.id.show_ans_button);
        viewAnsButton.setVisibility(View.VISIBLE);
    }

    /**
     * This method is calculates the current score of the user.
     */
    private int calculateScore() {
         numOfCorrectAns = 0;
        ArrayList<String> wrongAnswersList = new ArrayList<String>();

        if (checkQtnOne()){
            numOfCorrectAns ++;
        }
        if (checkQtnTwo()){
            numOfCorrectAns ++;
        }

        if (checkQtnThree()){
            numOfCorrectAns ++;
        }
        if (checkQtnFour()){
            numOfCorrectAns ++;
        }

        if (checkQtnFive()){
            numOfCorrectAns ++;
        }
        if (checkQtnSix()){
            numOfCorrectAns ++;
        }
        if (checkQtnSeven()){
            numOfCorrectAns ++;
        }

        return numOfCorrectAns;
    }

    private String createResult(String nameOfUser, int numOfCorrectAns) {
        String finalMessage = "Dear " + nameOfUser +

                "\nYou got " + numOfCorrectAns + " answers right out of 7" +
                "\nThank you!";
        return finalMessage;

    }

    /**
     *
     * This method shows all correct answers
     * **/
    public void viewAnswers(View view) {
        View view2 = (View) findViewById(R.id.quiz_list);
        view2.scrollTo(0,0);

        RadioGroup radiogrp1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        radiogrp1.check(correctAnsQtnOne);

        RadioGroup radiogrp2 = (RadioGroup) findViewById(R.id.radioGroupQ2);
        radiogrp2.check(correctAnsQtnTwo);

        RadioGroup radiogrp3 = (RadioGroup) findViewById(R.id.radioGroupQ3);
        radiogrp3.check(correctAnsQtnThree);

        RadioGroup radiogrp4 = (RadioGroup) findViewById(R.id.radioGroupQ4);
        radiogrp4.check(correctAnsQtnFour);

        RadioGroup radiogrp5 = (RadioGroup) findViewById(R.id.radioGroupQ5);
        radiogrp5.check(correctAnsQtnFive);

        RadioGroup radiogrp6 = (RadioGroup) findViewById(R.id.radioGroupQ6);
        radiogrp6.check(correctAnsQtnSix);

        RadioGroup radiogrp7 = (RadioGroup) findViewById(R.id.radioGroupQ7);
        radiogrp7.check(correctAnsQtnSeven);

    }
}
