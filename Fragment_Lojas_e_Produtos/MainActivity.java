package com.example.aulafragmanet.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.aulafragmanet.R;
import com.example.aulafragmanet.Fragment.FragmentLojas;
import com.example.aulafragmanet.Fragment.FragmentProdutos;
public class MainActivity extends AppCompatActivity {
//    private FrameLayout frameLayout;
    private Button buttonLojas, buttonProdutos;
    private FragmentProdutos fragmentProdutos;
    private FragmentLojas fragmentLojas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setElevation(0);

        buttonLojas = findViewById(R.id.buttonLojas);
        buttonProdutos = findViewById(R.id.buttonProdutos);

        fragmentLojas = new FragmentLojas();
        FragmentTransaction transaction = getSupportFragmentManager().openTransaction();
        transaction.replace(R.id.buttonLojas, fragmentLojas);
        transaction.commit();

        buttonLojas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentProdutos = new FragmentProdutos();
                FragmentTransaction transaction = getSupportFragmentManager().openTransaction();
                transaction.replace(R.id.buttonProdutos, fragmentProdutos);
                transaction.commit();
            }
        });

        buttonProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentLojas = new FragmentLojas();
                FragmentTransaction transaction = getSupportFragmentManager().openTransaction();
                transaction.replace(R.id.buttonLojas, fragmentLojas);
                transaction.commit();
            }
        });
    }
}
