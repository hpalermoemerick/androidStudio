package com.example.aulafragment.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.aulafragment.Fragment.ContatosFragment;
import com.example.aulafragment.Fragment.ConversasFragment;
import com.example.aulafragment.R;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa, buttonContato;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonContato = findViewById(R.id.buttonContato);
        buttonConversa = findViewById(R.id.buttonConversas);


        conversasFragment = new ConversasFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // onde será exibido, quem será exibido
        transaction.replace(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        //listener pro botao
        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();
            }
        });

        //listener pro botao
        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();
            }
        });
    }
}
