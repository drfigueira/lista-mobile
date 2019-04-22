package br.edu.ifsp.note;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences shared;

    private String note;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);


    }

    public void onClickBtn(View view) {
        shared = getApplicationContext()
                .getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);
        switch (view.getId()) {
            case R.id.buttonSave:
                note = editText.getText().toString();
                shared.edit().putString("note", note).apply();
                editText.setText("");
                break;
            case R.id.buttonRecover:
                note = shared.getString("note", "");
                editText.setText(note);
                break;
        }
    }
}
