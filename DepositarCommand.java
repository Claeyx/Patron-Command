// Concrete Command
public class DepositarCommand implements Command {
    private final CuentaBancaria cuenta;
    private final double monto;

    public DepositarCommand(CuentaBancaria cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cuenta.depositar(monto);
        System.out.println("  Depósito de $" + String.format("%,.2f", monto) + " en " + cuenta.getNumero());
    }

    @Override
    public void deshacer() {
        cuenta.retirar(monto);
        System.out.println("  Deshecho depósito de $" + String.format("%,.2f", monto) + " en " + cuenta.getNumero());
    }
}
