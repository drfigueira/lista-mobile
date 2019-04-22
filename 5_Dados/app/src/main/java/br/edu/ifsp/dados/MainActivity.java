package br.edu.ifsp.dados;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences shared;

    private static int TEXT_REQUEST = 1;

    private EditText editTextName;

    private EditText editTextAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared = getApplicationContext()
                .getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);

    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.buttonInput:
                shared.edit()
                        .putString("name", editTextName.getText().toString())
                        .putString("age", editTextAge.getText().toString()).apply();
                break;
            case R.id.buttonOutput:
                startActivityForResult(new Intent(this, Main2Activity.class), TEXT_REQUEST);
                break;
        }
    }
}
