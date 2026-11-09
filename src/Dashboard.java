import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dashboard {

    private ArrayList<Widget> widgets;

    public Dashboard() {
        widgets = new ArrayList<>();
    }

    public boolean agregar(Widget widget) {
        if (widget == null || widgets.contains(widget)) {
            return false;
        }
        widgets.add(widget);
        return true;
    }

    public List<Widget> getWidgets() {
        return Collections.unmodifiableList(widgets);
    }

    public int getCantidad() {
        return widgets.size();
    }

    public Widget buscar(int id) {
        for (Widget widget : widgets) {
            if (widget.getId() == id) {
                return widget;
            }
        }
        return null;
    }

    public Widget buscar(String nombre) {
        for (Widget widget : widgets) {
            if (widget.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                return widget;
            }
        }
        return null;
    }

    public void ordenarPorMemoria() {
        Collections.sort(widgets);
    }

    public String dibujar(Renderizable elemento) {
        return elemento.renderizar();
    }

    public String interactuar(Interactivo elemento, String evento) {
        if (evento.equalsIgnoreCase("actualizar")) {
            return elemento.actualizar();
        }
        return elemento.alHacerClic();
    }

    public String renderizarActivos() {
        StringBuilder resultado = new StringBuilder();
        for (Widget widget : widgets) {
            if (widget.isActivo()) {
                String tipo = widget instanceof Interactivo ? "Interactivo" : "Informativo";
                resultado.append("ID ").append(widget.getId()).append(" (").append(tipo).append(") ");
                resultado.append(dibujar(widget)).append("\n");
            }
        }
        return resultado.toString();
    }

    public String interactuarConTodos(String evento) {
        StringBuilder resultado = new StringBuilder();
        for (Widget widget : widgets) {
            resultado.append(widget.getNombre()).append(": ");
            if (widget instanceof Interactivo) {
                resultado.append(interactuar((Interactivo) widget, evento));
            } else {
                resultado.append("no soporta interacción, se omite");
            }
            resultado.append("\n");
        }
        return resultado.toString();
    }

    public String resumenMemoria() {
        StringBuilder resultado = new StringBuilder();
        int total = 0;
        for (Widget widget : widgets) {
            resultado.append(widget.getMemoriaKB()).append(" KB - ").append(widget.getNombre());
            resultado.append(" (ID ").append(widget.getId()).append(")\n");
            total += widget.getMemoriaKB();
        }
        resultado.append("Total: ").append(total).append(" KB");
        return resultado.toString();
    }

    @Override
    public String toString() {
        return "Dashboard con " + widgets.size() + " widgets";
    }
}
