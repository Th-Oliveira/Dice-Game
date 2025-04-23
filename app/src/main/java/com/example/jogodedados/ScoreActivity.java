package com.example.jogodedados;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        int j1 = getIntent().getIntExtra("jogador1", 0);
        int j2 = getIntent().getIntExtra("jogador2", 0);
        int empates = getIntent().getIntExtra("empates", 0);

        TextView placar = findViewById(R.id.txtPlacar);
        placar.setText("Jogador1: " + j1 + "\nJogador2: " + j2 + "\nEmpates: " + empates);

        Button btnRetornar = findViewById(R.id.btnRetornar);
        btnRetornar.setOnClickListener(v -> finish());
    }
}
