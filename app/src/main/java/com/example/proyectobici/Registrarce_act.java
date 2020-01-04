package com.example.proyectobici;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrarce_act extends AppCompatActivity {

    private EditText EtUsuario, EtContraseña, EtNombre;
    private TextView TvMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarce_act);

        EtUsuario = findViewById(R.id.EtUsuario);
        EtContraseña = findViewById(R.id.EtContraseña);
        EtNombre = findViewById(R.id.EtNombre);
        TvMostrar = findViewById(R.id.TvMostrar);

    }

    public void añadirUsuario(View v)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "usuarios", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        if(!EtUsuario.getText().toString().isEmpty())
        {
            ContentValues registro = new ContentValues();
            registro.put("Usuario", EtUsuario.getText().toString());
            registro.put("Contraseña", EtContraseña.getText().toString());
            registro.put("Nombre", EtNombre.getText().toString());

            BaseDeDatos.insert("usuarios", null, registro);
            BaseDeDatos.close();

            Toast.makeText(this, "Se ha ingresado un usuario", Toast.LENGTH_LONG).show();

            String mostrar = EtUsuario.getText().toString();
            TvMostrar.setText("Se agregó el usuario con email: "+mostrar);
        }
    }

    public void Inicio(View v){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
