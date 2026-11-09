public class WidgetLogo extends Widget {

    private String empresa;

    public WidgetLogo(int id, String nombre, int memoriaKB, String empresa) {
        super(id, nombre, memoriaKB);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public String renderizar() {
        return "[LOGO] " + empresa;
    }

    @Override
    public String getConfiguracion() {
        return "Empresa: " + empresa;
    }
}
