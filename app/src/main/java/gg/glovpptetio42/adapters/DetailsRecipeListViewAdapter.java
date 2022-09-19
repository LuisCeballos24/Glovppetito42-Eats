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
import gg.glovpptetio42.api.request.AddRecipes;

public class DetailsRecipeListViewAdapter extends ArrayAdapter<AddRecipes> {

        List<AddRecipes> tabla = new ArrayList<>();

    public DetailsRecipeListViewAdapter(Context context, List<AddRecipes> datos){
        super(context, R.layout.detallada_template,datos);
        tabla = datos;
    }
        public View getView(int position, View v, ViewGroup vg){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.detallada_template, null);

        TextView producto = (TextView)item.findViewById(R.id.txtnombreReceta);
        producto.setText(tabla.get(position).getProducto());
        TextView ingrediente = (TextView)item.findViewById(R.id.txtIng1);
        ingrediente.setText(tabla.get(position).getIngredientes());
        TextView preparacion = (TextView)item.findViewById(R.id.txtprepa);
        preparacion.setText(tabla.get(position).getPreparacion());

        return item;
    }
}
