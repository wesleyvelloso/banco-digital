import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class Banco {
    private static Banco instanciaUnica = new Banco();
    private Banco(){
    }
    public static Banco getInstance() {
        return instanciaUnica;
    }
    private String nome = "SantanDIO";

    private Double taxaSelic = 12.75;
    private List<Conta> contas = new ArrayList<>();
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public void infoBanco(){
        System.out.println("=== " +this.nome+" ===");
        System.out.println("Total de contas: " + contas.size());
        for (Conta conta: this.contas) {
            System.out.println(conta);
        }
    }


}
