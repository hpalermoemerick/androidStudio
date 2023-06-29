package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);

       String sorteada = sortearPalavra();
       String[] ulines = new String[sorteada.length()];
       Button enviar = findViewById(R.id.enviar);
       Button iniciar = findViewById(R.id.iniciar);
       enviar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               enviarPalpite(v,sorteada,ulines,iniciar);
           }
       });


       iniciar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               iniciar.setVisibility(View.INVISIBLE);
               Toast.makeText(getApplicationContext(),"Iniciando...",Toast.LENGTH_LONG).show();
               preparar(v,sorteada,ulines);
           }
       });

   }

   public void preparar(View v,String sorteada,String[] ulines){
       TextView palavraEscolhida = findViewById(R.id.palavraEscolhida);

       String underlines = "";
       for(int i=0; i < sorteada.length(); i++){
           ulines[i] = "_";
           if(i==ulines.length){
               underlines += "_";
           }else{
               underlines += "_" + " ";
           }
       }
       palavraEscolhida.setText(underlines);
   }
   int vidas = 6;
   public String sortearPalavra(){
       String[] vet = {"brigadeiro","pastel","coxinha"};
       int ale = (int) Math.floor(Math.random()*vet.length);
       String a = vet[ale];
       return a;
   }

   public void enviarPalpite(View view,String sorteada,String[] ulines,Button iniciar){
       EditText inPalpite = findViewById(R.id.palpite);
       String palpite = inPalpite.getText().toString();
       TextView palavraEscolhida = findViewById(R.id.palavraEscolhida);
//        String palavra_usuario = palavraEscolhida.getText().toString();;
       String palavra = "";

       if(sorteada.indexOf(palpite) >= 0){
           for (int i = 0; i < sorteada.length(); i++) {
               if(sorteada.charAt(i)==palpite.charAt(0)){
                   ulines[i] = palpite;
                   palavra += ulines[i];
               }else{
                   palavra += ulines[i];
               }
           }

           if(palavra.equals(sorteada)){
               palavraEscolhida.setText("Você ganhou!!! A palavra é: "+palavra);
           }else{
               palavraEscolhida.setText(palavra);
           }

       }else{
           vidas--;
           if(vidas==0){
               palavraEscolhida.setText(sorteada);
               iniciar.setVisibility(View.VISIBLE);
               String res = "Você perdeu!!!, a palavra era "+sorteada;
               Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();
           }else{
               String res = "Não tem a letra ["+palpite+"]. Ainda restam "+vidas+" vida(s).";
               Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();
           }
          
       }
      

   }

}


