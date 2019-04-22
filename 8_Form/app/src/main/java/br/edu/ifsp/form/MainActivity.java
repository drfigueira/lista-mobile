package br.edu.ifsp.form;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences shared;

    private EditText editName;

    private CheckBox checkStudent;

    private CheckBox checkWorker;

    private RadioButton radioButton;

    private RadioButton radioButton2;

    private SeekBar seekBar;

    private TextView textAge;

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shared = getApplicationContext()
                .getSharedPreferences("MySharedPreferences", Context.MODE_PRIVATE);

        editName = findViewById(R.id.editName);
        checkStudent = findViewById(R.id.checkBox);
        checkWorker = findViewById(R.id.checkBox2);
        radioButton = findViewById(R.id.radioButton);
        radioButton2 = findViewById(R.id.radioButton2);
        seekBar = findViewById(R.id.seekBarAge);
        textAge = findViewById(R.id.textViewAge);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textAge.setText("Idade = " + i);
                count = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void onClickBtn(View view) {
        switch (view.getId()) {
            case R.id.button:
                //verificar
                editName.setText(shared.getString("nome", ""));
                checkStudent.setChecked(shared.getBoolean("estudante", false));
                checkWorker.setChecked(shared.getBoolean("trabalhador", false));
                if(shared.getBoolean("sexo", false)) {
                    radioButton.setChecked(true);
                }else {
                    radioButton2.setChecked(true);
                }
                count = shared.getInt("idade", 0);
                seekBar.setProgress(count);
                textAge.setText("idade = " + count);
                break;
            case R.id.button2:
                //gravar
                shared.edit().
                        putString("nome", editName.getText().toString()).
                        putBoolean("estudante", checkStudent.isChecked()).
                        putBoolean("trabalhador", checkWorker.isChecked()).
                        putBoolean("sexo", radioButton.isChecked()).
                        putInt("idade", count).
                        apply();

                break;
        }
    }
}
