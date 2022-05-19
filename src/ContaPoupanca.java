public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente) {
        super(cliente,"Poupanca");  //new
    }
    public ContaPoupanca(Cliente cliente, Integer agencia) {
        super(cliente,"Poupanca", agencia);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Simplificado ===");
        System.out.println(" -- Conta "+ super.tipo +" --");
        super.imprimirInfosComuns();
    }
}
