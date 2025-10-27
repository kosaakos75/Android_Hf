package com.example.hf1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText num1;

    Button plusButton;
    Button minusButton;
    Button multButton;
    Button divButton;
    EditText num2;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        num1=findViewById(R.id.num1);
        plusButton=findViewById(R.id.plusButton);
        minusButton=findViewById(R.id.minusButton);
        multButton=findViewById(R.id.multButton);
        divButton=findViewById(R.id.divButton);
        num2=findViewById(R.id.num2);
        result=findViewById(R.id.result);

        Calculator();

    }

    public void Calculator(){
        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number1=Double.parseDouble(num1.getText().toString());
                double number2=Double.parseDouble(num2.getText().toString());
                double sum=number1+number2;
                result.setText(String.valueOf(sum));
            }
        });
        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number1=Double.parseDouble(num1.getText().toString());
                double number2=Double.parseDouble(num2.getText().toString());
                double difference=number1-number2;
                result.setText(String.valueOf(difference));
            }
        });
        multButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number1=Double.parseDouble(num1.getText().toString());
                double number2=Double.parseDouble(num2.getText().toString());
                double multiplicated=number1*number2;
                result.setText(String.valueOf(multiplicated));
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double number1=Double.parseDouble(num1.getText().toString());
                double number2=Double.parseDouble(num2.getText().toString());
                if (number2==0){
                    Toast.makeText(MainActivity.this,"Cannot divide by zero",Toast.LENGTH_SHORT).show();
                    result.setText("Error");
                }else {
                    double divided=number1/number2;
                    result.setText(String.valueOf(divided));
                }
            }
        });
    }
}