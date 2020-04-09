package org.kasapbasi.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button[] btnGrp= new Button[4];
    Button btn;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    GridLayout grd;
    TextView tvTime;
    TextView tvQ;
    TextView tvCounter;
    TextView tvResult;
    public void start(View v){
        grd.setVisibility(View.VISIBLE);
        tvQ.setVisibility(View.VISIBLE);
        btn.setVisibility(View.INVISIBLE);
        //İlk önce grup elemanlarını göster
        // sayaç başlat
        CountDownTimer ctd= new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
               tvTime.setText(millisUntilFinished/1000+"s");

            }

            @Override
            public void onFinish() {
                reset();
            }
        };
        ctd.start();
        // Hesaplama için rastgele sayı üret
        calculation();

    }
    int result;
private void calculation(){
    Sorusayac++;
        int rnd1;
        int rnd2;

        int decoy;
        Random rnd= new Random();

        rnd1=rnd.nextInt(20)+1;
        rnd2=rnd.nextInt(20)+1;
        result=rnd1+rnd2;
        tvQ.setText(rnd1+" + " +rnd2);
        int pos= rnd.nextInt(4);

        for(int i=0;i<4;i++){

            if(i==pos)
                btnGrp[i].setText(""+result);
            else
            {
                decoy=rnd.nextInt(40)+1;
                while(decoy==result){
                    decoy=rnd.nextInt(40)+1;
                }
                btnGrp[i].setText(""+decoy);
            }

        }

}

    private void reset(){
        grd.setVisibility(View.INVISIBLE);
        tvQ.setVisibility(View.INVISIBLE);
        btn.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btnGo);


        grd=(GridLayout) findViewById(R.id.grpButton);
        tvTime=(TextView) findViewById(R.id.tvTime);
        tvQ=(TextView) findViewById(R.id.tvQuestion);
        tvCounter=(TextView) findViewById(R.id.tvCounter) ;
        tvResult=(TextView) findViewById(R.id.tvResult);
        reset();
        btn1 = (Button) findViewById(R.id.btnOption1);
        btn2 = (Button) findViewById(R.id.btnOption2);
        btn3 = (Button) findViewById(R.id.btnOption3);
        btn4 = (Button) findViewById(R.id.btnOption4);

        btnGrp[0]=btn1;
        btnGrp[1]=btn2;
        btnGrp[2]=btn3;
        btnGrp[3]=btn4;
    }
int Sorusayac=0;
int Dogrusayac=0;
    public void tiklandi(View v){
      Button btn=(Button)v;
      int tik=Integer.parseInt(btn.getText().toString());

      if(result==tik){
          Dogrusayac++;
          tvResult.setText("Correct!");
      }else
          tvResult.setText("Wrong!");
tvCounter.setText(Dogrusayac+" / "+Sorusayac);
      calculation();
    }
}
