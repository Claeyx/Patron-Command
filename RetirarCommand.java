//Concrete command
public class RetirarCommand implements Command {
    private final CuentaBancaria cuenta;
    private final double monto;

    public RetirarCommand(CuentaBancaria cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cuenta.retirar(monto);
        System.out.println("  Retiro de $" + String.format("%,.2f", monto) + " en " + cuenta.getNumero());
    }

    @Override
    public void deshacer() {
        cuenta.depositar(monto);
        System.out.println("  Deshecho retiro de $" + String.format("%,.2f", monto) + " en " + cuenta.getNumero());
    }
}
