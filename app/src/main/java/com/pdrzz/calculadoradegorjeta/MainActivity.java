package com.pdrzz.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editValor;
    private TextView textGorjeta,textTotal,textPorcentagem;
    private SeekBar seek;


    private double porcentagem=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    editValor=findViewById(R.id.editValor);
    textGorjeta=findViewById(R.id.textGorjeta);
    textTotal=findViewById(R.id.textTotal);
    textPorcentagem=findViewById(R.id.textPorcentagem);
    seek=findViewById(R.id.seekBar);

    listenerSeek();
    }


    public void calcular(){
        String valorRecuperado=editValor.getText().toString();
        if (valorRecuperado==null || valorRecuperado.equals("")){
            Toast.makeText(getApplicationContext(),"Digite um valor primeiro!",Toast.LENGTH_LONG).show();
        }else{
            double valorDigitado=Double.parseDouble(valorRecuperado);
            double gorjeta=valorDigitado*(porcentagem/100);
            textGorjeta.setText("R$ "+Math.round(gorjeta));
            double total=valorDigitado+Math.round(gorjeta);
            textTotal.setText("R$ "+total);


        }



    }
public void listenerSeek(){
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem=progress;
                textPorcentagem.setText(Math.round(porcentagem)+" %");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

}


}


