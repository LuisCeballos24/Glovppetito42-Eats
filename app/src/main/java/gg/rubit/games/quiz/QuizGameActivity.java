package gg.rubit.games.quiz;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;
import gg.rubit.components.puntos.PuntosActivity;
import gg.rubit.ui.bar.navigation.NavigationBarUI;

public class QuizGameActivity extends AppCompatActivity implements View.OnClickListener {

    final String[] question = {
            "¿Cuál es la definición de las metodologías agiles?",
            "¿Cuál de estas opciones es una metodología ágil?",
            "¿Dónde nace el término scrum?",
            "Mencione una ventaja de las metodologías agiles"
    };

    final String[][] choices = {
            {"Permiten adaptar la forma de trabajo a las condiciones del proyecto", "Obligan a trabajar de una forma", "No se trabaja", "Se logra mas agilidad si trabajan corriendo"},
            {"Correr", "Gangatron", "Lin", "Scrum"},
            {"En una cafeteria", "En Japón en el año 1986", "En el año 420 D.C", "En un foro de hackers"},
            {"Metabolismo mas rapido", "Aumento de capacidad neuronal", "Mejorar la calidad de los productos", "RGB+FPS = PRO"}
    };

    final String[] correctAnswers = {
            "Permiten adaptar la forma de trabajo a las condiciones del proyecto",
            "Scrum",
            "En Japón en el año 1986",
            "Mejorar la calidad de los productos"
    };

    TextView preguntaTxt;
    Button opcionA, opcionB, opcionC, opcionD;
    Button siguienteBtn;

    int score = 0;
    int questions = question.length;
    int currentIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_game_activity);

        preguntaTxt = findViewById(R.id.pregunta);
        opcionA = findViewById(R.id.opcion_a);
        opcionB = findViewById(R.id.opcion_b);
        opcionC = findViewById(R.id.opcion_c);
        opcionD = findViewById(R.id.opcion_d);
        siguienteBtn = findViewById(R.id.siguiente_buton);

        opcionA.setOnClickListener(this);
        opcionB.setOnClickListener(this);
        opcionC.setOnClickListener(this);
        opcionD.setOnClickListener(this);
        siguienteBtn.setOnClickListener(this);

        nextQuestion();
    }

    @Override
    public void onClick(View view) {
        opcionA.setBackgroundColor(Color.WHITE);
        opcionB.setBackgroundColor(Color.WHITE);
        opcionC.setBackgroundColor(Color.WHITE);
        opcionD.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.siguiente_buton) {
            if (selectedAnswer.equals(correctAnswers[currentIndex])) {
                score++;
            }

            currentIndex++;
            nextQuestion();
        } else {
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.parseColor("#9E5CE3"));
        }
    }

    void nextQuestion() {
        if (currentIndex == questions) {
            finishQuiz();
            return;
        }

        preguntaTxt.setText(question[currentIndex]);
        opcionA.setText(choices[currentIndex][0]);
        opcionB.setText(choices[currentIndex][1]);
        opcionC.setText(choices[currentIndex][2]);
        opcionD.setText(choices[currentIndex][3]);
    }

    void finishQuiz() {
        String status = "";
        if (score > questions * 0.60) {
            status = "Respuesta Correcta";
        } else {
            status = "Respuesta Incorrecta";
        }

        new AlertDialog.Builder(this)
                .setTitle(status)
                .setMessage("Acertaste " + score + " respuestas de " + questions + " preguntas!")
                .setPositiveButton("Finalizar", (dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    void restartQuiz() {
        Intent i = new Intent(getApplicationContext(), PuntosActivity.class);
        i.putExtra("puntaje", score);
        startActivity(i);
        currentIndex = 0;

    }
}
