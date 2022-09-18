package gg.glovpptetio42.api.request;

public class AddRecipes {
    private String receta_id;
    private String producto;
    private String ingredientes;
    private String preparacion;

    public String getReceta_id() {
        return receta_id;
    }

    public void setReceta_id(String receta_id) {
        this.receta_id = receta_id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }
}
