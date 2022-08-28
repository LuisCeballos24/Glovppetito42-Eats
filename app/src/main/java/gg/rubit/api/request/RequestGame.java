package gg.rubit.api.request;


import java.util.List;

import gg.rubit.api.response.Partida;

public class RequestGame {

    private String nombre;
    private int puntaje;
    private List<Partida> detalle;


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

    public List<Partida> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Partida> detalle) {
        this.detalle = detalle;

    }
}
