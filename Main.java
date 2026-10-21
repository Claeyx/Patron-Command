public class Main {
    public static void main(String[] args) {
        CuentaBancaria ana  = new CuentaBancaria("001", "Ana",  500_000);
        CuentaBancaria luis = new CuentaBancaria("002", "Luis", 200_000);
        CajeroAutomatico cajero = new CajeroAutomatico();

        System.out.println("Estado inicial: " + ana + " | " + luis);

        System.out.println("\n1) Depositar");
        cajero.ejecutar(new DepositarCommand(ana, 150_000));

        System.out.println("\n2) Retirar");
        cajero.ejecutar(new RetirarCommand(ana, 100_000));

        System.out.println("\n3) Transferir");
        cajero.ejecutar(new TransferirCommand(ana, luis, 250_000));

        System.out.println("\n4) Consultar saldo");
        cajero.ejecutar(new ConsultarSaldoCommand(ana));
        cajero.ejecutar(new ConsultarSaldoCommand(luis));

        System.out.println("\n5) Retiro rechazado, supera el saldo");
        cajero.ejecutar(new RetirarCommand(luis, 9_000_000));

        System.out.println("\n6) Deshacer");
        cajero.deshacerUltima();
        System.out.println("   Deshacer la anterior");
        cajero.deshacerUltima();
        System.out.println("   Deshacer la transferencia");
        cajero.deshacerUltima();

        System.out.println("\nEstado final: " + ana + " | " + luis);
    }
}
