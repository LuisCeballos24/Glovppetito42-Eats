package gg.rubit.data;

public class UserDataValues {

    private int id;
    private int usuario_id;
    private String nombre;
    private String apellido;
    private String cedula;
    private String tipo_usuario;
    private int puntajeac;
    private String password;
    private String last_Login;
    private String correo;

    // TODO: Hacer consulta -> Mandar usuario

    public Integer getPuntajeac() {
        return puntajeac;
    }

    public void setPuntajeac(int puntajeac) {
        this.puntajeac = puntajeac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipo() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_Login() {
        return last_Login;
    }

    public void setLast_Login(String last_Login) {
        this.last_Login = last_Login;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
