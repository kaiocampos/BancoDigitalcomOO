import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome){
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta){
        for (Conta c : contas){
            if(c.getCliente().getCpf().equals(conta.getCliente().getCpf())){
                if(c instanceof ContaCorrente && conta instanceof ContaCorrente){
                    throw new IllegalArgumentException("Cliente já possui uma conta corrente!Sugestão: Abra uma conta poupança.");
                } else if (c instanceof ContaPoupanca && conta instanceof ContaPoupanca) {
                    throw new IllegalArgumentException("Cliente já possui uma conta poupanca!");
                }
            }
        }
        contas.add(conta);
    }

    public Conta buscarContaPorNumero(int numero){
        for (Conta conta : contas){
            if (conta.getNumero() == numero){
                return conta;
            }
        }
        return null;
    }

    public void imprimirContas(){
        for (Conta conta: contas){
            System.out.println("-----------------------------------");
            conta.imprimirExtrato();
            System.out.println("-----------------------------------");
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return contas;
    }
}
