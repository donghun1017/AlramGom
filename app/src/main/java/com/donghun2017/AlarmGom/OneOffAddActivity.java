package com.donghun2017.AlarmGom;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OneOffAddActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btnReset, btnMode;
    String timeText;
    int min = 0;

    TextView setTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_off_add);

        Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int)(display.getWidth()*0.8);
        int height = (int)(display.getHeight()*0.6);
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;

        btn1 = (Button)findViewById(R.id.btn1min);
        btn2 = (Button)findViewById(R.id.btn5min);
        btn3 = (Button)findViewById(R.id.btn10min);
        btn4 = (Button)findViewById(R.id.btn15min);
        btn5 = (Button)findViewById(R.id.btn30min);
        btn6 = (Button)findViewById(R.id.btn60min);
        btnReset = (Button)findViewById(R.id.btnReset);
        btnMode = (Button)findViewById(R.id.btnMode);
        setTime = (TextView)findViewById(R.id.setTime);

        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btnMode.setOnClickListener(listener);
        btnReset.setOnClickListener(listener);

    }

    public void clickOneOffCheck(View v){
        Intent intent = getIntent();
        intent.putExtra("Min", min);
        setResult(RESULT_OK, intent);
        finish();
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()){
                case R.id.btn1min:
                    min += 1;
                    timeText = String.format("%d"+"분뒤" ,min);
                    setTime.setText(timeText);
                    break;
                case R.id.btn5min:
                    min += 5;
                    timeText = String.format("%d"+"분뒤" ,min);
                    setTime.setText(timeText);
                    break;
                case R.id.btn10min:
                    min += 10;
                    timeText = String.format("%d"+"분뒤" ,min);
                    setTime.setText(timeText);
                    break;
                case R.id.btn15min:
                    min += 15;
                    timeText = String.format("%d"+"분뒤" ,min);
                    setTime.setText(timeText);
                    break;
                case R.id.btn30min:
                    min += 30;
                    timeText = String.format("%d"+"분뒤" ,min);
                    setTime.setText(timeText);
                    break;
                case R.id.btn60min:
                    min += 60;
                    timeText = String.format("%d"+"분뒤" ,min);
                    setTime.setText(timeText);
                    break;
                case R.id.btnMode:
                    if(btnMode.getText().equals("진동모드")){
                        btnMode.setText("무음모드");
                    }else if(btnMode.getText().equals("무음모드")){
                        btnMode.setText("소리모드");
                    }else{
                        btnMode.setText("진동모드");
                    }
                    break;
                case R.id.btnReset:
                    min =0;
                    timeText = String.format("%d"+"분뒤" ,min);
                    setTime.setText(timeText);
                    break;
            }
        }
    };

}
