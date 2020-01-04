package com.example.proyectobici;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home_act extends AppCompatActivity {
    private ViewFlipper vf;
    private int[] images = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_act);

        vf = (ViewFlipper)findViewById(R.id.slider);

        // se iteran las instrucciones del slider
        for(int i = 0; i<images.length; i++)
        {
            Instrucciones(images [i]);
        }

    }
    public void Instrucciones(int i)
    {
        ImageView view = new ImageView(this);
        view.setBackgroundResource(i);

        vf.addView(view); //  añadimos la vista
        vf.setFlipInterval(2800); // intervalo de imagenes
        vf.setAutoStart(true); // el slider inicia de forma automatica

        // Sentido al slider
        vf.setInAnimation(this, android.R.anim.slide_in_left);
        vf.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void Acciones(View v){
        Intent i=  new Intent(this, Action_act.class);
        startActivity(i);
    }
}
