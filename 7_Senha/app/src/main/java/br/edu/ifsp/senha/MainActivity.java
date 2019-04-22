package br.edu.ifsp.senha;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int TEXT_REQUEST = 1;

    private SharedPreferences shared;

    private EditText editUser;

    private EditText editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared = getApplicationContext()
                .getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);

        editUser = findViewById(R.id.editUser);
        editPassword = findViewById(R.id.editPassword);

    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                String senha = editPassword.getText().toString();

                if(!senha.isEmpty() && senha.equals(shared.getString(editUser.getText().toString(), ""))) {
                    shared.edit().putString("login", editUser.getText().toString()).apply();
                    startActivityForResult(new Intent(this, Main2Activity.class), TEXT_REQUEST);
                }
                break;
            case R.id.buttonInsert:
                shared.edit().putString(
                        editUser.getText().toString(),
                        editPassword.getText().toString()).apply();
                editUser.setText("");
                editPassword.setText("");
                break;
        }
    }
}
