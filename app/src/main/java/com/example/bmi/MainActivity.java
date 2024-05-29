package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//
//            return insets;
//        });
        EditText edt_weight = findViewById(R.id.edt_weight), edt_height = findViewById(R.id.edt_height), edt_heightIn = findViewById(R.id.edt_heightIn);
        Button btn_calc = findViewById(R.id.btn_calc);
        TextView txt_result = findViewById(R.id.txt_result);
        LinearLayout llmain = findViewById(R.id.llmain);
        btn_calc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                int wt = Integer.parseInt(edt_weight.getText().toString());
                int ft = Integer.parseInt(edt_height.getText().toString());
                int In = Integer.parseInt(edt_heightIn.getText().toString());
                 int totalIn = ft * 12 + In;
                 double totalCm = totalIn * 2.54;
                 double totalM = totalCm / 100;
                 double BMI = wt / (totalM * totalM);
                 if(BMI >24.9){
                     txt_result.setText(" you'r overweight");
                     llmain.setBackgroundColor(getColor(R.color.colorO));
                 }
                 else if(BMI >= 18.5 && BMI <= 24.9){
                     txt_result.setText("Normal");
                     llmain.setBackgroundColor(getColor(R.color.colorH));
                 }
                else{
                     txt_result.setText("you'r underweight");
                     llmain.setBackgroundColor(getColor(R.color.colorU));
                 }
        }});

}}