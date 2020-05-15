package poo;

public class ContaFisica extends Conta {
    
    private long cpf;
    
    public ContaFisica(int numero, double saldo, long cpf) {
        super(numero, saldo);
        this.cpf = cpf;
    }
    
    @Override
    public void sacar(double valor){
        super.sacar(valor * 1.2);
    }
    
    @Override
    public void depositar(double valor){
        super.depositar(valor * 1.15);
    }
    
    @Override
    public void print(){
        super.print(); //reuso de código
        System.out.println("CPF: " + cpf);
    }
    
}
