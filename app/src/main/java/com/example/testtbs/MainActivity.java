package com.example.testtbs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @Author:         liusheng
 * @CreateDate:     2021/1/1 0001 13:41
 * @Description:    启动界面
 * @Version:        1.0
 **/

public class MainActivity extends AppCompatActivity {

    private Button mianbeginbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mianbeginbtn=findViewById(R.id.mianbeginbtn);
        mianbeginbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DisplayActivity.class));
            }

        } );
    }






}