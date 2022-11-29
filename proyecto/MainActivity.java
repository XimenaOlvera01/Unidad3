package com.example.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText cveA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cveA= findViewById(R.id.cveadm);
    }

    public void cupon(View view){
        Intent v = new Intent(this,cupon.class);
        startActivity(v);
    }
    public void validar(View view){
        String cvei, CA;
        cvei = cveA.getText().toString();
        CA = "19590345";

        if (cvei.equals(CA)) {
            Intent v = new Intent(this, validar_cupon.class);
            startActivity(v);
            Toast.makeText(this, "Bienvenido Administrador", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Clave no valida", Toast.LENGTH_LONG).show();
        }

    }
    public void sucursales(View view){
            Intent v = new Intent(this, sacursales.class);
            startActivity(v);
    }

}