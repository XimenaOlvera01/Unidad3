package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class validar_cupon extends AppCompatActivity {

    Button btnScan;
    EditText txtResultado;
    EditText cveQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validar_cupon);

        btnScan = findViewById(R.id.btnvalidar);
        txtResultado = findViewById(R.id.visualizar);
        cveQR = findViewById(R.id.cve);

        btnScan.setOnClickListener(view -> {
            IntentIntegrator integrador = new IntentIntegrator(validar_cupon.this);
            integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
            integrador.setPrompt("Lector - CDP");
            integrador.setCameraId(0);
            integrador.setBeepEnabled(true);
            integrador.setBarcodeImageEnabled(true);
            integrador.initiateScan();
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null){
            if (result.getContents() == null){
                Toast.makeText(this, "No existe", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, result.getContents(), Toast.LENGTH_LONG).show();
                txtResultado.setText(result.getContents());
            }
        }else{
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void baja(View view){
        String c;
        c = txtResultado.getText().toString();
        try {
            DatabaseReference drPro = FirebaseDatabase.getInstance().getReference("QRN").child(c);
            drPro.removeValue();
            Toast.makeText(this, "QR Canjeado, tu cupon de -10% de descuento", Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this, "El codigo QR no existe", Toast.LENGTH_SHORT).show();
        }
    }
}