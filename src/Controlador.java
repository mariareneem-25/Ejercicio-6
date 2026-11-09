import java.util.ArrayList;
import java.util.Arrays;

public class Controlador {

    private Dashboard dashboard;

    public Controlador(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public String cargarCatalogoInicial() {
        dashboard.agregar(new WidgetLogo(1, "Logo empresarial", 120, "TechNova"));
        dashboard.agregar(new WidgetTitulo(2, "Título de bienvenida", 60, "Panel de control principal", 24));
        dashboard.agregar(new WidgetGrafica(3, "Gráfica de ventas", 340, "Ventas por trimestre", new int[]{40, 70, 55, 90}));
        dashboard.agregar(new WidgetGrafica(4, "Gráfica de visitas", 310, "Visitas por semana", new int[]{30, 20, 80, 60}));
        dashboard.agregar(new WidgetClima(5, "Clima Guatemala", 150, "Guatemala", 24, "Soleado"));
        dashboard.agregar(new WidgetClima(6, "Clima Antigua", 145, "Antigua Guatemala", 21, "Nublado"));
        dashboard.agregar(new WidgetTareas(7, "Tareas de trabajo", 200,
                new ArrayList<>(Arrays.asList("Enviar informe", "Revisar correos", "Reunión con el equipo"))));
        dashboard.agregar(new WidgetTareas(8, "Tareas de estudio", 190,
                new ArrayList<>(Arrays.asList("Estudiar para el parcial", "Entregar el ejercicio"))));
        dashboard.agregar(new WidgetAlerta(9, "Alerta de servidor", 90, "El servidor supera el 90% de uso", "ALTO"));
        dashboard.agregar(new WidgetAlerta(10, "Alerta de inventario", 85, "Quedan pocas unidades en bodega", "MEDIO"));
        dashboard.agregar(new WidgetReloj(11, "Reloj Guatemala", 70, 14, 30, "Guatemala"));
        dashboard.agregar(new WidgetReloj(12, "Reloj Madrid", 75, 21, 59, "Madrid"));
        return "Catálogo cargado con " + dashboard.getCantidad() + " widgets.";
    }

    public String listarWidgets() {
        return dashboard.renderizarActivos();
    }

    public String buscarPorId(int id) {
        Widget widget = dashboard.buscar(id);
        if (widget == null) {
            return "No se encontró ningún widget con el ID " + id + ".";
        }
        return widget.toString() + "\nConfiguración: " + widget.getConfiguracion();
    }

    public String buscarPorNombre(String nombre) {
        Widget widget = dashboard.buscar(nombre);
        if (widget == null) {
            return "No se encontró ningún widget con el nombre \"" + nombre + "\".";
        }
        return widget.toString() + "\nConfiguración: " + widget.getConfiguracion();
    }

    public String ordenarPorMemoria() {
        dashboard.ordenarPorMemoria();
        return "Widgets ordenados por memoria (de menor a mayor):\n" + dashboard.resumenMemoria();
    }

    public String hacerClicEnTodos() {
        return dashboard.interactuarConTodos("clic");
    }

    public String actualizarTodos() {
        return dashboard.interactuarConTodos("actualizar");
    }
}
