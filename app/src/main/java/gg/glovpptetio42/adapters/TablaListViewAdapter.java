package gg.glovpptetio42.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.api.response.CVID_Tabla;

public class TablaListViewAdapter extends ArrayAdapter<CVID_Tabla> {
    List<CVID_Tabla> tabla = new ArrayList<>();

    //static int y=0;
    //int x=0;

    public TablaListViewAdapter(Context context, List<CVID_Tabla> datos){
        super(context, R.layout.listview_comida,datos);
        tabla = datos;
        //y=0;
    }

    public View getView(int position, View v, ViewGroup vg){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_comida, null);
/*
        y=y+1;

        TextView pos = (TextView) item.findViewById(R.id.txtPosicion);
        pos.setText("Posición: " + x);*/

        TextView producto = (TextView)item.findViewById(R.id.lslblProducto);
        producto.setText("Producto: "+tabla.get(position).getProducto());
        TextView preparacion = (TextView)item.findViewById(R.id.lslblPreparacion);
        preparacion.setText("Preparacion: "+tabla.get(position).getPreparacion());
        TextView ingredientes = (TextView)item.findViewById(R.id.lslblIngredientes);
        ingredientes.setText("Ingredientes: "+tabla.get(position).getIngredientes());


        return item;
    }
}
