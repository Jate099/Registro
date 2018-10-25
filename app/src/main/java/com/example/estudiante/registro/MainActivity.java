package com.example.estudiante.registro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre;
    EditText et_correo;
    EditText et_contraseña;
    Button btn_registrarse;

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();

        et_nombre.findViewById(R.id.et_nombre);
        et_correo.findViewById(R.id.et_correo);
        et_contraseña.findViewById(R.id.et_contraseña);
        btn_registrarse.findViewById(R.id.btn_registrarse);

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario(et_nombre.getText().toString(), et_correo.getText().toString(), et_contraseña.getText().toString());

            }
        });
    }
}
