package gg.rubit.api.response;

public class CVID_Tabla {
    private String correo;
    private String nombre;
    private String apellido;
    private int puntajeac;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPuntajeac() {
        return puntajeac;
    }

    public void setPuntajeac(int puntajeac) {
        this.puntajeac = puntajeac;
    }
}
