package poo;

public class ContaJuridica extends Conta {
    
    private long cnpj;
    
    public ContaJuridica(int numero, double saldo, long cnpj) {
        super(numero, saldo);
        this.cnpj = cnpj;
    }
        
    @Override
    public void sacar(double valor){
        super.sacar(valor * 1.30);
    }
    
    @Override
    public void depositar(double valor){
        super.depositar(valor * 1.40);
    }
    
    @Override
    public void print(){
        super.print(); //reuso de código
        System.out.println("CNPJ: " + cnpj);
    }
    
}
