package br.ulbra.appjokenpo;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    }
    int pontuacaoJogador=0;
    int pontuacaoApp=0;

        // Função chamada quando o usuário escolhe Pedra
        public void selecionadoPedra(View view) {
            this.opcaoSelecionado("pedra");
        }

        // Função chamada quando o usuário escolhe Papel
        public void selecionadoPapel(View view) {
            this.opcaoSelecionado("papel");
        }

        // Função chamada quando o usuário escolhe Tesoura
        public void selecionadoTesoura(View view) {
            this.opcaoSelecionado("tesoura");
        }

        // Função que processa a escolha do jogador
        public void opcaoSelecionado(String opcaoSelecionada) {
            ImageView imageResultado = findViewById(R.id.imgApp);
            TextView txtResult = findViewById(R.id.txtResultado);
            TextView txtPlacar = findViewById(R.id.txtPlacar);

            // Opções possíveis para o app
            String[] opcoes = {"pedra", "papel", "tesoura"};
            String opcaoApp = opcoes[new Random().nextInt(3)];

            // Definir a imagem do app dependendo da escolha
            switch (opcaoApp) {
                case "pedra":
                    imageResultado.setImageResource(R.drawable.pedra);
                    break;
                case "papel":
                    imageResultado.setImageResource(R.drawable.papel);
                    break;
                case "tesoura":
                    imageResultado.setImageResource(R.drawable.tesoura);
                    break;
            }

            // Condicional para definir o vencedor
            if ((opcaoApp.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                    (opcaoApp.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                    (opcaoApp.equals("pedra") && opcaoSelecionada.equals("tesoura"))) {
                txtResult.setText("Resultado: VOCÊ PERDEU!!!");
                pontuacaoApp++;

            } else if ((opcaoSelecionada.equals("tesoura") && opcaoApp.equals("papel")) ||
                    (opcaoSelecionada.equals("papel") && opcaoApp.equals("pedra")) ||
                    (opcaoSelecionada.equals("pedra") && opcaoApp.equals("tesoura"))) {
                txtResult.setText("Resultado: VOCÊ GANHOU!!!");
                pontuacaoJogador++;
            } else {
                txtResult.setText("Resultado:EMPATE!!!");
            }

            // Atualiza placar
            atualizarPlacar(txtPlacar);
        }

    // Atualiza o placar na interface
    public void atualizarPlacar(TextView txtPlacar) {
        txtPlacar.setText("Jogador: " + pontuacaoJogador + " - App: " + pontuacaoApp);
    }

    // Reinicia o jogo
    public void reiniciarJogo(View view) {

        atualizarPlacar((TextView) findViewById(R.id.txtPlacar));

        // Restaura imagem e texto padrão
        ImageView imageResultado = findViewById(R.id.imgApp);
        imageResultado.setImageResource(R.drawable.padrao);

        TextView txtResult = findViewById(R.id.txtResultado);
        txtResult.setText("Resultado: ");
    }
}







