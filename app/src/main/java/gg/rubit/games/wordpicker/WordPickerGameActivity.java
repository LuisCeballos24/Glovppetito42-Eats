package gg.rubit.games.wordpicker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import gg.rubit.R;
import gg.rubit.games.quiz.QuizGameActivity;

public class WordPickerGameActivity extends AppCompatActivity {

    TextView lblPregunta;
    EditText txtRespuesta;
    Button btnRes1, btnRes2, btnRes3, btnRes4, btnRes5, btnRes6;
    String reply = "", rest;
    String n1 = "", n2 = "", n3 = "", n4 = "", n5 = "", n6 = "";
    int puntaje;
    String res2;

    String question = "", answer = "";
    int questionNumber;

    int userId;
    Intent i;

    String[] preguntas = {
            "Ventajas del Patron Command",
            "¿Dónde nace el término scrum?",
            "¿En qué año nació el manifiesto ágil?",
            "¿Qué lenguaje utiliza el Proceso Unificado?"
    };

    String[] respuestas = {
            "Deshacer y Rehacer",
            "en 1986 en Japón",
            "nació en el año 2001",
            "lenguaje unificado de modelado"
    };

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugabilidad3);
        initializeControllers();
    }

    private void initializeControllers() {
        i = getIntent();
        userId = i.getIntExtra("UserId", 0);

        questionNumber = (int) (Math.random() * 4);
        question = preguntas[questionNumber];
        answer = respuestas[questionNumber];

        String[] splitAnswers = answer.split(" ");
        int length = splitAnswers.length;
        int i;
        res2 = answer + " ";
        Toast.makeText(this, "i: " + length, Toast.LENGTH_LONG).show();

        for (i = 0; i < length; i = i + 1) {
            switch (i) {
                case 0:
                    n1 = splitAnswers[0];
                    break;
                case 1:
                    n2 = splitAnswers[1];
                    break;
                case 2:
                    n3 = splitAnswers[2];
                    break;
                case 3:
                    n4 = splitAnswers[3];
                    break;
                case 4:
                    n5 = splitAnswers[4];
                    break;
                case 5:
                    n6 = splitAnswers[5];
                    break;
            }
        }

        lblPregunta = findViewById(R.id.lbloracion);
        lblPregunta.setText(question);
        txtRespuesta = findViewById(R.id.txtRespuesta);
        btnRes1 = findViewById(R.id.btnRes1);
        btnRes1.setText(n1);
        btnRes2 = findViewById(R.id.btnRes2);
        btnRes2.setText(n2);
        btnRes3 = findViewById(R.id.btnRes3);
        btnRes3.setText(n3);
        btnRes4 = findViewById(R.id.btnRes4);
        btnRes4.setText(n4);
        btnRes5 = findViewById(R.id.btnRes5);
        btnRes5.setText(n5);
        btnRes6 = findViewById(R.id.btnRes6);
        btnRes6.setText(n6);
    }

    public void checkAnswer(View view) {
        rest = txtRespuesta.getText().toString();

        if (rest.isEmpty()) {
            OkAlert okAlert = new OkAlert("Campos vacios. Ingrese la respuesta");
            okAlert.show(getSupportFragmentManager(), "Rellenar");
        } else {
            if (rest.equals(res2)) {
                puntaje = puntaje+5;
                Toast.makeText(this, "correcto: " + res2, Toast.LENGTH_SHORT).show();
                ContinueAlert alert = new ContinueAlert("Respuesta correcta");
                alert.show(getSupportFragmentManager(), "Felicidades");
            } else {
                Toast.makeText(this, "respuesta correcta: " + res2 + ". Respuesta ingresada: " + rest, Toast.LENGTH_SHORT).show();
                ContinueAlert alert = new ContinueAlert("Respuesta incorrecta");
                alert.show(getSupportFragmentManager(), "Incorrecto");
            }
        }

        mp = MediaPlayer.create(this, R.raw.confirm);
        mp.start();
    }

    public void replyButton(View view) {
        switch (view.getId()) {
            case (R.id.btnRes1):
                if (reply.equals("")) {
                    reply = n1 + " ";
                } else {
                    reply = reply + n1 + " ";
                }

                txtRespuesta.setText(reply);
                break;
            case (R.id.btnRes2):
                if (reply.equals("")) {
                    reply = n2 + " ";
                } else {
                    reply = reply + n2 + " ";
                }

                txtRespuesta.setText(reply);
                break;
            case (R.id.btnRes3):
                if (reply.equals("")) {
                    reply = n3 + " ";
                } else {
                    reply = reply + n3 + " ";
                }

                txtRespuesta.setText(reply);
                break;
            case (R.id.btnRes4):
                if (reply.equals("")) {
                    reply = n4 + " ";
                } else {
                    reply = reply + n4 + " ";
                }

                txtRespuesta.setText(reply);
                break;
            case (R.id.btnRes5):
                if (reply.equals("")) {
                    reply = n5 + " ";
                } else {
                    reply = reply + n5 + " ";
                }

                txtRespuesta.setText(reply);
                break;
            case (R.id.btnRes6):
                if (reply.equals("")) {
                    reply = n6 + " ";
                } else {
                    reply = reply + n6 + " ";
                }

                txtRespuesta.setText(reply);
                break;
        }

        mp = MediaPlayer.create(this, R.raw.gallatin);
        mp.start();
    }

    public static class OkAlert extends DialogFragment {

        private final String message;

        public OkAlert(String message) {
            this.message = message;
        }

        @NonNull @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity()).setMessage(message).setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.cancel()).create();
        }
    }

    public static class ContinueAlert extends DialogFragment {

        private final String message;

        public ContinueAlert(String message) {
            this.message = message;
        }

        @NonNull @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            Intent gameIntent = new Intent(getContext(), QuizGameActivity.class);
            //gameIntent.putExtra("UserId", userId);

            return new AlertDialog.Builder(getActivity()).setMessage(message).setPositiveButton("Continuar", (dialogInterface, i) -> startActivity(new Intent(getContext(), QuizGameActivity.class))).create();
        }
    }
}
