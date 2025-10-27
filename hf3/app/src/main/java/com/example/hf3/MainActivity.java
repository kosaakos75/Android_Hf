package com.example.hf3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView cim, pc,pn,pp, tvProductList;
    private EditText code, name, price;
    private Button addButton, cancelButton, showProductButton;

    private List<Product> productList=new ArrayList<>();

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

        cim=findViewById(R.id.cim);
        pc=findViewById(R.id.pc);
        pn=findViewById(R.id.pn);
        pp=findViewById(R.id.pp);

        code=findViewById(R.id.code);
        name=findViewById(R.id.name);
        price=findViewById(R.id.price);

        addButton=findViewById(R.id.addButton);
        cancelButton=findViewById(R.id.cancelButton);
        showProductButton=findViewById(R.id.showProductButton);

        tvProductList=findViewById(R.id.tvProductList);

        setupClickListener();
    }
    private void setupClickListener(){
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etcode=code.getText().toString();
                String etname=name.getText().toString();
                String etprice=price.getText().toString();

                try{
                    double priceValue=Double.parseDouble(etprice);

                    Product newProduct=new Product(etcode, priceValue, etname);

                    productList.add(newProduct);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code.getText().clear();
                name.getText().clear();
                price.getText().clear();
            }
        });

        showProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder productListText=new StringBuilder();
                for (Product product:productList){
                    productListText.append(product.toString()).append("\n");
                }
                tvProductList.setText(productListText.toString());
            }
        });
    }
}