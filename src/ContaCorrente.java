public class ContaCorrente extends Conta {

    private Integer cartaoCredito;
    private Double anuidadeCartao = 12.0;

    public ContaCorrente(Cliente cliente) {
        super(cliente);
    }

    public ContaCorrente(Cliente cliente, Integer agencia) {
        super(cliente, agencia);
    }

    public ContaCorrente(Cliente cliente, Integer agencia, Integer cartaoCredito) {
        super(cliente, agencia);
        this.cartaoCredito = cartaoCredito;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Simplificado ===");
        System.out.println(" -- Conta Corrente --");
        super.imprimirInfosComuns();
        System.out.println("Cartao de credito: "+ this.cartaoCredito);
        System.out.println(String.format("Anuidade do cartao: R$ %.2f", this.anuidadeCartao));
        System.out.println("Data da criacao: " + super.getHoraCriacao().format(Banco.getInstance().formatador));
    }
}
