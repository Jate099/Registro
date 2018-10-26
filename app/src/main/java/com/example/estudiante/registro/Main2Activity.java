package com.example.estudiante.registro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    EditText et_correo, et_contraseña;
    TextView tv_crear;
    Button btn_ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et_correo = findViewById(R.id.et_correo);
        et_contraseña = findViewById(R.id.et_contraseña);
        tv_crear = findViewById(R.id.tv_crear);
        btn_ingresar = findViewById(R.id.btn_ingresar);

        tv_crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
