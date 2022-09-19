package gg.glovpptetio42.api.request;

public class FavRecipes {
   int guardado_id;
   int id;
   String producto;

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public int getGuardado_id() {
        return guardado_id;
    }

    public void setGuardado_id(int guardado_id) {
        this.guardado_id = guardado_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
