package com.example.proyectobici;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText EtUsuario, EtPass;
    private Button btnLogear;

    AdminSQLiteOpenHelper helper = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EtUsuario = (EditText)findViewById(R.id.EtUsuario);
        EtPass = (EditText)findViewById(R.id.EtPass);
        btnLogear =(Button) findViewById(R.id.btnLogear);


        btnLogear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               EditText EtUsuario = (EditText)findViewById(R.id.EtUsuario);
                EditText EtPass = (EditText)findViewById(R.id.EtPass);

                try{
                    Cursor cursor = helper.Validar(EtUsuario.getText().toString(),EtPass.getText().toString());

                    if (cursor.getCount()>0){
                        Intent i = new Intent(getApplicationContext(), Home_act.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(getApplicationContext(), "usuario o contraseña incorrectos", Toast.LENGTH_LONG).show();
                    }
                    EtUsuario.setText("");
                    EtPass.setText("");
                    EtUsuario.findFocus();

                }catch (SQLException e){
                    e.printStackTrace();
                }


            }
        });
    }



    public void Registrarce(View v){
        Intent i = new Intent(this, Registrarce_act.class);
        startActivity(i);
    }
}
