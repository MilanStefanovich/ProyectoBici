package com.example.proyectobici;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {
        BaseDeDatos.execSQL("CREATE TABLE usuarios(usuario VARCHAR(50) PRIMARY KEY, contraseña VARCHAR(50), nombre VARCHAR(50) )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor Validar(String usuario, String contraseña) throws SQLException {
        Cursor miCursor=null;

        miCursor=this.getReadableDatabase().query("usuarios", new String[]{"usuario", "contraseña"},
                "usuario like  '"+usuario+"' "+"and contraseña like '"+contraseña+"'",
                null, null, null, null);
        return miCursor;
    }
}
