package gg.rubit.adapters;

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
import gg.rubit.data.ConversationDataValues;

public class ConversationListViewAdapter extends ArrayAdapter<ConversationDataValues> {

    List<ConversationDataValues> dialogs;

    public ConversationListViewAdapter(Context context, List<ConversationDataValues> datos) {
        super(context, R.layout.listview_chats, datos);
        dialogs = datos;

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public View getView(int pos, View v, ViewGroup vg) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View itemView = inflater.inflate(R.layout.listview_chats, null);

        TextView lblDialog = itemView.findViewById(R.id.lblData);
        lblDialog.setText(dialogs.get(pos).getDialog());

        TextView lblSong = itemView.findViewById(R.id.lblaudio);
        lblSong.setText(dialogs.get(pos).getAudio());

        ImageView img1 = itemView.findViewById(R.id.img);
        ImageView img2 = itemView.findViewById(R.id.img2);

        switch (dialogs.get(pos).getPersona()) {
            case 1:
                img1.setImageResource(R.drawable.m);
                img2.setImageResource(R.drawable.audio2);
                break;
            case 2:
                img1.setImageResource(R.drawable.audio);
                img2.setImageResource(R.drawable.h);
                break;
        }

        return itemView;
    }
}
