public class Main {
    public static void main(String[] args) {
        // Criação do banco
        Banco banco = new Banco("Banco Exemplo");

        // Criação de clientes
        Cliente cliente1 = new Cliente("João Silva", 20, "123.456.789-00");
        Cliente cliente2 = new Cliente("Maria Souza", 16, "987.654.321-00");

        // Criação de contas
        try {
            ContaCorrente contaCorrente1 = new ContaCorrente(cliente1);
            banco.adicionarConta(contaCorrente1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            ContaPoupanca contaPoupanca2 = new ContaPoupanca(cliente2);
            banco.adicionarConta(contaPoupanca2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Operações bancárias
        Conta conta1 = banco.buscarContaPorNumero(1);
        if (conta1 != null) {
            conta1.depositar(500);
            conta1.imprimirExtrato();
        }

        Conta conta2 = banco.buscarContaPorNumero(2);
        if (conta2 != null) {
            conta2.depositar(200);
            conta2.imprimirExtrato();

            // Adicionar juros à conta poupança
            if (conta2 instanceof ContaPoupanca) {
                ((ContaPoupanca) conta2).adicionarJuros(5);
                conta2.imprimirExtrato();
            }
        }

        // Transferência entre contas
        if (conta1 != null && conta2 != null) {
            conta1.transferir(100, conta2);
            conta1.imprimirExtrato();
            conta2.imprimirExtrato();
        }

        // Exibir todas as contas do banco
        banco.imprimirContas();
    }
}
