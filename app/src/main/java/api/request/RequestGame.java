package gg.rubit.api.request;


public class RequestGame {

    private String nombre;
    private int puntaje;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String jugador) {
        this.nombre = jugador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

}
