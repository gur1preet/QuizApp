package com.example.android.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;

public class MainActivity extends AppCompatActivity {

    int answer_1 = 132;
    int answer_2 = R.id.q2_d;
    int answer_4 = R.id.q4_b;
    int answer_5 = 24;
    String answer_6 = "leaf";
    int answer_7 = R.id.q7_d;
    int answer_8 = R.id.q8_a;
    int correctAnswers = 0;
    int incorrectAnswers = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Welcome!!", Toast.LENGTH_SHORT).show();
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.welcome);
        mediaPlayer.start();
    }


    public void checkAnswer(View view){
        String text = "Result:\n";
        if ( question1() ){
            correctAnswers++;
        } else{
            incorrectAnswers++;
        }
        if( question2() ){
            correctAnswers++;
        } else {
            incorrectAnswers++;
        }
        if( question3() ){
            correctAnswers++;
        } else{
            incorrectAnswers++;
        }
        if( question4() ){
            correctAnswers++;
        } else{
            incorrectAnswers++;
        }
        if( question5() ){
            correctAnswers++;
        } else{
            incorrectAnswers++;
        }
        if( question6() ){
            correctAnswers++;
        } else{
            incorrectAnswers++;
        }
        if(question7()){
            correctAnswers++;
        }else {
            incorrectAnswers++;
        }
        if(question8()){
            correctAnswers++;
        }else {
            incorrectAnswers++;
        }


        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.done);
        mediaPlayer.start();


        Toast.makeText(this, "Correct: "+correctAnswers+" Incorrect Answers: "+incorrectAnswers, Toast.LENGTH_LONG).show();

        EditText name = (EditText) findViewById(R.id.name_edit_text);
        String nameString = "Name: " + name.getText().toString();
        text += nameString;
        display(text);

        correctAnswers = 0;
        incorrectAnswers = 0;
    }

    public String display(String text){
        EditText age = (EditText) findViewById(R.id.age_edit_text);
        text +="\nAge: " + age.getText().toString();
        text +="\nCorrect: " + correctAnswers;
        text +="\nIncorrect: " + incorrectAnswers;
        TextView t1 = (TextView) findViewById(R.id.result);
        t1.setText(text);
        return text;
    }


    private boolean question1(){
        EditText text = (EditText) findViewById(R.id.ans_1_et);
        String num1 = text.getText().toString();
        int num2 = Integer.parseInt(num1);
        if( num2 == answer_1){
            return true;
        }
        return false;
    }

    private boolean question2(){
        RadioGroup r1 = (RadioGroup) findViewById(R.id.ans_2);
        if( r1.getCheckedRadioButtonId()== answer_2 ){
            return true;
        }
        return false;

    }

    private boolean question3(){
        CheckBox a = (CheckBox) findViewById(R.id.q3_a);
        CheckBox b = (CheckBox) findViewById(R.id.q3_b);
        CheckBox c = (CheckBox) findViewById(R.id.q3_c);
        CheckBox d = (CheckBox) findViewById(R.id.q3_d);

        if(a.isChecked() && b.isChecked() && !c.isChecked() && d.isChecked()){
            return true;
        }
        return false;

    }

    private boolean question4(){
        RadioGroup r1 = (RadioGroup) findViewById(R.id.ans_4);
        if( r1.getCheckedRadioButtonId()== answer_4 ){
            return true;
        }
        return false;

    }

    private boolean question5(){
        EditText text = (EditText) findViewById(R.id.ans_5_et);
        String num1 = text.getText().toString();
        int num2 = Integer.parseInt(num1);
        if( num2 == answer_5){
            return true;
        }
        return false;
    }

    private boolean question6(){
        EditText text = (EditText) findViewById(R.id.ans_6_et);
        return text.getText().toString().equalsIgnoreCase(answer_6);
    }

    private boolean question7(){
        RadioGroup r1 = (RadioGroup) findViewById(R.id.ans_7);
        if( r1.getCheckedRadioButtonId()== answer_7 ){
            return true;
        }
        return false;
    }

    private boolean question8(){
        RadioGroup r1 = (RadioGroup) findViewById(R.id.ans_8);
        if( r1.getCheckedRadioButtonId()== answer_8 ){
            return true;
        }
        return false;
        }
}
