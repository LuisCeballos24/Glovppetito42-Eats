package gg.glovpptetio42.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import gg.glovpptetio42.R;
import gg.glovpptetio42.api.request.AddRecipes;
import gg.glovpptetio42.api.request.FavRecipes;
import gg.glovpptetio42.api.request.Recipes;

public class FavRecipeListViewAdapter extends ArrayAdapter<FavRecipes> {

    List<FavRecipes> tabla = new ArrayList<>();

    public FavRecipeListViewAdapter(Context context, List<FavRecipes> datos){
        super(context, R.layout.favoritas_template,datos);
        tabla = datos;
    }
    public View getView(int position, View v, ViewGroup vg){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.favoritas_template, null);

        TextView producto = (TextView)item.findViewById(R.id.txtnombreReceta);
        producto.setText((CharSequence) tabla.get(position).getProducto());

        return item;
    }
}
