package br.edu.ifsp.dados;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private SharedPreferences shared;

    private TextView textName;

    private TextView textAge;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button);
        textName = findViewById(R.id.textViewNameData);
        textAge =  findViewById(R.id.textViewAgeData);

        shared = getApplicationContext()
                .getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);

        textName.setText(shared.getString("name", ""));
        textAge.setText(shared.getString("age", ""));

        button.setOnClickListener(view -> {
            lauchMainActivity(view);
        });
    }

    public void lauchMainActivity(View view) {
        setResult(RESULT_OK, new Intent(this, MainActivity.class));
        finish();
    }
}
