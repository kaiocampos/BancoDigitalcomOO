public class ContaCorrente extends Conta {
    private double limiteCredito;

    public ContaCorrente(Cliente cliente) {
            super(cliente);
            if (cliente.getIdade() < 18){
                throw new IllegalArgumentException("O Cliente deve ser maior de 18 anos para abrir uma conta corrente.");
            }
            this.limiteCredito = 300.0;
            this.saldo += limiteCredito;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("==Extrato da Conta Corrente==");
        exibirAgeNumSaldo();
    }
}
