package gg.glovpptetio42.api.request;

public class Recipes {
    private String receta_id;
    private String producto;

    public String getProducto() {
        return producto;
    }

    public String getReceta_id() {
        return receta_id;
    }

    public void setReceta_id(String receta_id) {
        this.receta_id = receta_id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

}
