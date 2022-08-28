package gg.rubit.components.conversation.adapters;

import android.content.Context;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import gg.rubit.R;
import gg.rubit.components.conversation.data.DatosConversacion;

public class ConversacionListViewAdapter extends ArrayAdapter<DatosConversacion> {

    List<DatosConversacion> Dialog;

    public ConversacionListViewAdapter(Context context, List<DatosConversacion> datos) {
        super(context, R.layout.listview_chats, datos);
        Dialog = datos;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public View getView(int pos, View v, ViewGroup vg) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemview = inflater.inflate(R.layout.listview_chats, null);

        TextView lblDialog = itemview.findViewById(R.id.lblData);
        lblDialog.setText(Dialog.get(pos).getDialog());

        TextView lblCancion = itemview.findViewById(R.id.lblaudio);
        lblCancion.setText(Dialog.get(pos).getAudio());

        ImageView img1 = itemview.findViewById(R.id.img);
        ImageView img2 = itemview.findViewById(R.id.img2);

        if (Dialog.get(pos).getPersona() == 1) {
            img1.setImageResource(R.drawable.m);
            img2.setImageResource(R.drawable.audio2);
        } else if (Dialog.get(pos).getPersona() == 2) {
            img1.setImageResource(R.drawable.audio);
            img2.setImageResource(R.drawable.h);
        }

        return itemview;
    }
}
