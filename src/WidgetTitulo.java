public class WidgetTitulo extends Widget {

    private String texto;
    private int tamanoFuente;

    public WidgetTitulo(int id, String nombre, int memoriaKB, String texto, int tamanoFuente) {
        super(id, nombre, memoriaKB);
        this.texto = texto;
        this.tamanoFuente = tamanoFuente;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getTamanoFuente() {
        return tamanoFuente;
    }

    public void setTamanoFuente(int tamanoFuente) {
        this.tamanoFuente = tamanoFuente;
    }

    @Override
    public String renderizar() {
        return "=== " + texto.toUpperCase() + " ===";
    }

    @Override
    public String getConfiguracion() {
        return "Texto: " + texto + " | Tamaño de fuente: " + tamanoFuente;
    }
}
