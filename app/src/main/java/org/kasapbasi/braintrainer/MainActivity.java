package org.kasapbasi.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn;
Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    public void start(View v){
        btn.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.btnGo);
        btn.setVisibility(View.INVISIBLE);

        btn1 = (Button) findViewById(R.id.btnOption1);
        btn2 = (Button) findViewById(R.id.btnOption1);
        btn3 = (Button) findViewById(R.id.btnOption1);
        btn4 = (Button) findViewById(R.id.btnOption1);
    }
}
