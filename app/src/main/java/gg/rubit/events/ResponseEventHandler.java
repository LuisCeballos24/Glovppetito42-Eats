package gg.rubit.events;

import android.content.Context;
import android.media.MediaPlayer;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.components.conversation.data.DatosConversacion;

public class ResponseEventHandler {

    List<DatosConversacion> fuente = new ArrayList<>();
    List<DatosConversacion> Arrlst = new ArrayList<>();
    Context context;

    public void setContext(Context c) {
        context = c;
    }

    public int responseReceived(List<DatosConversacion> d) {
        for (int i = 0; i < d.size(); i++) {
            DatosConversacion obj = new DatosConversacion();
            obj.setId(d.get(i).getId());
            obj.setLecciones_id(d.get(i).getLecciones_id());
            obj.setPersona(d.get(i).getPersona());
            obj.setDialog(d.get(i).getDialog());
            obj.setAudio(d.get(i).getAudio());
            fuente.add(obj);
        }

        return fuente.size();
    }

    public List<DatosConversacion> datos(int count) {
        DatosConversacion datos = new DatosConversacion();
        datos.setId(fuente.get(count).getId());
        datos.setLecciones_id(fuente.get(count).getLecciones_id());
        datos.setPersona(fuente.get(count).getPersona());
        datos.setDialog(fuente.get(count).getDialog());
        datos.setAudio(fuente.get(count).getAudio());
        Arrlst.add(datos);

        //Reproducir pista de audio al agregar un nuevo renglon al lst
        playMp3(fuente.get(count).getAudio());

        return Arrlst;
    }

    public void playMp3(String Audio) {
        try {
            MediaPlayer mPlayer = MediaPlayer.create(context, context.getResources().getIdentifier(Audio, "raw", context.getPackageName()));
            mPlayer.start();
        } catch (Exception e) {
            Toast.makeText(context, "No se encontro la referencia de audio", Toast.LENGTH_LONG).show();
        }
    }
}
