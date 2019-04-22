package br.edu.ifsp.frasesdodia;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final Integer[] DRAWABLES = {R.drawable.index1,
            R.drawable.index2,
            R.drawable.index3,
            R.drawable.index4,
            R.drawable.index5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onLoadImage();

    }

    private void onLoadImage() {
        ImageView image = findViewById(R.id.image);
        Glide.with(this).load(randomImage()).into(image);
    }

    private Integer randomImage() {
        Random generator = new Random();
        return DRAWABLES[generator.nextInt(DRAWABLES.length)];
    }

    public void randomMessage(View view) {
        onLoadImage();
    }
}
