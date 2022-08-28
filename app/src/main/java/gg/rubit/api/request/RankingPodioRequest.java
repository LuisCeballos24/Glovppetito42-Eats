package gg.rubit.api.request;

public class RankingPodioRequest {

    private String nombre;
    private String apellido;
    private long puntajeac;

    public RankingPodioRequest(String nombre, String apellido, long puntajeac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.puntajeac = puntajeac;
    }

    public String getFirstName() {
        return nombre;
    }

    public void setFirstName(String nombre) {
        this.nombre = nombre;
    }

    public String getLastName() {
        return apellido;
    }

    public void setLastName(String apellido) {
        this.apellido = apellido;
    }

    public long getScore() {
        return puntajeac;
    }

    public void setScore(long puntajeac) {
        this.puntajeac = puntajeac;
    }
}