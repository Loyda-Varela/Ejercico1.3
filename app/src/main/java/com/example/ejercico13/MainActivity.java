package com.example.ejercico13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercico13.procesos.Personas;
import com.example.ejercico13.procesos.SQLiteConexion;

public class MainActivity extends AppCompatActivity {
    EditText txtnombres, txtapellidos, txtedad, txtcorreo, txtdireccion;
    Button btnguardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //casteo de elemntos
        init();

        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersonas();
            }
        });

    }
     private void init(){
         txtnombres=(EditText) findViewById(R.id.txtnombres);
         txtapellidos=(EditText) findViewById(R.id.txtapellidos);
         txtedad=(EditText) findViewById(R.id.txtedad);
         txtcorreo=(EditText) findViewById(R.id.txtcorreo);
         txtdireccion=(EditText) findViewById(R.id.txtdireccion);

         btnguardar =(Button) findViewById(R.id.btnguardar);

     }

    private void AgregarPersonas() {
        SQLiteConexion conexion =  new SQLiteConexion(this, Personas.NameDataBase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();
        //pasar conten values
        ContentValues valores = new ContentValues();
        valores.put(Personas.nombres, txtnombres.getText().toString());
        valores.put(Personas.apellidos, txtapellidos.getText().toString());
        valores.put(Personas.edad, txtedad.getText().toString());
        valores.put(Personas.correo, txtcorreo.getText().toString());
        valores.put(Personas.direccion, txtdireccion.getText().toString());

        Long resultado = db.insert(Personas.tablaEmpleados, Personas.id,valores);

        Toast.makeText(getApplicationContext(), "Registro Ingresado con Exito", Toast.LENGTH_LONG).show();
        db.close();
        
        //limpiar la pantalla
        ClearScreen();

    }

    private void ClearScreen() {
        txtnombres.setText("");
        txtapellidos.setText("");
        txtedad.setText("");
        txtcorreo.setText("");
        txtdireccion.setText("");
    }
}