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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String palavraSorteada;
    private ArrayList<String> letras_chutadas = new ArrayList();
    private ArrayList<String> lista_letras = new ArrayList();
    private ArrayList<String> chutes_errados = new ArrayList();
    private int indice_erro = 0;
    private ArrayList<String> lista_palavra = new ArrayList();
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
        for (int i = 0; i < palavraSorteada.length(); i++) {
            lista_letras.add("_");
        }
        for (int i = 0; i < palavraSorteada.length(); i++) {
            lista_palavra.add(""+palavraSorteada.charAt(i));
        }
        for (int i = 0; i < 6; i++) {
            chutes_errados.add("");
        }
        for (int i = 0; i < palavraSorteada.length(); i++) {
            if(i==palavraSorteada.length()-1){
                u += "_";
            }else{
                u += "_" + " ";
            }
            lista_palavra.add(""+palavraSorteada.charAt(i));
        }
        palavraEscolhida.setText(u);
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

        System.out.println(letras_chutadas);
        System.out.println(chute);
        if(chute.length()<1 || chute.length()>1) {
            Toast.makeText(this,
                    "Digite apenas uma letra!!!",
                    Toast.LENGTH_SHORT).show();
        }else if(letras_chutadas.contains(chute)){
            Toast.makeText(this,
                    "Esta letra já foi dita!!!",
                    Toast.LENGTH_SHORT).show();
        }else{
            letras_chutadas.add(chute);
            int tem = 0;
            String palavra = "";
            String respostas_chutes = "";

            for (int i = 0; i < palavraSorteada.length(); i++) {
                if(lista_palavra.get(i).equals(chute)){
                    lista_letras.set(i,chute);
                    tem = 1;
                }
                palavra += lista_letras.get(i) + " ";
                respostas_chutes += lista_letras.get(i);
                System.out.println(lista_letras);
            }
            palavraEscolhida.setText(palavra);

            if(tem==0){
                chutes_errados.set(indice_erro,chute);
                indice_erro++;
                vidas++;
                progressBar.setProgress(vidas);
                textViewVidas.setText("Vidas: "+vidas+"/6");
                letrasErradas.setText("Letras Erradas: "+String.join("-",chutes_errados));
            }

            if(vidas==6){
                Toast.makeText(this,
                        "Infelizmente você perdeu :( , a palavra era \""+palavraSorteada+"\"",
                        Toast.LENGTH_LONG).show();
                resetarJogo();
            }
            if(respostas_chutes.equals(palavraSorteada)){
                Toast.makeText(this,
                        "Parabéns, você acertou!!! Palavra: \""+palavraSorteada+"\"",
                        Toast.LENGTH_LONG).show();
                resetarJogo();
            }
        }

    }

    public void resetarJogo(){
        vidas = 0;
        progressBar.setProgress(vidas);
        textViewVidas.setText("Vidas: 0/6");
        palavraEscolhida.setText("");
        enviar.setVisibility(View.INVISIBLE);
        chutes_errados.clear();
        lista_palavra.clear();
        lista_letras.clear();
        letras_chutadas.clear();
    }
}
