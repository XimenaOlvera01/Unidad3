package com.example.proyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.encoder.QRCode;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.HashMap;
import java.util.Map;

public class cupon extends AppCompatActivity {

    private DatabaseReference Tiendita;
    public EditText cveQR, nombreQR, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupon);

        cveQR = findViewById(R.id.cve);
        nombreQR = findViewById(R.id.nombre);
        direccion = findViewById(R.id.dire);
        ImageView imgQr = findViewById(R.id.qrCode);
        Button RC = findViewById(R.id.recc);

        Tiendita = FirebaseDatabase.getInstance().getReference();


        RC.setOnClickListener(view -> {
            String c = cveQR.getText().toString();
            String n = nombreQR.getText().toString();
            String d = direccion.getText().toString();
            try{
                Map<String, Object> QR = new HashMap<>();
                QR.put("Clave",c);
                QR.put("Nombre",n);
                QR.put("Direccion",d);

                BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                String coded, clavess;
                clavess = cveQR.getText().toString();
                coded = (clavess);
                Bitmap bitmap = barcodeEncoder.encodeBitmap(coded, BarcodeFormat.QR_CODE,750,750);
                imgQr.setImageBitmap(bitmap);

                Tiendita.child("QRN").child(c).setValue(QR);
                Toast.makeText(this, "QR de -10% descuento generado correctamente", Toast.LENGTH_SHORT).show();
            }catch (Exception e){
                Toast.makeText(this, "Ocurrio un problema con el QR", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }

        });
    }


}