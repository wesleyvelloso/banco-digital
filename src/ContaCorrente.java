public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente) {
        super(cliente, "Corrente");  // new
    }
    public ContaCorrente(Cliente cliente, Integer agencia) {
        super(cliente,"Corrente", agencia);
    }


    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Simplificado ===");
        System.out.println(" -- Conta "+ super.tipo +" --");
        super.imprimirInfosComuns();
    }
}
