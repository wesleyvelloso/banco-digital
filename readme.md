
### Nas classes Banco, Conta e Cliente foram adicionadas as anotações @Data da biblioteca Lombok, para redução de verbosidade.



### Criada a classe de exceções "BancoExceptions" que é invocada na ocorrência de exceções nas transações bancárias.

### Classe Banco:

 - Implementado o padrão criacional singleton. Decidi isso pois é uma classe de instância única e que serve como ponto global de acesso.

 - Adicionado o atributo "taxaSelic" para cálculo de rendimento de poupança;

 - Adicionado o objeto "formatador" da classe DataTimeFormatter. Serve para formatação das datas de criação das contas no tipo Dia/Mês/Ano - Horas:Minutos:Segundos. Decidi instanciá-lo na classe Banco pois é de uso genérico, global;

 - Implementado o método "InfoBanco". Mostra os atributos da classe Banco e lista todas as contas vinculadas.

Classe Cliente:

 - Adicionados os atributos "cpf" e "endereco";
 - Adicionado construtor.

### Classe Conta:

- Adicionado o objeto "horaCriacao" da classe LocalDateTime. É instanciado para todo objeto da classe Conta e armazena a data e hora de criação da conta.

- Adicionada sobrecarga de construtor. Dá a opção de se criar uma conta informando uma agência específica;

- Nos construtores, adicionada inserção das contas recém criadas na lista de contas da classe Banco;

- No método "sacar", foi adicionada a condição de retirar apenas se o saldo for maior ou igual a quantia, e se a quantia solicitada for um valor válido (pode haver valor negativo). Se uma dessas condições não forem satisfeitas, é lançada a exceção "BancoExceptions" com uma mensagem pertinente;

- No método "depositar", foi adicionado de maneira análoga a condição de valor inválido.
Para a classe ContaCorrente:

### Classe ContaCorrente:

- Adicionados atributos "cartaoCredito" e "anuidadeCartao", que diferenciam a conta corrente da conta poupança (irmã) e da conta genérica (mãe);
- Adicionadas sobrecargas de construtor. Dá a opção de se criar uma conta corrente informando uma agência específica e um número de cartão de crédito.

### Classe ContaPoupanca:

- Adicionada sobrecargas de construtor. Dá a opção de se criar uma conta poupanca informando uma agência específica
- Adicionado método "getRendimento". Retorna o rendimento mensal da poupança, através da taxa Selic contida na classe Banco. Se a Selic estiver abaixo de 8.5%, o rendimento é de 5% . Caso contrário, o rendimento é de 70% da Selic.
