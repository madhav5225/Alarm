package com.example.alarm;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
     int m=0,s=30,stop=0;
    CountDownTimer timer;
//public void update()

        public void start (View view) {
            SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar);
            Button button = (Button) findViewById(R.id.button);




            if (stop == 0) {
                timer = new CountDownTimer((((m*60)+s)*1000)+100, 1000) {
                    public void onTick(long k) {
                        //Log.i("sds", "" + k);
                        SeekBar seekBar3 = (SeekBar) findViewById(R.id.seekBar);
                        TextView textView1 = (TextView) findViewById(R.id.textView2);
                        int rm, rs;
                        rm = (int) ((k) / 60000);
                        rs = (int) ((k / 1000) % 60);
                        seekBar3.setProgress((rm*10)+(rs/6));
                        if (rs < 10) textView1.setText("" + rm + ":0" + rs);
                        else
                            textView1.setText("" + rm + ":" + rs);
                    }

                    public void onFinish() {
                        TextView textView2 = (TextView) findViewById(R.id.textView2);
                        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar);
                        Button button1 = (Button) findViewById(R.id.button);
                        seekBar2.setEnabled(true);
                        seekBar2.setProgress(0);
                        String l = new String("START");
                        stop = 0;
                        button1.setText("" + l);
    //                    if(s==0)
                            textView2.setText("0:00");
  //                      else
//                            textView2.setText(""+m+":"+s);

                    }
                };
                timer.start();
                String s = new String("STOP");
                button.setText("" + s);
                stop = 1;
                seekBar1.setEnabled(false);
            } else {
                String s = new String("START");

                              timer.cancel();
                      stop = 0;
                button.setText("" + s);
                seekBar1.setEnabled(true);
            }
        }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);

        final TextView textView =(TextView)findViewById(R.id.textView2);

        //seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                m=i/10;
                s=(i%10)*6;
               if(s<10)
                   textView.setText(""+m+":0"+s);
                   else
                textView.setText(""+m+":"+s);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}