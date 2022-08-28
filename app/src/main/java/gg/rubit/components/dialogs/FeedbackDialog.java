package gg.rubit.components.dialogs;

import android.app.Dialog;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class FeedbackDialog extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        String msg = args.getString("ResCorrecta");
        return new AlertDialog.Builder(getActivity()).setTitle("Retroalimentación").setMessage("Respuesta Correcta:\n" + msg).setPositiveButton("Aceptar", (dialogInterface, i) -> {

        }).create();
    }
}
