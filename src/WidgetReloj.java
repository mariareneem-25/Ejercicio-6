public class WidgetReloj extends WidgetInteractivo {

    private int hora;
    private int minuto;
    private String zona;
    private boolean formato24;

    public WidgetReloj(int id, String nombre, int memoriaKB, int hora, int minuto, String zona) {
        super(id, nombre, memoriaKB);
        this.hora = hora;
        this.minuto = minuto;
        this.zona = zona;
        this.formato24 = true;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public boolean isFormato24() {
        return formato24;
    }

    public void setFormato24(boolean formato24) {
        this.formato24 = formato24;
    }

    @Override
    public String renderizar() {
        if (formato24) {
            return String.format("[RELOJ] %02d:%02d (%s)", hora, minuto, zona);
        }
        int hora12 = hora % 12 == 0 ? 12 : hora % 12;
        String sufijo = hora < 12 ? "AM" : "PM";
        return String.format("[RELOJ] %02d:%02d %s (%s)", hora12, minuto, sufijo, zona);
    }

    @Override
    public String alHacerClic() {
        registrarInteraccion();
        formato24 = !formato24;
        return "Formato de hora cambiado: " + renderizar();
    }

    @Override
    public String actualizar() {
        registrarInteraccion();
        minuto++;
        if (minuto == 60) {
            minuto = 0;
            hora = (hora + 1) % 24;
        }
        return "Hora actualizada: " + renderizar();
    }

    @Override
    public String getConfiguracion() {
        String formato = formato24 ? "24 horas" : "12 horas";
        return "Zona: " + zona + " | Formato: " + formato;
    }
}
