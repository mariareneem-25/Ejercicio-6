public class WidgetGrafica extends Widget {

    private String titulo;
    private int[] valores;

    public WidgetGrafica(int id, String nombre, int memoriaKB, String titulo, int[] valores) {
        super(id, nombre, memoriaKB);
        this.titulo = titulo;
        this.valores = valores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int[] getValores() {
        return valores;
    }

    public void setValores(int[] valores) {
        this.valores = valores;
    }

    @Override
    public String renderizar() {
        StringBuilder grafica = new StringBuilder("[GRÁFICA] " + titulo + ": ");
        for (int valor : valores) {
            grafica.append("\n      ");
            for (int i = 0; i < valor / 10; i++) {
                grafica.append("#");
            }
            grafica.append(" ").append(valor);
        }
        return grafica.toString();
    }

    @Override
    public String getConfiguracion() {
        return "Título: " + titulo + " | Cantidad de valores: " + valores.length;
    }
}
