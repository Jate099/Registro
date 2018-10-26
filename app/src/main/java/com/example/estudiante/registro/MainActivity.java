package com.example.estudiante.registro;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText et_nombre;
    EditText et_correo;
    EditText et_contraseña;
    Button btn_registrarse;
    TextView tv_jasacount;

    FirebaseDatabase db;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        et_nombre = findViewById(R.id.et_nombre);
        et_correo = findViewById(R.id.et_correo);
        et_contraseña = findViewById(R.id.et_contraseña);
        btn_registrarse = findViewById(R.id.btn_registrarse);
        tv_jasacount = findViewById(R.id.tv_jasacount);

        btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.createUserWithEmailAndPassword(et_correo.getText().toString(), et_contraseña.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Usuario nuevo = new Usuario(et_nombre.getText().toString(), et_correo.getText().toString(), et_contraseña.getText().toString());
                            nuevo.setUid(auth.getCurrentUser().getUid());
                            db.getReference().child("usuarios").child(nuevo.getUid()).setValue(nuevo);

                            Intent i = new Intent(MainActivity.this, Perfil.class);
                        }else{

                        }
                    }
                });

            }
        });

        /*btn_registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = new Usuario(et_nombre.getText().toString(), et_correo.getText().toString(), et_contraseña.getText().toString());

                db.getReference().child("usuarios").setValue(usuario);
                //db.getReference().push("usuarios").setValue(usuario); Crea una carpeta aleatoria que contiene los daos del usuario

            }
        });*/

        tv_jasacount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
