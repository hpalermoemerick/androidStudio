package com.example.forca2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.forca2.R;

public class MainActivity extends AppCompatActivity {

    private String palavraSorteada;
    private String[] vetor_letras;
    private TextView palavraEscolhida;
    private TextView textViewVidas;
    private ProgressBar progressBar;
    private EditText palpite;
    private Button enviar;
    private int vidas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palavraSorteada = sorteiaPalavra();
    }

    // SORTEIA A PALAVRA
    public String sorteiaPalavra(){
        String[] palavras = {"abacate","abacaxi","uva","banana","amora","cereja"};
        int ale = (int)Math.floor(Math.random()*palavras.length);
        return palavras[ale];
    }

    // INICIALIZA O CÓDIGO
    public void inicializa(View view){
        enviar = findViewById(R.id.enviar);
        enviar.setVisibility(View.VISIBLE);
        exibirPalavra(palavraSorteada);
    }

    // EXIBE A PALAVRA COM UNDERLINES
    public void exibirPalavra(String palavraSorteada){
        palavraEscolhida = findViewById(R.id.palavraEscolhida);
        String u = "";
        vetor_letras = new String[palavraSorteada.length()];
        for (int i = 0; i < palavraSorteada.length(); i++) {
            if(i==palavraSorteada.length()-1){
                u += "_";
            }else{
                u += "_" + " ";
            }
        }
        palavraEscolhida.setText(u);
    }

    // ENVIAR PALPITE
    public void enviarPalpite(View view){
        System.out.println("Começou=======");
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(vidas++);
        
//        palpite = findViewById(R.id.palpite);
//        progressBar = findViewById(R.id.progressBar);
//        textViewVidas = findViewById(R.id.textViewVidas);
//        String chute = palpite.getText().toString().trim();
//        int tem = 0;
//        String palavra = "";
//        for (int i = 0; i < palavraSorteada.length()-1; i++) {
//            if(chute.substring(i,i+1).equals(chute)){
//                vetor_letras[i] = chute;
//                tem = 1;
//            }
//            if(i==palavraSorteada.length()-2){
//                palavra += vetor_letras[i];
//            }
//            else{
//                palavra += vetor_letras[i] + " ";
//            }
//        }
//        System.out.println(palavra);
//
//        if(tem==0){
//            vidas++;
//            progressBar.setProgress(vidas);
//            textViewVidas.setText("Vidas: "+vidas+"/6");
//        }
//
//        if(vidas==6){
//            Toast.makeText(this,
//                    "Infelizmente você perdeu :( , a palavra era "+palavraEscolhida,
//                    Toast.LENGTH_SHORT).show();
//        }
//        if(palavra.equals(palavraSorteada)){
//            Toast.makeText(this,
//                    "Parabéns, você acertou!!! Palavra: "+palavraSorteada,
//                    Toast.LENGTH_SHORT).show();
//        }
    }
}


