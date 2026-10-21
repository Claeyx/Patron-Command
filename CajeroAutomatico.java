import java.util.ArrayDeque;
import java.util.Deque;

//Invoker.
public class CajeroAutomatico {
    private final Deque<Command> historial = new ArrayDeque<>();

    public void ejecutar(Command comando) {
        try {
            comando.ejecutar();
            historial.push(comando);
        } catch (RuntimeException e) {
            System.out.println("  Operación rechazada: " + e.getMessage());
        }
    }

    public void deshacerUltima() {
        if (historial.isEmpty()) {
            System.out.println("  No hay operaciones para deshacer.");
            return;
        }
        historial.pop().deshacer();
    }
}
