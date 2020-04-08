package org.kasapbasi.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.gridlayout.widget.GridLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button btn;
Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    GridLayout grd;
    TextView tvTimer;
    TextView tvScore;
    TextView tvQuestion;
    TextView tvResult;

    int random1;
    int random2;
    int randomOP;
    int result;
    int level;

    public void start(View v){
        btn.setVisibility(View.INVISIBLE);
        grd.setVisibility(View.VISIBLE);
        tvQuestion.setVisibility(View.VISIBLE);
        myNewCalculation();
    }

    public void myNewCalculation(){

        // new random values are calculated
        // new opertion is given
        // result is updated at the textview

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
        place();
   tvQuestion.setText(calculation);
    }
public void place(){


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

    }
}
