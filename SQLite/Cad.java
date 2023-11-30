package com.example.atvlite;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Cadastro extends AppCompatActivity {


   private Button buttonVoltar, buttonSalvar;
   private EditText inNome, inAltura, inPeso;


   private SQLiteDatabase bancodedados;


   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_cadastro);


       bancodedados = openOrCreateDatabase("sql", MODE_PRIVATE, null);


       buttonVoltar = findViewById(R.id.buttonVoltar2);
       inNome = findViewById(R.id.inNome);
       inAltura = findViewById(R.id.inAltura);
       inPeso = findViewById(R.id.inPeso);




       buttonVoltar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               voltarAoInicio();
           }
       });


       buttonSalvar = findViewById(R.id.buttonCadastro);
       buttonSalvar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               salvar();
           }
       });
   }


   public void voltarAoInicio() {
       Intent telaInicio = new Intent(this, MainActivity.class);
       startActivity(telaInicio);
   }


   public void salvar() {


       String nome = inNome.getText().toString();
       double altura = Double.parseDouble(inAltura.getText().toString());
       double peso = Double.parseDouble(inPeso.getText().toString());


       bancodedados.execSQL("CREATE TABLE IF NOT EXISTS Usuario (nome VARCHAR)");
       String comando = nome + " - " + valorIMC(peso, altura);
       bancodedados.execSQL("INSERT INTO Usuario (nome) VALUES ('" + comando + "')");


       Toast.makeText(
               getApplicationContext(),
               "Salvo!",
               Toast.LENGTH_SHORT
       ).show();
   }


   public int valorIMC(double peso, double altura) {
       return (int) (peso / altura*altura);
   }
}
