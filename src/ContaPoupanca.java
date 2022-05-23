public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }
    public ContaPoupanca(Cliente cliente, Integer agencia) {

        super(cliente,agencia);
    }

    private Double getRendimento(){
        Double selicAtual = Banco.getInstance().getTaxaSelic() ;

        if(selicAtual > 8.5)
            return this.saldo * 0.05;
        else
            return this.saldo * (0.7 * selicAtual);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Simplificado ===");
        System.out.println(" --- Conta Poupanca ---");
        super.imprimirInfosComuns();
        System.out.println("Taxa Selic atual: "+ Banco.getInstance().getTaxaSelic() + "%");
        System.out.println(String.format("Rendimento mensal: R$ %.2f", this.getRendimento()));
        System.out.println("Data da criacao: " + super.getHoraCriacao().format(Banco.getInstance().formatador));
    }

}
