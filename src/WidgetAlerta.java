public class WidgetAlerta extends WidgetInteractivo {

    private String mensaje;
    private String nivel;

    public WidgetAlerta(int id, String nombre, int memoriaKB, String mensaje, String nivel) {
        super(id, nombre, memoriaKB);
        this.mensaje = mensaje;
        this.nivel = nivel;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @Override
    public String renderizar() {
        return "[ALERTA " + nivel + "] " + mensaje;
    }

    @Override
    public String alHacerClic() {
        registrarInteraccion();
        setActivo(false);
        return "Alerta descartada: " + mensaje;
    }

    @Override
    public String actualizar() {
        registrarInteraccion();
        setActivo(true);
        return "Nuevo evento recibido, alerta activa: " + mensaje;
    }

    @Override
    public String getConfiguracion() {
        return "Mensaje: " + mensaje + " | Nivel: " + nivel;
    }
}
