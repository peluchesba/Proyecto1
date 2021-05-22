package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


    }


    public void InicioSesion(View view) {
        Intent inicio = new Intent(this, NotasApp.class);
        Toast.makeText(this, "Te estas registrando", Toast.LENGTH_SHORT).show();
        startActivity(inicio);
    }



    public void Registrar(View view) {
        Intent registrar = new Intent(this, Resgristro.class);
        Toast.makeText(this, "Te estas registrando", Toast.LENGTH_SHORT).show();
        startActivity(registrar);
    }
}