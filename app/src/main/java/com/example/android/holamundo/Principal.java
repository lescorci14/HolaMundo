package com.example.android.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    private EditText cajaNombre;
    private EditText cajaApellido;
    private Intent i;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);
        i = new Intent(this,Saludo.class);
        b = new Bundle();

    }

    public void saludar(View v){
        String nomb, apell;
       if(validar()) {
           nomb = cajaNombre.getText().toString();
           apell = cajaApellido.getText().toString();

           b.putString("Nombre", nomb);
           b.putString("Apellido", apell);

           i.putExtras(b);

           startActivity(i);
       }
    }

    public boolean validar(){
        if(cajaNombre.getText().toString().isEmpty()){
            cajaNombre.setError(getResources().getString(R.string.error_1));
            //Toast.makeText(this,"Digite por favor el Nombre",Toast.LENGTH_SHORT).show();
            return false;
        }
        if(cajaApellido.getText().toString().isEmpty()){
            cajaApellido.setError(getResources().getString(R.string.error_2));
            //Toast.makeText(this,"Digite por favor el Apellido",Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
