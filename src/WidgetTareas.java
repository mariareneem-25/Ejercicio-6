import java.util.ArrayList;

public class WidgetTareas extends WidgetInteractivo {

    private ArrayList<String> pendientes;
    private int completadas;

    public WidgetTareas(int id, String nombre, int memoriaKB, ArrayList<String> pendientes) {
        super(id, nombre, memoriaKB);
        this.pendientes = pendientes;
        this.completadas = 0;
    }

    public ArrayList<String> getPendientes() {
        return pendientes;
    }

    public void setPendientes(ArrayList<String> pendientes) {
        this.pendientes = pendientes;
    }

    public int getCompletadas() {
        return completadas;
    }

    public void setCompletadas(int completadas) {
        this.completadas = completadas;
    }

    @Override
    public String renderizar() {
        if (pendientes.isEmpty()) {
            return "[TAREAS] No hay tareas pendientes";
        }
        return "[TAREAS] Pendientes: " + String.join(", ", pendientes);
    }

    @Override
    public String alHacerClic() {
        registrarInteraccion();
        if (pendientes.isEmpty()) {
            return "No hay tareas pendientes para completar";
        }
        String tarea = pendientes.remove(0);
        completadas++;
        return "Tarea completada: " + tarea;
    }

    @Override
    public String actualizar() {
        registrarInteraccion();
        return "Lista sincronizada: " + pendientes.size() + " pendientes y " + completadas + " completadas";
    }

    @Override
    public String getConfiguracion() {
        return "Pendientes: " + pendientes.size() + " | Completadas: " + completadas;
    }
}
