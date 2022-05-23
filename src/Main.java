import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Cliente wesley = new Cliente("Wesley","11429853697","Travessa Neco Veloso 189");
        Conta cc = new ContaCorrente(wesley,7);
        Conta poupanca = new ContaPoupanca(wesley);

        cc.depositar(100);
        cc.transferir(100, poupanca);
        cc.imprimirExtrato();

        poupanca.imprimirExtrato();
        Banco.getInstance().infoBanco();
        cc.sacar(100);
        //.depositar(-100);

    }
}
