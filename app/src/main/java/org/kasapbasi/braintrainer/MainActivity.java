package org.kasapbasi.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btn;

Button[] btnGrp= new Button[4];
Button btn1;


    Button btn2;
    Button btn3;
    Button btn4;
    GridLayout grd;
    TextView tvTimer;
    TextView tvScore;
    TextView tvQuestion;
    TextView tvResult;

    CountDownTimer cdt;
    int random1;
    int random2;
    int randomOP;
    int result;
    int level;
    int numberOfCorrects=0;
    int numberOfQuestions=0;

    public void start(View v){
        btn.setVisibility(View.INVISIBLE);
        grd.setVisibility(View.VISIBLE);
        tvQuestion.setVisibility(View.VISIBLE);
        cdt =  new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(((int)millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                btn.setVisibility(View.VISIBLE);
                grd.setVisibility(View.INVISIBLE);
                tvQuestion.setVisibility(View.INVISIBLE);
                tvResult.setText("");
                numberOfCorrects=0;
                numberOfQuestions=0;
            }
        };
cdt.start();
        myNewCalculation();
    }

    public void myNewCalculation(){

                tvScore.setText(numberOfCorrects+" / "+numberOfQuestions);
        numberOfQuestions++;
        // new random values are calculated
        // new opertion is given
        // result is updated at the textview
        // reset Timer


        Random rnd= new Random();
        random1= rnd.nextInt(20) +1;
        random2=rnd.nextInt(20)+1;
        randomOP=rnd.nextInt(1)+1; //sadece toplama
        String calculation="";
        switch (randomOP){
            case 1: calculation+=random1 +" + " +random2; result=random1+random2; break;
            case 2: calculation+=random1 +" - " +random2; result=random1-random2;break;
            case 3: calculation+=random1 +" * " +random2; result=random1*random2;break;
            case 4: calculation+=random1 +" / " +random2; result=random1/random2;break;
        }
        place(rnd);
   tvQuestion.setText(calculation);
    }
public void place(Random rnd){

        int CorrectAnswerLocation=rnd.nextInt(4);
        for(int i=0;i<4;i++){
            if(CorrectAnswerLocation==i)
                btnGrp[CorrectAnswerLocation].setText(""+result);
            else {
                int RandomResult = rnd.nextInt(40);
                while (RandomResult == result) {
                    RandomResult = rnd.nextInt(40);
                }
                btnGrp[i].setText(""+RandomResult);
            }

        }


}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btnGo);
        grd=(GridLayout) findViewById(R.id.grpButton);
        grd.setVisibility(View.INVISIBLE);
        btn1 = (Button) findViewById(R.id.btnOption1);
        btn2 = (Button) findViewById(R.id.btnOption2);
        btn3 = (Button) findViewById(R.id.btnOption3);
        btn4 = (Button) findViewById(R.id.btnOption4);
        btnGrp[0]=btn1;
        btnGrp[1]=btn2;
        btnGrp[2]=btn3;
        btnGrp[3]=btn4;

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


        tvQuestion=(TextView)findViewById(R.id.tvQuestion);
        tvQuestion.setVisibility(View.INVISIBLE);
        tvTimer=(TextView)findViewById(R.id.tvTime);
        tvScore =(TextView) findViewById(R.id.tvCounter);
        tvResult =(TextView) findViewById(R.id.tvResult);


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Button btn=(Button)v;
        if(Integer.parseInt(btn.getText().toString())==result) {
            numberOfCorrects++;
            tvResult.setTextColor(Color.GREEN);
            tvResult.setText("Correct!");
        }
        else {
            tvResult.setTextColor(Color.RED);
            tvResult.setText("Wrong!");
        }
                myNewCalculation();
    }
}
