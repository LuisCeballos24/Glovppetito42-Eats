package gg.glovpptetio42.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.api.request.Recipes;

public class RecipeListViewAdapter extends ArrayAdapter<Recipes> {
    List<Recipes> tabla = new ArrayList<>();

    //static int y=0;
    //int x=0;

    public RecipeListViewAdapter(Context context, List<Recipes> datos){
        super(context, R.layout.listview_receta,datos);
        tabla = datos;

    }

    public View getView(int position, View v, ViewGroup vg){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_receta, null);

        TextView producto = (TextView)item.findViewById(R.id.lslblProducto);
        producto.setText("Producto: "+tabla.get(position).getProducto());

        return item;
    }

}
