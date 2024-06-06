public class ContaPoupanca extends Conta{
    private double jurosRendidos;

    public ContaPoupanca(Cliente cliente) {
        super(cliente);
        this.jurosRendidos = 0.05;
    }

    public void adicionarJuros(double percentual){
        double juros = this.saldo * (percentual / 100);
        this.saldo += juros;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("==Extrato da Conta Poupança==");
        super.exibirAgeNumSaldo();
    }



}
