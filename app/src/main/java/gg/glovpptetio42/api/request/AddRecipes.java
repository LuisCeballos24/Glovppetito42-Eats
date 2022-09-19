package gg.glovpptetio42.api.request;

public class AddRecipes {
    private int id;
    private int usuario_id;
    private String producto;
    private String ingredientes;
    private String preparacion;

    public int getReceta_id() {
        return id;
    }

    public void setReceta_id(int receta_id) {
        this.id = receta_id;
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
