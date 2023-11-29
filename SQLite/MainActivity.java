package com.example.atv_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnCadatro, buttonListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadatro = findViewById(R.id.buttonCadastrar);
        btnCadatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaCadastro();
            }
        });

        buttonListar = findViewById(R.id.buttonListar);
        buttonListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirTelaListagem();
            }
        });
    }

    public void abrirTelaCadastro() {
        Intent telaCadastro = new Intent(this, CadastrarDados.class);
        startActivity(telaCadastro);
    }

    public void abrirTelaListagem() {
        Intent telaListagem = new Intent(this, MostrarDados.class);
        startActivity(telaListagem);
    }
}