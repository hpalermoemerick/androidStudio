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
        System.out.printf(u);
        palavraEscolhida.setText(u);
    }
}
