package com.example.gorjeta;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
private SeekBar seekBarPessoas,seekBarGorjeta;
private TextView pessoas,gorjeta;
private EditText valorConta;
private int numPessoas;
private int porGorjeta;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
pessoas = findViewById(R.id.numPessoas);
gorjeta = findViewById(R.id.porGorjeta);
seekBarPessoas = findViewById(R.id.seekBarPessoas);
seekBarPessoas.setOnSeekBarChangeListener(new
SeekBar.OnSeekBarChangeListener() {
@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
numPessoas = progress;
pessoas.setText("Números de Pessoas: " + numPessoas);
}
@Override
public void onStartTrackingTouch(SeekBar seekBar) {
numPessoas = seekBar.getProgress();
pessoas.setText("Números de Pessoas: " + numPessoas);
}
@Override
public void onStopTrackingTouch(SeekBar seekBar) {
numPessoas = seekBar.getProgress();
pessoas.setText("Números de Pessoas: " + numPessoas);

}
});
seekBarGorjeta = findViewById(R.id.seekBarGorjeta);
seekBarGorjeta.setOnSeekBarChangeListener(new
SeekBar.OnSeekBarChangeListener() {
@Override
public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
porGorjeta = progress;
gorjeta.setText("Porcentagem da Gorjeta: " + porGorjeta);
}
@Override
public void onStartTrackingTouch(SeekBar seekBar) {
porGorjeta = seekBar.getProgress();
gorjeta.setText("Porcentagem da Gorjeta: " + porGorjeta);
}
@Override
public void onStopTrackingTouch(SeekBar seekBar) {
porGorjeta = seekBar.getProgress();
gorjeta.setText("Porcentagem da Gorjeta: " + porGorjeta);
}
});
}
public void calcularValor(View view){
valorConta = findViewById(R.id.valorConta);
double valorgorjeta = porGorjeta;
double valor = Double.parseDouble(valorConta.getText().toString());
double valorIndividual = valor/numPessoas;
double gorj = valorIndividual+(valorIndividual*(valorgorjeta/100));
AlertDialog.Builder alerta = new AlertDialog.Builder(this);
alerta.setTitle("GORJETA!!!");
alerta.setMessage("Deseja saber o valor individual com ou sem gorjeta?");
alerta.setPositiveButton("Com gorjeta", new DialogInterface.OnClickListener() {
@Override
public void onClick(DialogInterface dialog, int which) {
Toast.makeText(
getApplicationContext(),
String.format("Valor individual: R$%.2f",gorj),
Toast.LENGTH_SHORT).show();
}
});
alerta.setNegativeButton("Sem gorjeta", new DialogInterface.OnClickListener() {

@Override
public void onClick(DialogInterface dialog, int which) {
Toast.makeText(getApplicationContext(),
String.format("Valor individual: R$%.2f",valorIndividual),
Toast.LENGTH_SHORT).show();
}
});
alerta.create();
alerta.show();
}
}
