package com.example.administrator.myexam2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {
    private Button Lottery;
    private TextView result;
    private String[] lotterys;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lottery = (Button)findViewById(R.id.Lottery);
        result = (TextView)findViewById(R.id.result);

        Lottery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLottery();
            }
        });
    }

    private void showLottery(){
        lotterys = new String[10];
        for (int i=0; i<lotterys.length; i++){
            lotterys[i] = createALottery();
        }

        AlertDialog alert = null;
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);
        builder.setItems(lotterys, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                result.setText(lotterys[i]);
            }
        });
        alert = builder.create();
        alert.show();

    }

    private String createALottery(){
        TreeSet<Integer> set = new TreeSet<>();
        while (set.size()<6){
            set.add((int)(Math.random()*49+1));
        }
        StringBuffer sb = new StringBuffer();
        for (Integer num : set){
            sb.append(num + "  ");
        }
        return sb.toString();
    }


}