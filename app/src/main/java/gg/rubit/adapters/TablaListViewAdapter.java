package gg.rubit.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.R;
import gg.rubit.api.response.CVID_Tabla;

public class TablaListViewAdapter extends ArrayAdapter<CVID_Tabla> {
    List<CVID_Tabla> tabla = new ArrayList<>();

    //static int y=0;
    //int x=0;

    public TablaListViewAdapter(Context context, List<CVID_Tabla> datos){
        super(context, R.layout.listview_pranking,datos);
        tabla = datos;
        //y=0;
    }

    public View getView(int position, View v, ViewGroup vg){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_pranking, null);
/*
        y=y+1;

        TextView pos = (TextView) item.findViewById(R.id.txtPosicion);
        pos.setText("Posición: " + x);*/

        TextView jugador = (TextView)item.findViewById(R.id.lslblJugador);
        jugador.setText("Jugador: "+tabla.get(position).getNombre()+' '+tabla.get(position).getApellido());


        TextView puntaje = (TextView)item.findViewById(R.id.lslblPuntaje);
        puntaje.setText("Puntaje: "+tabla.get(position).getPuntajeac());


        return item;
    }
}
