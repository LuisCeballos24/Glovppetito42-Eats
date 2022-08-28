package gg.rubit.ui.bar.progress;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import gg.rubit.R;

public class ProgressBarUI extends AppCompatActivity {

    Button btn;
    ProgressBar pb;

    // Para dar el efecto de animacion
    ImageView anim;

    // Para controlar que mientras no se complete el aumento de la barra no permite llamar al metodo aumentar barra nuevamente
    boolean activo;

    // Para controlar la estructura do while, como se utiliza en varios hilos es necesario que sea global
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barra_progreso);

        initializeControllers();

        activo = false;
        i = 1;

        btn.setOnClickListener(v -> {
            if (!activo) {
                activo = true;
                increaseProgress();
            }
        });
    }

    private void initializeControllers() {
        btn = (Button) findViewById(R.id.bt);
        pb = (ProgressBar) findViewById(R.id.pgBar);
        anim = (ImageView) findViewById(R.id.animation);
    }

    private void increaseProgress() {
        new Thread() {
            @Override
            public void run() {
                try {
                    runOnUiThread(() -> // Hilo para animar el imageview y simular un efecto ripple a la barra
                            anim.animate().scaleX(1.2f).scaleY(1.2f).alpha(0f).setDuration(1000)
                                    .withEndAction(() -> {
                                        anim.setScaleX(1f);
                                        anim.setScaleY(1f);
                                        anim.setAlpha(1f);
                                    }));
                    do { // Thread para aumentar el progreso de la barra
                        Thread.sleep(50); // Se duerme el Thread por 50ms para que la barra suba lentamente
                        runOnUiThread(() -> {
                            pb.incrementProgressBy(1);
                            i++;
                        });
                    } while (i < 10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        // Se cambian las variables para poder realizar nuevamente el llamado
        activo = false;
        i = 1;
    }
}