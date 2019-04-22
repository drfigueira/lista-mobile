package br.edu.ifsp.conversormoedas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_DOLLAR = "dollar";

    private static final String STATE_EURO = "euro";

    private final ViewHolder viewHolder = new ViewHolder();

    private static class ViewHolder {
        private TextView textValueDollar;
        private TextView textValueEuro;
        private EditText editValue;
    }

    private void onLoadViewHolder() {
        viewHolder.textValueDollar = findViewById(R.id.textValueDollar);
        viewHolder.textValueEuro = findViewById(R.id.textValueEuro);
        viewHolder.editValue = findViewById(R.id.editValue);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onLoadViewHolder();

        if(savedInstanceState != null) {
            viewHolder.textValueDollar.setText(savedInstanceState.getString(STATE_DOLLAR, String.valueOf(R.string.zero)));
            viewHolder.textValueEuro.setText(savedInstanceState.getString(STATE_EURO, String.valueOf(R.string.zero)));
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString(STATE_DOLLAR, viewHolder.textValueDollar.getText().toString());
        bundle.putString(STATE_EURO, viewHolder.textValueEuro.getText().toString());
        super.onSaveInstanceState(bundle);
    }

    public void calculate(View view) {
        Double value = Double.parseDouble(viewHolder.editValue.getText().toString());
        viewHolder.textValueDollar.setText(String.valueOf(value * 3.0));
        viewHolder.textValueEuro.setText(String.valueOf(value * 4.0));
    }


}
