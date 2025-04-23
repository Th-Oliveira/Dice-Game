package com.example.jogodedados;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView dado1, dado2;
    TextView resultado;
    int jogador1 = 0, jogador2 = 0, empates = 0;

    int[] imagensDados = {
            R.drawable.dado1, R.drawable.dado2, R.drawable.dado3,
            R.drawable.dado4, R.drawable.dado5, R.drawable.dado6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dado1 = findViewById(R.id.imgDado1);
        dado2 = findViewById(R.id.imgDado2);
        resultado = findViewById(R.id.txtResultado);

        Button jogar = findViewById(R.id.btnJogar);
        Button verPlacar = findViewById(R.id.btnPlacar);

        jogar.setOnClickListener(v -> rolarDados());

        verPlacar.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
            intent.putExtra("jogador1", jogador1);
            intent.putExtra("jogador2", jogador2);
            intent.putExtra("empates", empates);
            startActivity(intent);
        });
    }

    private void rolarDados() {
        Random r = new Random();
        int num1 = r.nextInt(6);
        int num2 = r.nextInt(6);

        dado1.setImageResource(imagensDados[num1]);
        dado2.setImageResource(imagensDados[num2]);

        if (num1 > num2) {
            resultado.setText("VENCEDOR: Jogador 1");
            jogador1++;
        } else if (num2 > num1) {
            resultado.setText("VENCEDOR: Jogador 2");
            jogador2++;
        } else {
            resultado.setText("RESULTADO: Empate");
            empates++;
        }
    }
}
