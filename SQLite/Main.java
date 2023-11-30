package com.example.atvlite;


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


       buttonCadastrar = findViewById(R.id.buttonCadastro);
       buttonCadastrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               abrirTelaCadastro();
           }
       });


       buttonListar = findViewById(R.id.buttonListagem);
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
