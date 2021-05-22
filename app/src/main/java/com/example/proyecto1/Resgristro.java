package com.example.proyecto1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Resgristro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resgristro);
    }

    public void InicioSesion(View view) {
        Intent inicio = new Intent(this, NotasApp.class);
        Toast.makeText(this, "Te has registrado con exito", Toast.LENGTH_SHORT).show();
        startActivity(inicio);
    }



}