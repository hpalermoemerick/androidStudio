package com.example.atv_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarDados extends AppCompatActivity {
    private Button btnVoltar;
    private EditText inNome, inALtura, inPeso;
    SQLiteDatabase bancodedados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_dados);

        bancodedados = openOrCreateDatabase("app", MODE_PRIVATE, null);
        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS Usuario (nome VARCHAR, imc FLOAT)");

        inNome = findViewById(R.id.inNome);
        inALtura = findViewById(R.id.inAltura);
        inPeso = findViewById(R.id.inPeso);
        btnVoltar = findViewById(R.id.buttonVoltar);
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

    public void cadastrarDados() {
        String nome = inNome.getText().toString();
        double altura = Double.parseDouble(inALtura.getText().toString());
        double peso = Double.parseDouble(inPeso.getText().toString());

        String dadosUsuarios = String.format("%s, %.2f", nome, calculoIMC(altura, peso));
        bancodedados.execSQL("INSERT INTO Usuario (nome, imc) VALUES (dadosUsuarios)");
        Toast.makeText(
                getApplicationContext(),
                "Dado salvo!",
                Toast.LENGTH_SHORT
        ).show();
    }

    public double calculoIMC(double altura, double peso) {
        return peso / Math.pow(altura, 2);
    }
}