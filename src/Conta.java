import lombok.Data;

import javax.swing.*;
import java.time.LocalDateTime;

@Data
public class Conta implements IConta{
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo=0D;
    protected Cliente cliente;
    private LocalDateTime horaCriacao = LocalDateTime.now();

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

        Banco.getInstance().getContas().add(this);
    }

    public Conta(Cliente cliente, Integer agencia) {
        this.agencia = agencia;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

        Banco.getInstance().getContas().add(this);
    }

    @Override
    public void sacar(double valor) {
        try {
            if(this.saldo >= valor && valor>0) {
                saldo -= valor;
                JOptionPane.showMessageDialog(null,"Saque efetuado!  Novo Saldo: R$ "+this.saldo);
            }
            else if(valor<0){
                throw new BancoExceptions("Valor de saque invalido!");
            }else{
                throw new BancoExceptions("Transacao invalida --> Saldo insuficiente!");
            }
        } catch (BancoExceptions e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }

    @Override
    public void depositar(double valor) {
        try {
            if(valor > 0)
                saldo += valor;
            else
                throw new BancoExceptions("Valor de deposito invalido!");
        }catch (BancoExceptions e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
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
        System.out.println(String.format("Saldo: R$ %.2f", this.saldo));


    }
}
