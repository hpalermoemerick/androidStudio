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
    private String[] chutes_errados = new String[6];
    private int indice_erro = 0;
    private String[] vetor_palavra;
    private TextView palavraEscolhida;
    private TextView textViewVidas;
    private ProgressBar progressBar;
    private EditText palpite;
    private Button enviar;
    private int vidas = 0;
    private int inicia_codigo = 0;
    private TextView letrasErradas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.enviar);
        enviar.setVisibility(View.INVISIBLE);

        palavraSorteada = sorteiaPalavra();
    }

    // SORTEIA A PALAVRA
    public String sorteiaPalavra(){
        String[] palavras = {"abacate","abacaxi","uva","banana","amora","cereja",
                            "pessego","guarana","carambola","figo"};
        int ale = (int)Math.floor(Math.random()*palavras.length);
        return palavras[ale];
    }

    // INICIALIZA O CÓDIGO
    public void inicializa(View view){
        if(inicia_codigo==0){
            enviar = findViewById(R.id.enviar);
            enviar.setVisibility(View.VISIBLE);
            exibirPalavra(palavraSorteada);
            inicia_codigo = 1;
        }
    }

    // EXIBE A PALAVRA COM UNDERLINES
    public void exibirPalavra(String palavraSorteada){
        palavraEscolhida = findViewById(R.id.palavraEscolhida);
        String u = "";
        vetor_letras = new String[palavraSorteada.length()];
        vetor_palavra = new String[palavraSorteada.length()];
        for (int i = 0; i < palavraSorteada.length(); i++) {
            if(i==palavraSorteada.length()-1){
                u += "_";
            }else{
                u += "_" + " ";
            }
            vetor_letras[i] = "_";
            vetor_palavra[i] = ""+palavraSorteada.charAt(i);
        }
        palavraEscolhida.setText(u);
        System.out.println("Palavra sorteada: "+palavraSorteada);
    }

    // ENVIAR PALPITE
    public void enviarPalpite(View view){
        progressBar = findViewById(R.id.progressBar);
        letrasErradas = findViewById(R.id.letrasErradas);
        palpite = findViewById(R.id.palpite);
        String chute = palpite.getText().toString().trim();
        palpite.setText("");
        progressBar = findViewById(R.id.progressBar);
        textViewVidas = findViewById(R.id.textViewVidas);

        int tem = 0;
        String palavra = "";
        String respostas_chutes = "";
        System.out.println("vetor_letras = "+String.join(" ",vetor_letras));

        for (int i = 0; i < palavraSorteada.length(); i++) {
            System.out.println("Laço "+i);
            if(vetor_palavra[i].equals(chute)){
                vetor_letras[i] = chute;
                tem = 1;
            }
            palavra += vetor_letras[i] + " ";
            respostas_chutes += vetor_letras[i];
        }

        palavraEscolhida.setText(palavra);
        System.out.println("Palavra = "+palavra);
        System.out.println("Respostas_chutes = "+respostas_chutes);

        if(tem==0){
            chutes_errados[indice_erro] = chute;
            vidas++;
            progressBar.setProgress(vidas);
            textViewVidas.setText("Vidas: "+vidas+"/6");
            letrasErradas.setText("Letras Erradas: "+String.join("-",chutes_errados));
        }

        if(vidas==6){
            Toast.makeText(this,
                    "Infelizmente você perdeu :( , a palavra era \""+palavraSorteada+"\"",
                    Toast.LENGTH_SHORT).show();
            vidas = 0;
            progressBar.setProgress(vidas);
            textViewVidas.setText("Vidas esgotadas!!!");
        }
        if(respostas_chutes.equals(palavraSorteada)){
            Toast.makeText(this,
                    "Parabéns, você acertou!!! Palavra: \""+palavraSorteada+"\"",
                    Toast.LENGTH_SHORT).show();
            vidas = 0;
            progressBar.setProgress(vidas);
            textViewVidas.setText("Vidas: 0/6");
        }
    }
}
