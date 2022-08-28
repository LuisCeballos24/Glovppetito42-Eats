package gg.rubit.data;

public class ConversationDataValues {

    private int id;
    private int lecciones_id;
    private int persona;
    private String dialogo;
    private String audio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLecciones_id() {
        return lecciones_id;
    }

    public void setLecciones_id(int lecciones_id) {
        this.lecciones_id = lecciones_id;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public String getDialog() {
        return dialogo;
    }

    public void setDialog(String dialog) {
        this.dialogo = dialog;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
