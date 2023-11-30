package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Listagem extends AppCompatActivity {

    private Button buttonVoltar;
    private TextView listaDeDados;
    private SQLiteDatabase bancodedados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        bancodedados = openOrCreateDatabase("App", MODE_PRIVATE, null);

        listaDeDados = findViewById(R.id.listaDeDados);
        buttonVoltar = findViewById(R.id.buttonVoltar);
        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltarAoInicio();
            }
        });

        listarDados();
    }

    public void voltarAoInicio() {
        Intent telaInicio = new Intent(this, MainActivity.class);
        startActivity(telaInicio);
    }

    public void listarDados() {
        Toast.makeText(
                getApplicationContext(),
                "Tentando listar...",
                Toast.LENGTH_SHORT
        ).show();

        Cursor cursor = bancodedados.rawQuery("SELECT nome FROM Usuario", null);
        int indiceNome = cursor.getColumnIndex("nome");
        cursor.moveToFirst();
        String lista = "";
        try{
            while (cursor != null){
                lista += cursor.getString(indiceNome);
                cursor.moveToNext();
            }
            listaDeDados.setText("Lista de usuários e IMC's\n"+lista);

            Toast.makeText(
                    getApplicationContext(),
                    "Listagem feita!",
                    Toast.LENGTH_SHORT
            ).show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
