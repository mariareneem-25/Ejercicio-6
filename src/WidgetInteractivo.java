public abstract class WidgetInteractivo extends Widget implements Interactivo {

    private int interacciones;

    public WidgetInteractivo(int id, String nombre, int memoriaKB) {
        super(id, nombre, memoriaKB);
        this.interacciones = 0;
    }

    protected void registrarInteraccion() {
        interacciones++;
    }

    public int getInteracciones() {
        return interacciones;
    }

    public void setInteracciones(int interacciones) {
        this.interacciones = interacciones;
    }

    @Override
    public String toString() {
        return super.toString() + " | Interacciones: " + interacciones;
    }
}
