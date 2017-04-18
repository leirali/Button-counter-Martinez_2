package com.tumblr.leirali.button_counter_martinez;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button increase;
    private Button decrease;
    private Button clear;
    private TextView window;
    private Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;
        increase = (Button)findViewById(R.id.add_button);
        decrease = (Button)findViewById(R.id.sub_button);
        clear = (Button)findViewById(R.id.clear_button);
        window = (TextView)findViewById(R.id.countTextView);
        window.setText(count.toString());
        System.out.println(window.getTextSize());


        increase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                add();
                window.setText(count.toString());
            }
        });

        decrease.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                remove();
                window.setText(count.toString());
            }
        });

        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                clearCount();
                window.setText(count.toString());
            }
        });


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("countSave",count);
        outState.putFloat("countSize", window.getTextSize());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        count = savedInstanceState.getInt("countSave");
        window.setText(count.toString());
    }

    public void add(){

        count = count + 1;
    }

    public void remove(){
        count = count - 1;

    }

    public void clearCount(){
        count = 0;
    }
}