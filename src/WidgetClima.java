public class WidgetClima extends WidgetInteractivo {

    private String ciudad;
    private int temperatura;
    private String condicion;

    public WidgetClima(int id, String nombre, int memoriaKB, String ciudad, int temperatura, String condicion) {
        super(id, nombre, memoriaKB);
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.condicion = condicion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    @Override
    public String renderizar() {
        return "[CLIMA] " + ciudad + ": " + temperatura + " grados, " + condicion;
    }

    @Override
    public String alHacerClic() {
        registrarInteraccion();
        return "Pronóstico de " + ciudad + " para mañana: " + (temperatura + 1) + " grados";
    }

    @Override
    public String actualizar() {
        registrarInteraccion();
        temperatura++;
        return "Clima de " + ciudad + " actualizado a " + temperatura + " grados";
    }

    @Override
    public String getConfiguracion() {
        return "Ciudad: " + ciudad + " | Temperatura: " + temperatura + " | Condición: " + condicion;
    }
}
