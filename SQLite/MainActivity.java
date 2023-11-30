package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonCadastrar, buttonListar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        SQLiteDatabase bancodedados = openOrCreateDatabase("app", MODE_PRIVATE, null);
//
//        bancodedados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR," + " idade int(3))");

        //inserindo dados na tabela
//        bancodedados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro', 17)");
//        bancodedados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Thiaguin', 18)");
//
//        //recuperar dados
//        String consulta = "SELECT nome, idade FROM pessoas";
//        Cursor cursor = bancodedados.rawQuery(consulta, null);
//
//        //indices de tabelas
//        int indiceNome = cursor.getColumnIndex("nome");
//        int indiceIdade = cursor.getColumnIndex("idade");
//
//        cursor.moveToFirst();
//        String nome;
//        int idade;
//        while (cursor != null){
//            nome = cursor.getString(indiceNome);
//            idade = cursor.getInt(indiceIdade);
//            Log.i("Resultado - Nome: ", nome);
//            Log.i("Resultado - Idade: ", cursor.getString(indiceIdade));
//            cursor.moveToNext();
//        }

        buttonCadastrar = findViewById(R.id.buttonCadastrar);
        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
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
        Intent telaCadastro = new Intent(this, Cadastro.class);
        startActivity(telaCadastro);
    }

    public void abrirTelaListagem() {
        Intent telaListagem = new Intent(this, Listagem.class);
        startActivity(telaListagem);
    }
}
