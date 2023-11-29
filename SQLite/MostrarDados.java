package com.example.atv_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MostrarDados extends AppCompatActivity {

    SQLiteDatabase bancodedados;
    private Button btnVoltar;
    private TextView listadados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_dados);

        bancodedados = openOrCreateDatabase("app", MODE_PRIVATE, null);

        btnVoltar = findViewById(R.id.buttonVoltar2);
        listadados = findViewById(R.id.listadados);

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaInicio();
            }
        });
    }

    public void abrirTelaInicio() {
        Intent telaInicio = new Intent(this, MainActivity.class);
        startActivity(telaInicio);
    }

    public void buscarDados() {
        String consulta = "SELECT nome, imc  FROM pessoas";
        Cursor cursor = bancodedados.rawQuery(consulta, null);

        int indiceNome = cursor.getColumnIndex("nome");
        int indiceIMC = cursor.getColumnIndex("imc");

        cursor.moveToFirst();
        String nome;
        float imc;
        while (cursor != null){
            nome = cursor.getString(indiceNome);
            imc = cursor.getFloat(indiceIMC);
            Log.i("Resultado - Nome: ", nome);
            Log.i("Resultado - IMC: ", cursor.getString(indiceIMC));
            Log.i("Avaliação do resultado: ", avaliacaoResultado(imc));
            cursor.moveToNext();

            String resultado = "Nome: ";
        }
    }

    private String avaliacaoResultado(float imc) {
        if (imc < 18.5) {
            return "Abaixo do Peso";
        } else if (imc < 24.9) {
            return "Peso Ideal";
        } else if (imc < 29.9) {
            return "Levemente acima do peso";
        } else if (imc < 34.9) {
            return "Obesidade grau I";
        } else if (imc < 39.9) {
            return "Obesidade grau II";
        } else {
            return "Obesidade III";
        }
    }
}