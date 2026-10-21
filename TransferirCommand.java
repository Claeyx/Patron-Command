// Concrete command
public class TransferirCommand implements Command {
    private final CuentaBancaria origen;
    private final CuentaBancaria destino;
    private final double monto;

    public TransferirCommand(CuentaBancaria origen, CuentaBancaria destino, double monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        origen.transferir(destino, monto);
        System.out.println("  Transferencia de $" + String.format("%,.2f", monto)
            + " de " + origen.getNumero() + " a " + destino.getNumero());
    }

    @Override
    public void deshacer() {
        destino.transferir(origen, monto);
        System.out.println("  Deshecha transferencia de $" + String.format("%,.2f", monto)
            + " (" + destino.getNumero() + " -> " + origen.getNumero() + ")");
    }
}
