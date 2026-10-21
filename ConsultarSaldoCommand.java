// Concrete command
public class ConsultarSaldoCommand implements Command {
    private final CuentaBancaria cuenta;

    public ConsultarSaldoCommand(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void ejecutar() {
        System.out.println("  Saldo de " + cuenta.getNumero() + ": $" + String.format("%,.2f", cuenta.consultar()));
    }

    @Override
    public void deshacer() {
        System.out.println("  Consultar saldo no se puede deshacer.");
    }
}
