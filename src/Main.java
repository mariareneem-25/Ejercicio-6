import java.util.Scanner;

public class Main {

    private Controlador controlador;
    private Scanner scanner;

    public Principal(Controlador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Dashboard dashboard = new Dashboard();
        Controlador controlador = new Controlador(dashboard);
        Principal vista = new Principal(controlador);
        vista.iniciar();
    }

    public void iniciar() {
        System.out.println(controlador.cargarCatalogoInicial());
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            ejecutarOpcion(opcion);
        } while (opcion != 0);
        scanner.close();
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("===== DASHBOARD MODULAR =====");
        System.out.println("1. Listar widgets activos");
        System.out.println("2. Buscar widget por ID");
        System.out.println("3. Buscar widget por nombre");
        System.out.println("4. Ordenar widgets por memoria (KB)");
        System.out.println("5. Simular clic en todos los widgets");
        System.out.println("6. Simular actualización en tiempo real");
        System.out.println("0. Salir");
    }

    private void ejecutarOpcion(int opcion) {
        System.out.println();
        switch (opcion) {
            case 1:
                System.out.println(controlador.listarWidgets());
                break;
            case 2:
                int id = leerEntero("Ingrese el ID del widget: ");
                System.out.println(controlador.buscarPorId(id));
                break;
            case 3:
                System.out.print("Ingrese el nombre del widget: ");
                String nombre = scanner.nextLine().trim();
                System.out.println(controlador.buscarPorNombre(nombre));
                break;
            case 4:
                System.out.println(controlador.ordenarPorMemoria());
                break;
            case 5:
                System.out.println(controlador.hacerClicEnTodos());
                break;
            case 6:
                System.out.println(controlador.actualizarTodos());
                break;
            case 0:
                System.out.println("Hasta luego.");
                break;
            default:
                System.out.println("Opción no válida. Intente de nuevo.");
        }
    }

    private int leerEntero(String mensaje) {
        int numero = 0;
        boolean valido = false;
        do {
            System.out.print(mensaje);
            String texto = scanner.nextLine().trim();
            try {
                numero = Integer.parseInt(texto);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un número entero.");
            }
        } while (!valido);
        return numero;
    }
}
