// Receiver
public class CuentaBancaria {
    private final String numero;
    private final String titular;
    private double saldo;

    public CuentaBancaria(String numero, String titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        validarMonto(monto);
        saldo += monto;
    }

    public void retirar(double monto) {
        validarMonto(monto);
        if (monto > saldo) {
            throw new SaldoInsuficienteException(
                "Saldo insuficiente en cuenta " + numero + ": saldo=" + saldo + ", monto=" + monto);
        }
        saldo -= monto;
    }

    public void transferir(CuentaBancaria destino, double monto) {
        this.retirar(monto);       // si falla, no se deposita nada
        destino.depositar(monto);
    }

    public double consultar() {
        return saldo;
    }

    private void validarMonto(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser positivo: " + monto);
        }
    }

    public String getNumero()  { return numero; }
    public String getTitular() { return titular; }

    @Override
    public String toString() {
        return titular + " [" + numero + "] saldo=$" + String.format("%,.2f", saldo);
    }
}
