import java.util.Objects;

public abstract class Widget implements Renderizable, Comparable<Widget> {

    private int id;
    private String nombre;
    private int memoriaKB;
    private boolean activo;

    public Widget(int id, String nombre, int memoriaKB) {
        this.id = id;
        this.nombre = nombre;
        this.memoriaKB = memoriaKB;
        this.activo = true;
    }

    public abstract String getConfiguracion();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMemoriaKB() {
        return memoriaKB;
    }

    public void setMemoriaKB(int memoriaKB) {
        this.memoriaKB = memoriaKB;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public int compareTo(Widget otro) {
        int resultado = Integer.compare(memoriaKB, otro.memoriaKB);
        if (resultado == 0) {
            resultado = nombre.compareToIgnoreCase(otro.nombre);
        }
        return resultado;
    }

    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) {
            return true;
        }
        if (objeto == null || getClass() != objeto.getClass()) {
            return false;
        }
        Widget otro = (Widget) objeto;
        return id == otro.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String estado = activo ? "Activo" : "Inactivo";
        return "ID " + id + " | " + nombre + " | " + getClass().getSimpleName() + " | " + memoriaKB + " KB | " + estado;
    }
}
