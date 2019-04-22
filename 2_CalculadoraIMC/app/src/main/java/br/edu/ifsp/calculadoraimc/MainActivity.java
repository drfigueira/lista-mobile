package br.edu.ifsp.calculadoraimc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static br.edu.ifsp.calculadoraimc.BodyService.calculateIMC;
import static br.edu.ifsp.calculadoraimc.BodyService.info;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_MESSAGE = "message";

    private static final String STATE_IMC = "imc";

    private final ViewHolder viewHolder = new ViewHolder();

    private static class ViewHolder {
        private EditText editWeight;
        private EditText editHeight;
        private TextView textIMC;
        private TextView textView;
        private Button buttonCalculator;
        private Button buttonX;
    }

    private void onLoadViewHolder() {
        viewHolder.editWeight = findViewById(R.id.editWeight);
        viewHolder.editHeight = findViewById(R.id.editWeight);
        viewHolder.textIMC = findViewById(R.id.textIMC);
        viewHolder.textView = findViewById(R.id.textView);
        viewHolder.buttonCalculator = findViewById(R.id.buttonCalculator);
        viewHolder.buttonX = findViewById(R.id.buttonX);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onLoadViewHolder();

        if(savedInstanceState !=  null) {
            viewHolder.textIMC.setText(savedInstanceState.getString(STATE_IMC, ""));
            viewHolder.textView.setText(savedInstanceState.getString(STATE_MESSAGE, String.valueOf(R.string.text_view)));
        }

        ImageView imageView = findViewById(R.id.imageIMC);
        Glide.with(this).load(R.drawable.imc).into(imageView);

        viewHolder.buttonCalculator.setOnClickListener(view -> {
            Double weight = Double.parseDouble(viewHolder.editWeight.getText().toString());
            Double height = Double.parseDouble(viewHolder.editHeight.getText().toString());
            Body body = new Body(weight, height);

            Double imc = calculateIMC(body);

            viewHolder.textIMC.setText(String.format("%.2f", imc));
            viewHolder.textView.setText(getResources().getText(R.string.text_view) + " " + info(imc));
        });

        viewHolder.buttonX.setOnClickListener(view -> {
            clean(viewHolder);
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString(STATE_IMC, viewHolder.textIMC.getText().toString());
        bundle.putString(STATE_MESSAGE, viewHolder.textView.getText().toString());
        super.onSaveInstanceState(bundle);
    }

    static void clean(ViewHolder viewHolder) {
        viewHolder.editWeight.setText("");
        viewHolder.editHeight.setText("");
        viewHolder.textIMC.setText("");
        viewHolder.textView.setText(R.string.text_view);
    }
}
