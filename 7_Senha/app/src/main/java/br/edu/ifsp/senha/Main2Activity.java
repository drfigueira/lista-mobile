package br.edu.ifsp.senha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private SharedPreferences shared;

    private TextView textView;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        shared = getApplicationContext()
                .getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);

        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        textView.setText("Seja bem-vindo " + shared.getString("login", ""));

        button.setOnClickListener(view -> {
            setResult(RESULT_OK, new Intent(this, MainActivity.class));
            finish();
        });

    }
}
