package br.edu.ifsp.conversormoedas;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ViewHolder {

    final TextView textReal;

    final TextView textDollar;

    final TextView textValueDollar;

    final TextView textEuro;

    final TextView textValueEuro;

    final EditText editValue;

    final Button calculate;

    public ViewHolder(MainActivity view) {
        textReal = view.findViewById(R.id.textReal);
        textDollar = view.findViewById(R.id.textDollar);
        textValueDollar = view.findViewById(R.id.textValueDollar);
        textEuro = view.findViewById(R.id.textEuro);
        textValueEuro = view.findViewById(R.id.textValueEuro);
        editValue = view.findViewById(R.id.editValue);
        calculate = view.findViewById(R.id.button);
    }
}
