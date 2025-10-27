package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("Status: ", "SecondActivity:onCeate");

        Button btn=findViewById(R.id.button2);
        Button button=findViewById(R.id.button3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent( SecondActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SecondActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Status: ", "SecondActivity:onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Status: ", "SecondActivity:onResum");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Status: ", "SecondActivity:onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Status: ", "SecondActivity:onStop");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Status: ", "SecondActivity:onReastart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Status: ", "SecondActivity:onDestroy");
    }
}