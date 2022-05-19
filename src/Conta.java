import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected String tipo; // new
    protected double saldo;
    protected Cliente cliente;
    private LocalDateTime horaCriacao = LocalDateTime.now();

    public Conta(Cliente cliente, String tipo) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.tipo = tipo;
        this.cliente = cliente;

        Banco.getInstance().getContas().add(this);
    }

    public Conta(Cliente cliente, String tipo, Integer agencia) { // new - sobregarga
        this.agencia = agencia;
        this.numero = SEQUENCIAL++;
        this.tipo = tipo;
        this.cliente = cliente;
        Banco.getInstance().getContas().add(this);
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    @Override
    public void imprimirExtrato() {

    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
        System.out.println("Data da criacao: " + this.horaCriacao.format(Banco.getInstance().formatador));

    }
}
